package com.labTA.model;

import java.io.Serializable;

public class Calculator implements Serializable {

    private double num1;
    private double num2;
    private String operation;


    public Calculator(double num1, double num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public Calculator()
    {

    }
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperation(){return operation;}

    public void setOperation(String operation){this.operation = operation;}

   @Override
   public boolean equals(Object obj)
   {
       if(this == obj) return true;
       if(obj == null || getClass()!= obj.getClass()) return false;

       Calculator calculator = (Calculator) obj;

       return getOperation() != null ? getOperation().equals(calculator.getOperation()) : calculator.getOperation() == null;
   }

   @Override
   public int hashCode()
   {
       int result = getOperation() != null ? getOperation().hashCode() : 0;
       return  result;
   }

}
