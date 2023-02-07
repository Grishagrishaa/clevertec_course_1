package ru.clevertec.calculator.util;

import java.util.regex.Pattern;

public class NumberIdentifier {
    private static final String arabicPattern = "\\d+";
    private static final String romanPattern = "^[MDCLXVI]+$";

    private NumberIdentifier() {
    }

    public static boolean isRomanNumber(String number){
        return Pattern.matches(romanPattern, number);
    }

    public static boolean isArabicNumber(String number){
        return Pattern.matches(arabicPattern, number);
    }
}
