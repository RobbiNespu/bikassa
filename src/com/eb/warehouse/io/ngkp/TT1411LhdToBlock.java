package com.eb.warehouse.io.ngkp;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by eb on 21.05.2015.
 */
public final class TT1411LhdToBlock {

    // External location (rack's location)
    private final int aisle;
    private final int x;
    private final int y;
    private final int side;
    private final int depth;
    // SRM's location
    private final int srmNumber;
    private final int lhdNumber;
    private final int locationOnLhd;
    private final int tuAmount;
    private final TT1411.OrderType order;
    private final int orderExtension;
    private final TT1411.OrderAck ack;
    private final int ackExtension;
    private final ImmutableSet<TT1411TuBlock> tuBlocks;

    private TT1411LhdToBlock(Builder b) {
        aisle = b.aisle;
        x = b.x;
        y = b.y;
        side = b.side;
        depth = b.depth;
        srmNumber = b.srmNumber;
        lhdNumber = b.lhdNumber;
        locationOnLhd = b.locationOnLhd;
        tuAmount = b.tuAmount;
        order = b.order;
        orderExtension = b.orderExtension;
        ack = b.ack;
        ackExtension = b.ackExtension;
        tuBlocks = ImmutableSet.copyOf(b.tuBlocks);
    }

    public int getAisle() {
        return aisle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSide() {
        return side;
    }

    public int getDepth() {
        return depth;
    }

    public int getSrmNumber() {
        return srmNumber;
    }

    public int getLhdNumber() {
        return lhdNumber;
    }

    public int getLocationOnLhd() {
        return locationOnLhd;
    }

    public int getTuAmount() {
        return tuAmount;
    }

    public TT1411.OrderType getOrder() {
        return order;
    }

    public int getOrderExtension() {
        return orderExtension;
    }

    public TT1411.OrderAck getAck() {
        return ack;
    }

    public int getAckExtension() {
        return ackExtension;
    }

    public ImmutableSet<TT1411TuBlock> getTuBlocks() {
        return tuBlocks;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("aisle", aisle).add("x", x).add("y", y).add("side", side)
                .add("srmNo", srmNumber).add("lhdNo", lhdNumber).add("locOnLhd", locationOnLhd)
                .add("tuAmount", tuAmount).add("order", order).add("orderExt", orderExtension).add("ack", ack)
                .add("ackExt", ackExtension).add("tuBlocks", tuBlocks).toString();
    }

    public static final class Builder {

        private final Set<TT1411TuBlock> tuBlocks = Sets.newHashSet();
        // External location (rack's location)
        private int aisle;
        private int x;
        private int y;
        private int side;
        private int depth;
        // SRM's location
        private int srmNumber;
        private int lhdNumber;
        private int locationOnLhd;
        private int tuAmount;
        private TT1411.OrderType order;
        private int orderExtension;
        private TT1411.OrderAck ack;
        private int ackExtension;

        public int getAisle() {
            return aisle;
        }

        public Builder aisle(int aisle) {
            this.aisle = aisle;
            return this;
        }

        public int getX() {
            return x;
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public int getY() {
            return y;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public int getSide() {
            return side;
        }

        public Builder side(int side) {
            this.side = side;
            return this;
        }

        public int getDepth() {
            return depth;
        }

        public Builder depth(int depth) {
            this.depth = depth;
            return this;
        }

        public int getSrmNumber() {
            return srmNumber;
        }

        public Builder srmNumber(int srmNumber) {
            this.srmNumber = srmNumber;
            return this;
        }

        public int getLhdNumber() {
            return lhdNumber;
        }

        public Builder lhdNumber(int lhdNumber) {
            this.lhdNumber = lhdNumber;
            return this;
        }

        public int getLocationOnLhd() {
            return locationOnLhd;
        }

        public Builder locationOnLhd(int locationOnLhd) {
            this.locationOnLhd = locationOnLhd;
            return this;
        }

        public int getTuAmount() {
            return tuAmount;
        }

        public Builder tuAmount(int tuAmount) {
            this.tuAmount = tuAmount;
            return this;
        }

        public TT1411.OrderType getOrder() {
            return order;
        }

        public Builder order(TT1411.OrderType order) {
            this.order = order;
            return this;
        }

        public int getOrderExtension() {
            return orderExtension;
        }

        public Builder orderExtension(int orderExtension) {
            this.orderExtension = orderExtension;
            return this;
        }

        public TT1411.OrderAck getAck() {
            return ack;
        }

        public Builder ack(TT1411.OrderAck ack) {
            this.ack = ack;
            return this;
        }

        public int getAckExtension() {
            return ackExtension;
        }

        public Builder ackExtension(int ackExtension) {
            this.ackExtension = ackExtension;
            return this;
        }

        public Builder addTuBlock(TT1411TuBlock tuBlock) {
            tuBlocks.add(tuBlock);
            return this;
        }

        public Builder clearTuBlocks() {
            tuBlocks.clear();
            return this;
        }

        public boolean removeTuBlock(TT1411TuBlock tuBlock) {
            return tuBlocks.remove(tuBlock);
        }

        public TT1411LhdToBlock build() {
            return new TT1411LhdToBlock(this);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("aisle", aisle).add("x", x).add("y", y).add("side", side)
                    .add("srmNo", srmNumber).add("lhdNo", lhdNumber).add("locOnLhd", locationOnLhd)
                    .add("tuAmount", tuAmount).add("order", order).add("orderExt", orderExtension).add("ack", ack)
                    .add("ackExt", ackExtension).add("tuBlocks", tuBlocks).toString();
        }
    }
}
