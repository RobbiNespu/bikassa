package com.eb.warehouse.io.socket;

import java.io.InputStream;
import java.util.concurrent.Callable;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

interface ReadSocketTaskFactory {

  Callable<Void> createReadSocketInputStreamTask(InputStream socketInputStream);
}
