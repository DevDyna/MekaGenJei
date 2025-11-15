package com.devdyna.mekagenjei.utils;

public class Numbers {
    
    public static String toCompact(double value) {
        if (value < 1) {
            return String.valueOf(value);
        }

        String suffix = "";
        double scaledValue = value;

        if (value >= 1_000_000_000) {
            scaledValue = value / 1_000_000_000;
            suffix = "B";
        } else if (value >= 1_000_000) {
            scaledValue = value / 1_000_000;
            suffix = "M";
        } else if (value >= 1_000) {
            scaledValue = value / 1_000;
            suffix = "k";
        }

        double truncated = Math.floor(scaledValue * 10) / 10;

        if (truncated == (long) truncated) {
            return String.format("%d%s", (long) truncated, suffix);
        } else {
            return String.format("%.1f%s", truncated, suffix);
        }
    }

    public static int jouleToFE(long j) {
        return (int) (j * 2) / 5;
    }

    public static long feToJoule(int fe) {
        return (long) (fe * 5) / 2;
    }

    public static String simplify(double value){
        return value % 1 == 0 ? String.format("%.0f", value) : String.valueOf(value);
    }
}
