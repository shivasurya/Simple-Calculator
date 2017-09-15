package com.example.subramani_5647.simplecalculator;

/**
 * Created by subramani-5647 on 15/09/17.
 */

public class Calculator {

    private double leftOperand;
    private double rightOperand;

    public Calculator( double leftOperand, double rightOperand ) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public double add() {
        return leftOperand + rightOperand;
    }

    public double subtract() {
        return leftOperand - rightOperand;
    }

    public double multiply() {
        return leftOperand * rightOperand;
    }

    public double divide() {
        if ( rightOperand == 0 ) {
            throw new ArithmeticException("Right Operand Should not be Zero");
        }
        return leftOperand / rightOperand;
    }

}
