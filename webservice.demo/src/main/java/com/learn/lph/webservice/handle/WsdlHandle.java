package com.learn.lph.webservice.handle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerCollection;

public class WsdlHandle extends HandlerCollection
{
    @Override
    public void handle(String target, Request baseRequest,
        HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        if(request.getQueryString().equalsIgnoreCase("wsdl") && request.getMethod().equalsIgnoreCase("get"))
        {
            throw new ServletException("Accept query wsdl request.");
        }
        super.handle(target, baseRequest, request, response);
    }
}
