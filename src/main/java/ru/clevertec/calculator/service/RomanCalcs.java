package ru.clevertec.calculator.service;

import ru.clevertec.calculator.operations.api.IOperation;
import ru.clevertec.calculator.operations.impl.IOperationAdditionImpl;
import ru.clevertec.calculator.operations.impl.IOperationDivisionImpl;
import ru.clevertec.calculator.operations.impl.IOperationMultiplicationImpl;
import ru.clevertec.calculator.operations.impl.IOperationSubtractionImpl;
import ru.clevertec.calculator.util.RomanNumbers;

import java.util.List;

public class RomanCalcs extends Calculation {
    private IOperation operation;


    @Override
    public String addition(String a, String b) {
        double doubleA = romanToArabic(a);
        double doubleB = romanToArabic(b);

        operation = new IOperationAdditionImpl();
        return arabicToRoman(operation.execute(doubleA, doubleB));

    }

    @Override
    public String subtraction(String a, String b) {
        double doubleA = romanToArabic(a);
        double doubleB = romanToArabic(b);

        operation = new IOperationSubtractionImpl();
        return arabicToRoman(operation.execute(doubleA, doubleB));
    }

    @Override
    public String multiplication(String a, String b) {
        double doubleA = romanToArabic(a);
        double doubleB = romanToArabic(b);

        operation = new IOperationMultiplicationImpl();
        return arabicToRoman(operation.execute(doubleA, doubleB));

    }

    @Override
    public String division(String a, String b) {
        double doubleA = romanToArabic(a);
        double doubleB = romanToArabic(b);

        operation = new IOperationDivisionImpl();
        return arabicToRoman(operation.execute(doubleA, doubleB));
    }

    public static double romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        double result = 0;

        List<RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();

        double i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumbers symbol = romanNumerals.get((int) i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getArabicEquivalent();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public static String arabicToRoman(double number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();

        double i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumbers currentSymbol = romanNumerals.get((int) i);
            if (currentSymbol.getArabicEquivalent() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getArabicEquivalent();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
