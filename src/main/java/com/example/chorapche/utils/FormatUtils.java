package com.example.chorapche.utils;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatUtils {

    public static String formatDecimal(double value, int decimalPlaces) {
        // Create a DecimalFormatSymbols instance with a period as the decimal separator
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.'); // Ensure the decimal separator is a period

        // Build the pattern
        StringBuilder pattern = new StringBuilder("###");
        if (decimalPlaces > 0) {
            pattern.append(".");
            pattern.append("0".repeat(decimalPlaces));
        }

        // Create and configure DecimalFormat
        DecimalFormat df = new DecimalFormat(pattern.toString(), symbols);

        return df.format(value);
    }
}
