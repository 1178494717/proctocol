package com.learn.lph.webservice.handle;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

public class CustomServer extends Server
{
    public CustomServer(InetSocketAddress address)
    {
        super(address);
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        if(request.getQueryString().equalsIgnoreCase("wsdl") && request.getMethod().equalsIgnoreCase("get"))
        {
            response.sendError(HttpStatus.BAD_GATEWAY_502, "WSDL does not allow access.");
            return;
        }
        super.handle(target, baseRequest, request, response);
    }
}
