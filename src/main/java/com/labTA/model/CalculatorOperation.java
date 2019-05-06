package com.labTA.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum CalculatorOperation {
    ADD("+"),
    SUBTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*"),
    PERCENTAGE("%");

    public static Logger LOG = LogManager.getLogger(CalculatorOperation.class);
    private final String operation;

    CalculatorOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public boolean contain(String operation) {
        try {
            CalculatorOperation.valueOf(operation);
            return true;
        } catch (Exception ex) {
            LOG.error("No such operation" + operation);
            return false;
        }
    }
}


