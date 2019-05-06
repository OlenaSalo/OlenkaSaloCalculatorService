package com.labTA.service.rest;

import com.labTA.service.soap.exception.SoapException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calculatorRest")
public interface CalculatorService {

    @GET
    @Path("calculate/{x}/{y}/{operation}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getCalculate(@PathParam("x") double x, @PathParam("y") double y, @PathParam("operation") String opr) throws SoapException;


    @GET
    @Path("add/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAdd(@PathParam("x") double x , @PathParam("y") double y);

    @GET
    @Path("subtract/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getSubtract(@PathParam("x") double x ,@PathParam("y") double y);


    @GET
    @Path("multiply/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getMultiply(@PathParam("x") double x , @PathParam("y")double y);

    @GET
    @Path("divide/{x}/{y}")
    @Produces({MediaType.APPLICATION_JSON})
    Response getDivide(@PathParam("x") double x ,@PathParam("y") double y) throws SoapException;

    @GET
    @Path("percentage/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getPercentage(@PathParam("x") double x , @PathParam("y")double y);

}
