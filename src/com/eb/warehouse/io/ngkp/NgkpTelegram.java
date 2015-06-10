package com.eb.warehouse.io.ngkp;

import com.google.common.base.MoreObjects;

/**
 * Created by eb on 19.05.2015.
 */
public final class NgkpTelegram {

    private final Ngkp2Header header;
    private final TT1411 tt1411;

    private NgkpTelegram(Builder b) {
        header = b.header.build();
        tt1411 = b.tt1411.build();
//        tt1430 = b.tt1430.build();
//        tt1434 = b.tt1434.build();
    }
//    private final TT1430 tt1430;
//    private final TT1434 tt1434;

    public Ngkp2Header getHeader() {
        return null;
    }

    public boolean hasTT1411() {
        return false;
    }

    public TT1411 getTT1411() {
        return null;
    }

    public boolean hasTT1430() {
        return false;
    }

    public boolean hasTT1434() {
        return false;
    }

    public TT1430 getTT1430() {
        return null;
    }

    public TT1434 getTT1434() {
        return null;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("header", header).add("tt1411", tt1411)/*.add("tt1430", tt1430)
                .add("tt1434", tt1434)*/.omitNullValues().toString();
    }

    public static final class Builder {

        private Ngkp2Header.Builder header;
        private TT1411.Builder tt1411;
        private TT1430.Builder tt1430;
        private TT1434.Builder tt1434;

        public Ngkp2Header.Builder getHeader() {
            return header;
        }

        public Builder header(Ngkp2Header.Builder header) {
            this.header = header;
            return this;
        }

        public TT1411.Builder getTT1411() {
            return tt1411;
        }

        public Builder tt1411(TT1411.Builder tt1411) {
            this.tt1411 = tt1411;
            return this;
        }

        public TT1430.Builder getTT1430() {
            return tt1430;
        }

        public Builder tt1430(TT1430.Builder tt1430) {
            this.tt1430 = tt1430;
            return this;
        }

        public TT1434.Builder getTT1434() {
            return tt1434;
        }

        public Builder tt1434(TT1434.Builder tt1434) {
            this.tt1434 = tt1434;
            return this;
        }

        public NgkpTelegram build() {
            return new NgkpTelegram(this);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("header", header).add("tt1411", tt1411).add("tt1430", tt1430)
                    .add("tt1434", tt1434).omitNullValues().toString();
        }
    }
}
