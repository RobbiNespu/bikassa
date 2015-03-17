
package com.eb.warehouse;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class NgkpExample {

  /**
   * TODO JavaDoc according to WAMAS C conventions
   */
  public void startListeningForHardwareMessages() {
    //    for (PCXConnectionInfo pcxConnInfo : pcxConnectionInfos) {
    //      PCXConnection pcxConn = new PCXConnection(pcxConnInfo.getControllerName(), pcxConnInfo.getPort(), pcxConnInfo.getDecoder(), pcxConnInfo.getType(), this);
    //      try {
    //        pcxConn.start();
    //        pcxConnections.add(pcxConn);
    //      } catch (Exception e) {
    //        L.error("Couldn't connect to PCX '{}' on port {}.", pcxConnInfo.getControllerName(), pcxConnInfo.getPort());
    //      }
    //    }

    //    AsocConnectionCfg conMfs2Soc = Asoc.createNgkp2ConnectionCfg("mfs->soc", "localhost", 2011, 201, 115, true).setExecutionGroup("example");
    //    AsocConnectionCfg conSoc2Mfs = Asoc.createNgkp2ConnectionCfg("soc->mfs", "localhost", 2012, 201, 115, false).setExecutionGroup("example");
    //
    //    AsocThreadPoolExecutorFactory asocThreadPoolExecutorFactory = Asoc.createDefaultExecutorFactory();
    //    AsocConnectionRegistry connectionRegistry = Asoc.createSocketConnectionRegistry(asocThreadPoolExecutorFactory);
    //    connectionRegistry.configureConnection(conMfs2Soc, null);
    //    connectionRegistry.configureConnection(conSoc2Mfs, new AsocTelegramHandler() {
    //      @Override
    //      public boolean handleTelegram(InboundTelegram inboundTelegram) {
    //        System.out.println("Inbound telegram=" + inboundTelegram);
    //        String hex = ByteUtilities.toHex(inboundTelegram.getPayload());
    //        TT1434Version1 tt1434Version1 = new TT1434Version1();
    //        tt1434Version1.fromHex(hex);
    //        System.out.println(tt1434Version1);
    //        Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
    //        return true;
    //      }
    //    });
    //    asocThreadPoolExecutorFactory.startAll();
    //    Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

    //    OutboundTelegram outboundTelegram = new OutboundTelegram(new byte[] {0, 1, 2, 3, 4, 5, 6});
    //    try {
    //      connectionRegistry.getConnection(conMfs2Soc.getName()).sendTelegram(outboundTelegram, 1000L);
    //    } catch (SendTelegramException e) {
    //      System.out.println("waiting for acknowledge of telegram {} timed out causing exception: " + e);
    //    }
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
