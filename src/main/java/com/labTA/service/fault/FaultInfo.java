package com.labTA.service.fault;

public class FaultInfo {

    private String msg;

    public FaultInfo(FaultMessage expression) {
        setMsg(String.format(expression.getMsgExseption()));
    }

    public FaultInfo() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
