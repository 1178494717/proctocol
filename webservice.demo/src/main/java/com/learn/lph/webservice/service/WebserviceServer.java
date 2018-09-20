package com.learn.lph.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class WebserviceServer
{
    @WebMethod(operationName="say")
    public String say(@WebParam(name="name") String name)
    {
        return "Hello, " + name;
    }
}
