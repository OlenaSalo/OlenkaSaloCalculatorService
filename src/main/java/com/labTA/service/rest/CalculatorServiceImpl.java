package com.labTA.service.rest;

import com.labTA.bo.CalculatorBO;
import com.labTA.model.Calculator;
import javax.ws.rs.core.Response;
import com.labTA.service.fault.FaultInfo;
import com.labTA.service.fault.FaultMessage;
import com.labTA.service.soap.exception.SoapException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    public static Logger LOG = LogManager.getLogger(CalculatorServiceImpl.class);

    private CalculatorBO calc = new CalculatorBO();
    private Response response;
    private List<String> msg = new ArrayList<>();
    private List<Calculator> calculatorList = new ArrayList<>();

    @Override
    public Response getCalculate(double x, double y, String opr) {
        LOG.info("Get calculate method");

        FaultInfo faultInfo = new FaultInfo(FaultMessage.NO_SUCH_METHOD);
        Calculator calculator = new Calculator(x, y, opr);
        calculatorList.add(calculator);
        if(calculator.getOperation().equals("*") || calculator.getOperation().equals("/") || calculator.getOperation().equals("+") || calculator.getOperation().equals("-") || calculator.getOperation().equals("%")){

            LOG.info("Operation for calculate method selected correct:" + opr);
            msg.add( String.format("value1-> %f;  " +
                    "value2-> %f; " +
                    "operation: '%s';" +
                    " answer-> %.4f ", x , y, opr , calc.calculate(calculator)));
            response = Response.status(Response.Status.OK).entity(msg).build();
        }
        else {
            LOG.warn(faultInfo.getMsg());
            response = Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(faultInfo).build();
        }
        return response;
    }

    @Override
    public Response getAdd(double x,  double y) {
        LOG.info("Get add method");
        msg.add( String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x , y , "+", calc.add(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }

    @Override
    public Response getSubtract(double x, double y) {
        LOG.info("Get subtract method");
        msg.add( String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x , y , "-", calc.subtract(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }

    @Override
    public Response getMultiply(double x, double y) {
        LOG.info("Get multiply method");
        msg.add( String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x , y , "*", calc.multiply(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }

    @Override
    public Response getDivide(double x, double y) throws SoapException {
        LOG.info("Get divide method");
        FaultInfo faultInfo = new FaultInfo(FaultMessage.DIVIDE_FOR_ZERO_FORBIDDEN);
        if(y == 0){
            LOG.warn(faultInfo.getMsg());
            response = Response.status(Response.Status.FORBIDDEN).entity(faultInfo).build();
        }else{
            LOG.info("Divider not zero");
            msg.add( String.format("value1-> %f;  " +
                    "value2-> %f; " +
                    "operation: '%s';" +
                    " answer-> %.4f ", x , y , "/", calc.divide(x, y)));
            response = Response.status(Response.Status.OK).entity(msg).build();
        }
        return response;
    }

    @Override
    public Response getPercentage(double x, double y) {
        LOG.info("Get percentage method");
        msg.add( String.format("value1-> %f;  " +
                "value2-> %f; " +
                "operation: '%s';" +
                " answer-> %.4f ", x , y , "%", calc.percentage(x, y)));
        response = Response.status(Response.Status.OK).entity(msg).build();
        return Response.status(Response.Status.OK).entity(msg).build();
    }


    }


