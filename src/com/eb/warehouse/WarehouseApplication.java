package com.eb.warehouse;

import com.eb.warehouse.io.pcx.PcxConnections;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
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
    private final PcxConnections pcxConnections;
    private final ServiceManager serviceManager;

    @Inject
    public WarehouseApplication(PcxConnections pcxConnections) {
        this.pcxConnections = pcxConnections;
        serviceManager = new ServiceManager(ImmutableSet.of(pcxConnections));
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
        serviceManager.startAsync();
        /**
         * Blocks main thread until someone triggers shutdown of application.
         */
        Uninterruptibles.awaitUninterruptibly(appShutdownLatch);
        L.info("Stopping warehouse application.");
        serviceManager.stopAsync();
        serviceManager.awaitStopped();
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
        serviceManager.addListener(listener);
    }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
