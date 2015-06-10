package com.eb.warehouse.io.ngkp;

import com.google.common.base.MoreObjects;

/**
 * Created by eb on 19.05.2015.
 */
public final class NgkpPayloadHeader {

    private final int senderId;
    private final int receiverId;
    private final int telegramType;
    private final int telegramSubType;
    private final int version;
    private final int requestId;
    private final int producerId;
    private final int port;

    private NgkpPayloadHeader(Builder b) {
        senderId = b.senderId;
        receiverId = b.receiverId;
        telegramType = b.telegramType;
        telegramSubType = b.telegramSubType;
        version = b.version;
        requestId = b.requestId;
        producerId = b.producerId;
        port = b.port;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public int getTelegramType() {
        return telegramType;
    }

    public int getTelegramSubType() {
        return telegramSubType;
    }

    public int getVersion() {
        return version;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getProducerId() {
        return producerId;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("senderId", senderId).add("recId", receiverId)
                .add("telegramType", telegramSubType).add("telegramSubType", telegramSubType).add("vers", version)
                .add("reqId", requestId).add("prodId", producerId).add("port", port).toString();
    }

    public static final class Builder {

        private int senderId;
        private int receiverId;
        private int telegramType;
        private int telegramSubType;
        private int version;
        private int requestId;
        private int producerId;
        private int port;

        public int getSenderId() {
            return senderId;
        }

        public Builder senderId(int senderId) {
            this.senderId = senderId;
            return this;
        }

        public int getReceiverId() {
            return receiverId;
        }

        public Builder receiverId(int receiverId) {
            this.receiverId = receiverId;
            return this;
        }

        public int getTelegramType() {
            return telegramType;
        }

        public Builder telegramType(int telegramType) {
            this.telegramType = telegramType;
            return this;
        }

        public int getTelegramSubType() {
            return telegramSubType;
        }

        public Builder telegramSubType(int telegramSubType) {
            this.telegramSubType = telegramSubType;
            return this;
        }

        public int getVersion() {
            return version;
        }

        public Builder version(int version) {
            this.version = version;
            return this;
        }

        public int getRequestId() {
            return requestId;
        }

        public Builder requestId(int requestId) {
            this.requestId = requestId;
            return this;
        }

        public int getProducerId() {
            return producerId;
        }

        public Builder producerId(int producerId) {
            this.producerId = producerId;
            return this;
        }

        public int getPort() {
            return port;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public NgkpPayloadHeader build() {
            return new NgkpPayloadHeader(this);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("senderId", senderId).add("recId", receiverId)
                    .add("telegramType", telegramSubType).add("telegramSubType", telegramSubType)
                    .add("vers", version).add("reqId", requestId).add("prodId", producerId).add("port", port).toString();
        }
    }
}
