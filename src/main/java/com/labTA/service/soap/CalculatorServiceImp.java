package com.labTA.service.soap;

import com.labTA.bo.CalculatorBO;
import com.labTA.model.Calculator;
import com.labTA.service.fault.FaultInfo;
import com.labTA.service.fault.FaultMessage;
import com.labTA.service.soap.exception.SoapException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.WebService;

@WebService(endpointInterface = "com.labTA.service.soap.CalculatorService")
public class CalculatorServiceImp implements CalculatorService {

    private static final Logger LOG = LogManager.getLogger();
    private CalculatorBO calculatorBO = new CalculatorBO();
    private double result = 0;

    @Override
    public double getCalculate(Calculator calculator) throws SoapException {
        LOG.info("Calculate two number the next operation");
        FaultInfo faultInfo = new FaultInfo(FaultMessage.NO_SUCH_METHOD);
        if(calculator.getOperation().equals("*") || calculator.getOperation().equals("/") || calculator.getOperation().equals("+") || calculator.getOperation().equals("-") || calculator.getOperation().equals("%"))
        {result = calculatorBO.calculate(calculator);}
        else
            LOG.warn(faultInfo.getMsg());
        return calculatorBO.roundTo4Places(result);
    }

    @Override
    public double getAdd(double x, double y)  {
        LOG.info("Add two number" );
               return calculatorBO.add(x, y);
    }

    @Override
    public double getSubtract(double x, double y) throws SoapException {
        LOG.info("Subtract two number");
        return calculatorBO.subtract(x, y);
    }

    @Override
    public double getMultiply(double x, double y) {
        LOG.info("Multiply two number");
        return calculatorBO.roundTo4Places(calculatorBO.multiply(x, y));
    }

    @Override
    public double getDivide(double x, double y) throws SoapException {

        if(forbiddenDivide(y)) {
            throw new RuntimeException();
        }
        else
        result = calculatorBO.roundTo4Places(calculatorBO.divide(x, y));
        return result;
    }

    @Override
    public double getPercentage(double x, double y) throws SoapException {
        LOG.info("Percentage two number");

        if(forbiddenDivide(y)){
            throw new RuntimeException();
        }else
            result = calculatorBO.roundTo4Places(calculatorBO.percentage(x, y));

        return result;
    }

    private boolean forbiddenDivide(double y)
    {
        boolean condition;
        FaultInfo faultInfo = new FaultInfo(FaultMessage.DIVIDE_FOR_ZERO_FORBIDDEN);
        if(y == 0) {
            LOG.warn(faultInfo.getMsg());
            condition =  true;
        }else condition =false;
        return condition;
    }
}
