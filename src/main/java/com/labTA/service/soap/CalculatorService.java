package com.labTA.service.soap;

import com.labTA.model.Calculator;
import com.labTA.model.CalculatorOperation;
import com.labTA.service.soap.exception.SoapException;
import javax.jws.WebService;

@WebService
public interface CalculatorService {

    double getCalculate(CalculatorOperation calculatorOperation, Calculator calculator) throws SoapException;

    double getAdd(double x, double y) throws SoapException;

    double getSubtract(double x, double y) throws  SoapException;

    double getMultiply(double x, double y) throws  SoapException;

    double getDivide(double x, double y) throws SoapException;

    double getPercentage(double x, double y) throws  SoapException;
}
