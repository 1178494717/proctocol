package com.learn.lph.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CustomHandle extends AbstractHandler
{
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        Document docReq = parseRequest(request);
        parseDoc(docReq);
        response.setStatus(HttpStatus.OK_200);
        response.addHeader("Date", new Date().toString());
        response.addHeader("Transfer-Encoding", "chunked");
        response.addHeader("#status#", "HTTP/1.1 200 OK");
        response.addHeader("Content-Type", "text/xml;charset=utf-8");
        response.addHeader("Server", "Jetty(9.4.8.v20171121)");
        PrintWriter writer = response.getWriter();
        
        String context = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" 
                    + "   <S:Body>\r\n" 
                    + "      <ns2:sayResponse xmlns:ns2=\"http://webservice.lph.learn.com/\">\r\n" 
                    + "         <return>hello, lph</return>\r\n"
                    + "      </ns2:sayResponse>\r\n" 
                    + "   </S:Body>\r\n" 
                    + "</S:Envelope>";
        
        writer.write(context);
        writer.flush();
        writer.close();
    }
    
    public Document parseRequest(HttpServletRequest request)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc = builder.parse(request.getInputStream());
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public void parseDoc(Document docReq)
    {
        NodeList body = docReq.getElementsByTagName("soapenv:Body");
        Node method = body.item(0).getChildNodes().item(1);
        String nodeName = method.getNodeName();
        System.out.println(nodeName);
    }
    
}
