package com.eb.warehouse.io.ngkp;

import com.google.common.base.MoreObjects;

/**
 * Created by eb on 21.05.2015.
 */
public final class TT1411TuBlock {

    private final int type;
    private final int typeFlags;
    private final int length;
    private final int width;
    private final int height;
    private final int weight;
    private final int errorFlags;
    private final String barcode;

    private TT1411TuBlock(Builder b) {
        type = b.type;
        typeFlags = b.typeFlags;
        length = b.length;
        width = b.width;
        height = b.height;
        weight = b.weight;
        errorFlags = b.errorFlags;
        barcode = b.barcode;
    }

    public int getType() {
        return type;
    }

    public int getTypeFlags() {
        return typeFlags;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getErrorFlags() {
        return errorFlags;
    }

    public String getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("type", type).add("typeFlags", typeFlags).add("length", length)
                .add("width", width).add("height", height).add("weight", weight).add("errorFlags", errorFlags)
                .add("barcode", barcode).toString();
    }

    public static final class Builder {

        private int type;
        private int typeFlags;
        private int length;
        private int width;
        private int height;
        private int weight;
        private int errorFlags;
        private String barcode;

        public int getType() {
            return type;
        }

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public int getTypeFlags() {
            return typeFlags;
        }

        public Builder typeFlags(int typeFlags) {
            this.typeFlags = typeFlags;
            return this;
        }

        public int getLength() {
            return length;
        }

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public int getWidth() {
            return width;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public int getHeight() {
            return height;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public int getWeight() {
            return weight;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public int getErrorFlags() {
            return errorFlags;
        }

        public Builder errorFlags(int errorFlags) {
            this.errorFlags = errorFlags;
            return this;
        }

        public String getBarcode() {
            return barcode;
        }

        public Builder barcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        public TT1411TuBlock build() {
            return new TT1411TuBlock(this);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("type", type).add("typeFlags", typeFlags).add("length", length)
                    .add("width", width).add("height", height).add("weight", weight).add("errorFlags", errorFlags)
                    .add("barcode", barcode).toString();
        }
    }
}
