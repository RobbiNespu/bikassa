package com.eb.warehouse.io.ngkp;

/**
 * Created by eb on 19.05.2015.
 */
public interface NgkpTelegramParser {

    NgkpTelegram parseFromBytes(byte[] buffer);
}
