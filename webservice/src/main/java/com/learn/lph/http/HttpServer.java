package com.learn.lph.http;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class HttpServer
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server();
        HttpConfiguration config = new HttpConfiguration();
        config.setSendServerVersion(true);
        config.setSendDateHeader(true);
        
        ServerConnector connector = new ServerConnector(server,new HttpConnectionFactory(config));
        connector.setPort(12452);
        
        server.addConnector(connector);
        
        server.setHandler(new CustomHandle());
        
        server.start();
        server.join();
    }
}
