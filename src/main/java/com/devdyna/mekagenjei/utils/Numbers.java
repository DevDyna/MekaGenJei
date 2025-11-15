package com.devdyna.mekagenjei.utils;

import java.text.DecimalFormat;

public class Numbers {
     private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");

    public static String toCompact(long value) {
        double v = value;

        if (value >= 1_000_000_000) {
            return DECIMAL_FORMAT.format(v / 1_000_000_000) + "B";
        } else if (value >= 1_000_000) {
            return DECIMAL_FORMAT.format(v / 1_000_000) + "M";
        } else if (value >= 1_000) {
            return DECIMAL_FORMAT.format(v / 1_000) + "k";
        } else {
            return Long.toString(value);
        }
    }
}
