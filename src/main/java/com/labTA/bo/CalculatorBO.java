package com.labTA.bo;

import com.labTA.model.Calculator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;


public class CalculatorBO{

    private Calculator calculator = new Calculator();
    private double result = 0.0;

    public double calculate(Calculator calculator)
    {
        if(calculator.getOperation().equals("+"))
        {
            return add(calculator.getNum1() , calculator.getNum2());
        }else if(calculator.getOperation().equals("-"))
        {
            return subtract(calculator.getNum1() , calculator.getNum2());
        }else if (calculator.getOperation().equals("*")) {
            return multiply(calculator.getNum1(), calculator.getNum2());
        }else if(calculator.getOperation().equals("/")){
            return divide(calculator.getNum1(), calculator.getNum2());
        }else if(calculator.getOperation().equals("%"))
        {
            return percentage(calculator.getNum1(), calculator.getNum2());
        }
        return result;

    }

    public double add(double x, double y) {
        return x + y;
    }

    public double subtract(double x, double y) {
        return x - y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }

    public double divide(double x, double y) {

        return x / y;
    }

    public double percentage(double x, double y) {
        return (x / y) * 100;
    }

    public double roundTo4Places(double value) {

            BigDecimal bd = new BigDecimal(value);
            int roundPlace = 4;
            bd = bd.setScale(roundPlace, BigDecimal.ROUND_HALF_UP);
            return bd.doubleValue();

    }


}
