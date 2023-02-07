package ru.clevertec.calculator;


import ru.clevertec.calculator.service.ArabicCalcs;
import ru.clevertec.calculator.service.Calculation;
import ru.clevertec.calculator.util.NumberIdentifier;

import java.util.Arrays;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculation calculator;
        Scanner scn = new Scanner(System.in);
        try{
            String[] expression = scn.nextLine().split(" ");

            String operator = expression[1];
            String[] operands = {expression[0], expression[2]};

            if(isArabicOperands(operands)){
                calculator = new ArabicCalcs();
            }else if(isRomanOperands(operands)){
                throw new UnsupportedOperationException();//TODO MAKE IMPLEMENTATION
            }else {
                throw new IllegalArgumentException();
            }

            switch (operator){
                case "+":
                    System.out.println(calculator.addition(operands[0], operands[1]));
                    break;
                case "-":
                    System.out.println(calculator.subtraction(operands[0], operands[1]));
                    break;
                case "*":
                    System.out.println(calculator.multiplication(operands[0], operands[1]));
                    break;
                case "/":
                    System.out.println(calculator.division(operands[0], operands[1]));
                    break;
                default: throw new IllegalArgumentException("Неверный формат чисел");
            }
        }catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e){
            System.out.println("Invalid Input");
        }
    }

    private static boolean isArabicOperands(String[] operands) {
        return Arrays.stream(operands)
                .allMatch(NumberIdentifier::isArabicNumber);
    }

    private static boolean isRomanOperands(String[] operands) {
        throw new UnsupportedOperationException();//TODO MAKE IMPLEMENTATION
    }
}
