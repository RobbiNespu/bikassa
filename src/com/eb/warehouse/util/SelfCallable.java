package com.eb.warehouse.util;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import java.util.concurrent.Callable;

/**
 * A task that can submit itself to a {@link com.google.common.util.concurrent.ListeningExecutorService}.
 * <p>It makes it for the task possible to get rid of cancel requests, interrupt itself and free
 * internal resources.</p>
 */
public interface SelfCallable<T> extends Callable<T> {

  ListenableFuture<T> submitTo(ListeningExecutorService runner);
}
