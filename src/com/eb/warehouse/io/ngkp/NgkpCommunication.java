package com.eb.warehouse.io.ngkp;

import com.google.common.util.concurrent.Service;

import com.eb.warehouse.io.ngkp.message.TT1411;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

/**
 * Created by ebe on 25.03.2015.
 */
final class NgkpCommunication extends NgkpMessageSender implements Service {

  private final Set<Ngkp2Connection> connections;

  @Inject
  NgkpCommunication(Set<Ngkp2Connection> connections) {
    this.connections = connections;
  }

  @Override
  public void sendTT1430Message(TT1411 message) {
  }

  @Override
  public Service startAsync() {
    return null;
  }

  @Override
  public boolean isRunning() {
    return false;
  }

  @Override
  public State state() {
    return null;
  }

  @Override
  public Service stopAsync() {
    return null;
  }

  @Override
  public void awaitRunning() {

  }

  @Override
  public void awaitRunning(long l, TimeUnit timeUnit) throws TimeoutException {

  }

  @Override
  public void awaitTerminated() {

  }

  @Override
  public void awaitTerminated(long l, TimeUnit timeUnit) throws TimeoutException {

  }

  @Override
  public Throwable failureCause() {
    return null;
  }

  @Override
  public void addListener(Listener listener, Executor executor) {

  }
}
