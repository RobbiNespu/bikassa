package com.eb.warehouse;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.Uninterruptibles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.concurrent.CountDownLatch;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class WarehouseApplication implements ServerApplication {

    private static final Logger L = LoggerFactory.getLogger(WarehouseApplication.class);
    /**
     * Controls the shutdown of the {@link #run2()} method.
     */
    private final CountDownLatch appShutdownLatch = new CountDownLatch(1);
    private final ServiceManager hardwareCommunication;

    @Inject
    public WarehouseApplication(ServiceManager hardwareCommunication) {
        this.hardwareCommunication = hardwareCommunication;
    }

    @Override
    public void run2() {
        L.info("Starting warehouse application.");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                triggerStop2();
            }
        });
        hardwareCommunication.startAsync();
        /**
         * Blocks main thread until someone triggers shutdown of application.
         */
        Uninterruptibles.awaitUninterruptibly(appShutdownLatch);
        L.info("Stopping warehouse application.");
        hardwareCommunication.stopAsync();
        hardwareCommunication.awaitStopped();
        L.info("Stopped gracefully warehouse application.");
        // TODO: add timeout and shutdown hook listener.
    }

    /**
     * Trigger to stop the running warehouse application. If not running nothing is done.
     */
    @VisibleForTesting
    void triggerStop2() {
        appShutdownLatch.countDown();
    }

    @VisibleForTesting
    void addListener(ServiceManager.Listener listener) {
        hardwareCommunication.addListener(listener);
    }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
