package com.learn.lph.https.webservice;

import java.net.URL;

import javax.xml.ws.Endpoint;

import org.apache.commons.httpclient.HttpVersion;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.http.spi.JettyHttpContext;
import org.eclipse.jetty.http.spi.JettyHttpServer;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import com.learn.lph.webservice.HelloServiceImpl;

public class HttpsServerWebservice
{
    public static String BASE_HOME = System.getProperty("user.dir");
    
    public static void main(String[] args)
        throws Exception
    {
        URL url = new URL("http://192.168.239.1:12452/prov");
        
        Server server = new Server();
        
        HttpConfiguration configuration = new HttpConfiguration();
        configuration.setSecureScheme(HttpScheme.HTTPS.asString());
        configuration.setSendDateHeader(false);
        configuration.setSendServerVersion(false);
        
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStorePath("src/main/resources/mykeystore");
        sslContextFactory.setKeyStorePassword("123456");
        sslContextFactory.setKeyManagerPassword("123456");
        sslContextFactory.setTrustStorePath("src/main/resources/mykeystore");
        sslContextFactory.setTrustStorePassword("123456");
        
        ServerConnector connector = new ServerConnector(server, new SslConnectionFactory(sslContextFactory, HttpVersion.HTTP_1_1.toString()), new HttpConnectionFactory(configuration));
        connector.setPort(url.getPort());
        connector.setHost(url.getHost());
        server.addConnector(connector);
        // https://192.168.239.1:12345/prov
        HelloServiceImpl serivce = new HelloServiceImpl();
        
        ContextHandlerCollection handles = new ContextHandlerCollection();
        handles.addHandler(new DefaultHandler());
        server.setHandler(handles);
        
        JettyHttpServer httpServer = new JettyHttpServer(server, false);
        JettyHttpContext createContext = (JettyHttpContext)httpServer.createContext(url.getPath());
        httpServer.start();
        Endpoint create = Endpoint.create(serivce);
        create.publish(createContext);
        
    }
}
