package ru.clevertec.calculator.util;

import java.util.regex.Pattern;

public class NumberIdentifier {
    private static final String arabicPattern = "\\d+";
    private static final String romanPattern = "";//TODO INSERT PATTERN

    private NumberIdentifier() {
    }

    public static boolean isRomanNumber(String number){
        throw new UnsupportedOperationException();//TODO MAKE IMPLEMENTATION
    }

    public static boolean isArabicNumber(String number){
        return Pattern.matches(arabicPattern, number);
    }
}
