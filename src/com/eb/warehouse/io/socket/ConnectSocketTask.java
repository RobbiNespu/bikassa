package com.eb.warehouse.io.socket;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

interface ConnectSocketTask extends Callable<Socket> {

  ListenableFuture<Socket> submitTo(ListeningExecutorService runner);
}
