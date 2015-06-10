package com.eb.warehouse.io.ngkp;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by eb on 20.05.2015.
 */
public final class TT1411 {

    private final int movementOptions;
    private final ImmutableSet<TT1411LhdToBlock> toBlocks;

    private TT1411(Builder b) {
        movementOptions = b.movementOptions;
        toBlocks = ImmutableSet.copyOf(b.toBlocks);
    }

    public int getMovementOptions() {
        return movementOptions;
    }

    public ImmutableSet<TT1411LhdToBlock> getToBlocks() {
        return toBlocks;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("movementOpts", movementOptions).add("toBlocks", toBlocks)
                .toString();
    }

    public enum OrderType {

        GET_ORDER(14011),
        PUT_ORDER(14021),
        FOLLOW_UP_GET_ORDER(14012),
        FOLLOW_UP_PUT_ORDER(14022),
        COMPLETION(14001),
        VOID_ORDER(14000),
        EMPTY_ORDER(0);

        private final int code;

        private OrderType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return "OrderType=" + code;
        }
    }

    public enum OrderAck {

        FO_EXPECTED(14281),
        TO_EXPECTED(14282),
        FORK_EMPTY(14271),
        FORK_NOT_ENOUGH_TUS(14272),
        FORK_TOO_MUCH_TUS(14273),
        TU_ID_MISMATCH(14253),
        TU_TYPE_MISMATCH(14254),
        MISSING_STORAGE_SIGNAL(14231),
        MISSING_RETRIEVAL_SIGNAL(14232),
        GENERAL_PLAUSIBILITY_ERROR(14160),
        SUBTYPE_ERROR(14103),
        VERSION_ERROR(14104),
        LENGTH_ERROR(14144),
        WIDTH_ERROR(14145),
        HEIGHT_ERROR(14146),
        WEIGHT_ERROR(14147),
        POSITIONING_ORDER(14031),
        FOLLOW_UP_POSITIONING_ORDER(14032),
        FORK_CLEARANCE_ORDER(14023),
        RACK_CLEARANCE_ORDER(14013),
        WRONG_AISLE_NUMBER(14121),
        WRONG_X_COORDINATE(14122),
        WRONG_Y_COORDINATE(14123),
        WRONG_SIDE_COORDINATE(14124),
        WRONG_DEPTH_COORDINATE(14125),
        WRONG_SRM_NUMBER(14126),
        WRONG_FORK_NUMBER(14127),
        WRONG_PLACE_NUMBER(14128),
        WRONG_TU_AMOUNT(14129),
        WRONG_ORDER_CODE(14130),
        MANUAL_INTERVENTION(14092),
        RACK_LOCATION_OCCUPIED(14211),
        RACK_LOCATION_EMPTY(14212),
        RACK_LOCATION_IN_BLOCKED_AREA(14161);

        private final int code;

        private OrderAck(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return "OrderAck=" + code;
        }
    }

    public static final class Builder {

        private final Set<TT1411LhdToBlock> toBlocks = Sets.newHashSet();
        private int movementOptions;

        public Builder movementOptions(int movementOptions) {
            this.movementOptions = movementOptions;
            return this;
        }

        public int getMovementOptions() {
            return movementOptions;
        }

        public Builder addToBlock(TT1411LhdToBlock toBlock) {
            toBlocks.add(toBlock);
            return this;
        }

        public TT1411 build() {
            return new TT1411(this);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("movementOpts", movementOptions).add("toBlocks", toBlocks)
                    .toString();
        }
    }
}
