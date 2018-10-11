package com.learn.lph.webservice;

import java.net.InetSocketAddress;
import java.net.URL;

import javax.xml.ws.Endpoint;

import org.eclipse.jetty.http.spi.JettyHttpContext;
import org.eclipse.jetty.http.spi.JettyHttpServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("http://localhost:12452/prov");
        HelloServiceImpl serivce = new HelloServiceImpl();
        InetSocketAddress address =
            new InetSocketAddress(url.getHost(), url.getPort());
        Server server = new Server(address);
        addHandle(server);
        
        JettyHttpServer httpServer = new JettyHttpServer(server, false);
        JettyHttpContext createContext = (JettyHttpContext)httpServer.createContext(url.getPath());
        httpServer.start();
        Endpoint create = Endpoint.create(serivce);
        create.publish(createContext);
           
    }
    
    private static void addHandle(Server server)
    {
        HandlerCollection collection = new HandlerCollection();
        
        collection.addHandler(new ContextHandlerCollection());
        collection.addHandler(new DefaultHandler());
        
        server.setHandler(collection);
    }
}
