package com.devdyna.mekagenjei.utils;

import java.text.DecimalFormat;

public class Numbers {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");

    public static String toCompact(double value) {

        if (value < 1)
            return String.valueOf(value);

        if (value >= 1_000_000_000)
            return DECIMAL_FORMAT.format(value / 1_000_000_000) + "B";
        else if (value >= 1_000_000)
            return DECIMAL_FORMAT.format(value / 1_000_000) + "M";
        else if (value >= 1_000)
            return DECIMAL_FORMAT.format(value / 1_000) + "k";
        else
            return DECIMAL_FORMAT.format(value);

    }
}
