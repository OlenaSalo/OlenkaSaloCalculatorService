package com.labTA.service.fault;

public enum FaultMessage {
    NO_SUCH_METHOD("There is no such method for calculator "),
    DIVIDE_FOR_ZERO_FORBIDDEN("You can't divide for zero");


    private String msgExseption;

    private FaultMessage(String msg) {
        msgExseption = msg;
    }

    public String getMsgExseption() {
        return msgExseption;
    }
}
