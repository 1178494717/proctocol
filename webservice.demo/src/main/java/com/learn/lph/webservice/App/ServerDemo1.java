package com.learn.lph.webservice.App;

import java.net.InetSocketAddress;
import java.net.URL;

import javax.xml.ws.Endpoint;

import org.eclipse.jetty.http.spi.JettyHttpContext;
import org.eclipse.jetty.http.spi.JettyHttpServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

import com.learn.lph.webservice.handle.WsdlHandle;
import com.learn.lph.webservice.service.WebserviceServer;
/**
 * 通过新增handle来处理wsdl这个特殊请求
 * @author 18211
 */
public class ServerDemo1
{
    public static void main(String[] args)
        throws Exception
    {
        URL url = new URL("http://localhost:9090/lph");
        WebserviceServer webserviceServer = new WebserviceServer();
        InetSocketAddress address =
            new InetSocketAddress(url.getHost(), url.getPort());
        Server server = new Server(address);
        addHandle(server);
        JettyHttpServer httpServer = new JettyHttpServer(server, false);
        JettyHttpContext createContext =
            (JettyHttpContext)httpServer.createContext(url.getPath());
        httpServer.start();
        Endpoint create = Endpoint.create(webserviceServer);
        create.publish(createContext);
    }
    
    public static void addConnector(Server server, URL url)
    {
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setHost(url.getHost());
        connector.setPort(url.getPort());
        
        server.addConnector(connector);
    }

    private static void addHandle(Server server)
    {
        HandlerCollection collection = new HandlerCollection();
        
        collection.addHandler(new ContextHandlerCollection());
        
        collection.addHandler(new WsdlHandle());
        collection.addHandler(new DefaultHandler());
        
        server.setHandler(collection);
    }
}
