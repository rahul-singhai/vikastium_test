package com.vikastium.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FormatUtil {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public static String format(double input){
        DECIMAL_FORMAT.setRoundingMode(RoundingMode.HALF_UP);
        return DECIMAL_FORMAT.format(input);
    }
}
