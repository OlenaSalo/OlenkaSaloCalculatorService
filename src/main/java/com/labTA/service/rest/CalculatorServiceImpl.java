package com.labTA.service.rest;

import com.labTA.bo.CalculatorBO;
import com.labTA.model.Calculator;
import com.labTA.model.CalculatorOperation;
import com.labTA.service.fault.FaultInfo;
import com.labTA.service.fault.FaultMessage;
import com.labTA.service.soap.exception.SoapException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.labTA.model.CalculatorOperation.DIVIDE;
import static com.labTA.service.fault.FaultMessage.DIVIDE_FOR_ZERO_FORBIDDEN;
import static com.labTA.service.fault.FaultMessage.NO_SUCH_METHOD;

public class CalculatorServiceImpl implements CalculatorService {

    public static Logger LOG = LogManager.getLogger(CalculatorServiceImpl.class);
    private CalculatorOperation calculatorOperation;
    private CalculatorBO calc = new CalculatorBO();
    private Response response;
    private List<String> msg = new ArrayList<>();
    private List<Calculator> calculatorList = new ArrayList<>();

    @Override
    public Response getCalculate(double x, double y, String operation) {
        LOG.info("Get calculate method");
        msg.clear();
        FaultInfo faultInfo = new FaultInfo();
        Calculator calculator = new Calculator(x, y);
        calculatorList.add(calculator);
        try {
            calculatorOperation = CalculatorOperation.valueOf(operation);
            if (calculatorOperation.contain(operation)) {
                if (calculatorOperation.equals(DIVIDE) && calculator.getNum2() == 0) {
                    LOG.warn(faultInfo.getMsg());
                    response = Response.status(Response.Status.FORBIDDEN).entity(DIVIDE_FOR_ZERO_FORBIDDEN.getMsgExseption()).build();
                } else {
                    LOG.info("Operation for calculate method selected correct:" + calculatorOperation);
                    msg.add(String.format("value1-> %f;  " +
                            "value2-> %f; " +
                            "operation: '%s';" +
                            " answer-> %.4f ", x, y, calculatorOperation, calc.calculate(calculatorOperation, calculator)));
                    response = Response.status(Response.Status.OK).entity(msg).build();
                }
            }
        } catch (Exception e) {
            LOG.warn(NO_SUCH_METHOD.getMsgExseption());
            response = Response.status(Response.Status.NOT_FOUND).entity(NO_SUCH_METHOD.getMsgExseption()).build();
        }
        return response;
    }

    @Override
    public Response getAdd(double x, double y) {
        LOG.info("Get add method");
        msg.clear();
        msg.add(String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x, y, "+", calc.add(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }

    @Override
    public Response getSubtract(double x, double y) {
        LOG.info("Get subtract method");
        msg.add(String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x, y, "-", calc.subtract(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }

    @Override
    public Response getMultiply(double x, double y) {
        LOG.info("Get multiply method");
        msg.clear();
        msg.add(String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x, y, "*", calc.multiply(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }

    @Override
    public Response getDivide(double x, double y) throws SoapException {
        LOG.info("Get divide method");
        msg.clear();
        FaultInfo faultInfo = new FaultInfo(FaultMessage.DIVIDE_FOR_ZERO_FORBIDDEN);
        if (y == 0) {
            LOG.warn(faultInfo.getMsg());
            response = Response.status(Response.Status.FORBIDDEN).entity(faultInfo).build();
        } else {
            LOG.info("Divider not zero");
            msg.add(String.format("value1-> %f;  " +
                    "value2-> %f; " +
                    "operation: '%s';" +
                    " answer-> %.4f ", x, y, "/", calc.divide(x, y)));
            response = Response.status(Response.Status.OK).entity(msg).build();
        }
        return response;
    }

    @Override
    public Response getPercentage(double x, double y) {
        LOG.info("Get percentage method");
        msg.clear();
        msg.add(String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x, y, "%", calc.percentage(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return Response.status(Response.Status.OK).entity(msg).build();
    }
}


