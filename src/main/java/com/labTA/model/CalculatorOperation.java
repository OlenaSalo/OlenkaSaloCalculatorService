package com.labTA.model;


import com.labTA.service.rest.CalculatorServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public enum CalculatorOperation {
    ADD("+"),
    SUBTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*"),
    PERCENTAGE("%");


    private final String operation;
    public static Logger LOG = LogManager.getLogger(CalculatorOperation.class);

    CalculatorOperation(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public boolean contain(String operation)  {
            try {
                CalculatorOperation.valueOf(operation);
                    return true;
            }catch (Exception ex){
                LOG.error("No such operation" + operation);
                return false;
            }
        }


    }


