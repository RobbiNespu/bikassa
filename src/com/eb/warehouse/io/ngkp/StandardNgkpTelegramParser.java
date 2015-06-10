package com.eb.warehouse.io.ngkp;

/**
 * Created by eb on 20.05.2015.
 */
public class StandardNgkpTelegramParser implements NgkpTelegramParser {

    @Override
    public NgkpTelegram parseFromBytes(byte[] buffer) {
        Ngkp2Header.Builder ngkpHeader = new Ngkp2Header.Builder().telegramLength(Bytes2.shortFromBytes(buffer[0], buffer[1]))
                .destinationAddress(buffer[2] & 0xFF).telegramType((char) buffer[3]).telegramCounter((char) buffer[4])
                .protocolVersion(buffer[5]);

        return new NgkpTelegram.Builder().header(ngkpHeader).build();
    }
}
