package com.eb.warehouse.io.socket;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.net.InetAddresses;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import com.eb.warehouse.io.socket.AutoConnectSocketConnection.ConnectSocketCallback;
import com.eb.warehouse.io.socket.AutoConnectSocketConnection.ReadSocketCallback;
import com.eb.warehouse.util.SelfCallable;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class PermanentSocketConnectionTest {

  private AutoConnectSocketConnection connection;
  private ListeningExecutorService connectAndReadRunner;
  private SelfCallable<Socket> connectSocketTask;
  private ReadSocketTaskFactory readSocketTaskFactory;
  private EventBus socketConnectEvents;
  private FutureCallback<Socket> connectSocketCallback;
  private FutureCallback<Void> readSocketCallback;
  private Socket socket;
  private ListenableFuture<Socket> connectFuture;

  @SuppressWarnings("unchecked")
  @Before
  public void setUp() {
    connectAndReadRunner = MoreExecutors.newDirectExecutorService();
    connectSocketTask = mock(SelfCallable.class);
    connectSocketCallback = mock(FutureCallback.class);
    connectFuture = mock(ListenableFuture.class);
    readSocketTaskFactory = mock(ReadSocketTaskFactory.class);
    readSocketCallback = mock(FutureCallback.class);
    socketConnectEvents = new EventBus();
    connection =
        new AutoConnectSocketConnection(connectAndReadRunner, connectSocketTask,
            readSocketTaskFactory, socketConnectEvents, connectSocketCallback, readSocketCallback);

    socket = mock(Socket.class);
  }

  @Test
  public void startConnection_succeedsConnectingToSocket() throws Exception {
    ListenableFuture<Socket> future = Futures.immediateFuture(socket);
    when(connectSocketTask.submitTo(any(ListeningExecutorService.class))).thenReturn(future);
    connection.startAsync2();
    verify(connectSocketCallback).onSuccess(eq(socket));
  }

  @Test
  public void startConnection_failsConnectingToSocket() throws Exception {
    Exception fakeConnectException = new Exception();
    ListenableFuture<Socket> future = Futures.immediateFailedFuture(fakeConnectException);
    when(connectSocketTask.submitTo(any(ListeningExecutorService.class))).thenReturn(future);
    connection.startAsync2();
    verify(connectSocketCallback).onFailure(eq(fakeConnectException));
  }

  @Test
  public void stopConnection_doesNothingBecauseSocketNotConnectedNorConnecting() throws IOException {
    connection.stop2();
    verify(connectFuture, times(0)).cancel(anyBoolean());
    verify(socket, times(0)).close();
  }

  @Test
  public void stopConnection_stopsConnectingAndClosesSocket() throws IOException {
    connection.setSocketAndConnecting(socket, connectFuture);
    connection.stop2();
    verify(connectFuture).cancel(eq(true));
    verify(socket).close();
  }

  @Test
  public void stopConnection_closesSocketOnlyBecauseNotConnecting() throws IOException {
    connection.setSocketAndConnecting(socket, null);
    connection.stop2();
    verify(connectFuture, times(0)).cancel(eq(true));
    verify(socket).close();
  }

  @Test
  public void onConnectSuccess_startSocketReadingTask() throws Exception {
    InputStream fakeInputStream = mock(InputStream.class);
    when(socket.getInputStream()).thenReturn(fakeInputStream);
    String hostname = "10.10.10.10";
    InetAddress address = InetAddresses.forString(hostname);
    when(socket.getInetAddress()).thenReturn(address);
    int port = 99;
    when(socket.getPort()).thenReturn(port);
    @SuppressWarnings("unchecked")
    Callable<Void> fakeCallable = mock(Callable.class);
    when(readSocketTaskFactory.createReadSocketInputStreamTask(any(InputStream.class))).thenReturn(
        fakeCallable);
    final AtomicReference<InetSocketAddress> connectedEvent =
        new AtomicReference<InetSocketAddress>();
    socketConnectEvents.register(new Object() {
      @Subscribe
      public void assertConnectedEvent(InetSocketAddress connectedAddress) {
        connectedEvent.set(connectedAddress);
      }
    });
    ConnectSocketCallback callback = connection.new ConnectSocketCallback();
    callback.onSuccess(socket);
    verify(readSocketTaskFactory).createReadSocketInputStreamTask(eq(fakeInputStream));
    verify(fakeCallable).call();
    verify(readSocketCallback).onSuccess(null);
    assertEquals(new InetSocketAddress(hostname, port), connectedEvent.get());
  }

  @Test
  public void onConnectSuccess_getInputStreamThrowsException_closesActualSocketAndReconnect()
      throws Exception {
    when(socket.getInputStream()).thenThrow(new IOException());
    final AtomicBoolean connectedEvent = new AtomicBoolean();
    socketConnectEvents.register(new Object() {
      @Subscribe
      public void assertConnectedEvent(InetSocketAddress connectedAddress) {
        connectedEvent.set(true);
      }
    });
    Socket anotherSocket = mock(Socket.class);
    ListenableFuture<Socket> future = Futures.immediateFuture(anotherSocket);
    when(connectSocketTask.submitTo(any(ListeningExecutorService.class))).thenReturn(future);

    ConnectSocketCallback callback = connection.new ConnectSocketCallback();
    callback.onSuccess(socket);
    verify(socket).close();
    verify(readSocketTaskFactory, times(0)).createReadSocketInputStreamTask(null);
    verify(readSocketCallback, times(0)).onSuccess(null);
    assertFalse(connectedEvent.get());

    verify(connectSocketCallback).onSuccess(eq(anotherSocket));
  }

  @Test
  public void onConnectFail_doesNothing() throws IOException {
    ConnectSocketCallback callback = connection.new ConnectSocketCallback();
    connection.setSocketAndConnecting(socket, null);
    callback.onFailure(null);
    verify(socket, times(0)).close();
    verify(readSocketTaskFactory, times(0)).createReadSocketInputStreamTask(null);
    verify(readSocketCallback, times(0)).onSuccess(null);
  }

  @Test
  public void onReadSuccess_closesActualSocketAndReconnect() throws IOException {
    Socket anotherSocket = mock(Socket.class);
    ListenableFuture<Socket> future = Futures.immediateFuture(anotherSocket);
    when(connectSocketTask.submitTo(any(ListeningExecutorService.class))).thenReturn(future);

    connection.setSocketAndConnecting(socket, null);
    ReadSocketCallback callback = connection.new ReadSocketCallback();
    callback.onSuccess(null);
    verify(socket).close();
    verify(connectSocketCallback).onSuccess(eq(anotherSocket));
  }

  @Test
  public void writeToSocket_socketWriteThrowsException_closesCurrentSocketAndReconnect()
      throws IOException {
    Socket anotherSocket = mock(Socket.class);
    ListenableFuture<Socket> future = Futures.immediateFuture(anotherSocket);
    when(connectSocketTask.submitTo(any(ListeningExecutorService.class))).thenReturn(future);

    OutputStream os = mock(OutputStream.class);
    IOException writeException = new IOException();
    doThrow(writeException).when(os).write(any(byte[].class));
    connection.setSocketAndConnecting(socket, null);

    byte[] bytes = new byte[0];
    try {
      connection.writeToSocket(bytes);
      fail();
    } catch (IOException e) {
      assertEquals(writeException, e);
    }

    verify(socket).close();
    verify(connectSocketCallback).onSuccess(eq(anotherSocket));
  }

  @Test(expected = IOException.class)
  public void writeToSocket_connectionNotStarted_throwsException() throws IOException {
    connection.writeToSocket(null);
  }
}
