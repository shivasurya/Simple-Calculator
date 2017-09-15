package com.example.subramani_5647.simplecalculator;

/**
 * Created by subramani-5647 on 15/09/17.
 */

class Calculator {

    private double leftOperand;
    private double rightOperand;

    Calculator(double leftOperand, double rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    double add() {
        return leftOperand + rightOperand;
    }

    double subtract() {
        return leftOperand - rightOperand;
    }

    double multiply() {
        return leftOperand * rightOperand;
    }

    double divide() {
        if ( rightOperand == 0 ) {
            throw new ArithmeticException("Right Operand Should not be Zero");
        }
        return leftOperand / rightOperand;
    }

}
