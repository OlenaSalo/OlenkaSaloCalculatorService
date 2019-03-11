package com.labTA.service.soap.exception;

import com.labTA.service.fault.FaultInfo;

import javax.xml.ws.WebFault;

@WebFault(name = "CalculatorFault")
public class SoapException extends Exception{
    private FaultInfo faultInfo;

    public SoapException(FaultInfo faultInfo){this.faultInfo = faultInfo;}

    public FaultInfo getFaultInfo(){return faultInfo;}

    public void setFaultInfo(FaultInfo faultInfo){this.faultInfo = faultInfo;}
}
