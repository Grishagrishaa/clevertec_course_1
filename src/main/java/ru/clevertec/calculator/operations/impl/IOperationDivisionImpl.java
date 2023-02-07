package org.example.calculator.operations.impl;

import org.example.calculator.operations.api.IOperation;

import java.util.concurrent.LinkedBlockingDeque;

public class IOperationDivisionImpl implements IOperation {
    @Override
    public int execute(double a, double b) {
        int result = (int) (a / b);
        if(result < 0){
            System.out.println("Неположительный результат");
            System.exit(0);

        }
        return result;
    }
}
