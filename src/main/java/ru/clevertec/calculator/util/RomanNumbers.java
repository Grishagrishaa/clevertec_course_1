package ru.clevertec.calculator.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumbers {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);
    private final double arabicEquivalent;

    RomanNumbers(double arabicEquivalent) {
        this.arabicEquivalent = arabicEquivalent;
    }

    public double getArabicEquivalent() {
        return arabicEquivalent;
    }

    public static List<RomanNumbers> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumbers e) -> e.arabicEquivalent).reversed())
                .collect(Collectors.toList());
    }
}
