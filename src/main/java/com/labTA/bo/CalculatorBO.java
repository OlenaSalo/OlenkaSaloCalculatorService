package com.labTA.bo;

import com.google.common.collect.ImmutableMap;
import com.labTA.model.Calculator;
import com.labTA.model.CalculatorOperation;
import java.math.BigDecimal;
import static com.labTA.model.CalculatorOperation.*;

public class CalculatorBO {

    private ImmutableMap<CalculatorOperation, Double> immutableCalculator;

    public void outCalculate(CalculatorOperation calculatorOperation, Calculator calculator) {
        immutableCalculator = ImmutableMap.<CalculatorOperation, Double>builder()
                .put(ADD, add(calculator.getNum1(), calculator.getNum2()))
                .put(SUBTRACT, subtract(calculator.getNum1(), calculator.getNum2()))
                .put(DIVIDE, divide(calculator.getNum1(), calculator.getNum2()))
                .put(MULTIPLY, multiply(calculator.getNum1(), calculator.getNum2()))
                .put(PERCENTAGE, percentage(calculator.getNum1(), calculator.getNum2())).build();
        for (CalculatorOperation key : immutableCalculator.keySet()) {
            if (key.getOperation().equals(calculatorOperation)) {
                immutableCalculator.get(key);
            }
        }

    }

    public double calculate(CalculatorOperation calculatorOperation, Calculator calculator) {
        CalculatorOperation key;
        outCalculate(calculatorOperation, calculator);
        key = calculatorOperation;
        return immutableCalculator.get(key);

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
