package com.learn.lph.webservice.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import com.learn.lph.webservice.utils.XmlFormatUtils;

public class HttpURLClient
{
    public static void main(String[] args)
        throws Exception
    {
        String urlString = "http://localhost:9090/lph";// wsdl文档的地址
        URL url = new URL(urlString);
        HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();// 打开连接
        
        // String soapActionString =
        // "http//localhost:9000/HelloWorld/sayHelloWorldFrom";//Soap 1.1中使用
        
        String xmlStr = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.webservice.lph.learn.com/\">\r\n" + 
            "   <soapenv:Header/>\r\n" + 
            "   <soapenv:Body>\r\n" + 
            "      <ser:say>\r\n" + 
            "         <name>刘培恒</name>\r\n" + 
            "      </ser:say>\r\n" + 
            "   </soapenv:Body>\r\n" + 
            "</soapenv:Envelope>"; 
        // Content-Length长度会自动进行计算
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        // httpConn.setRequestProperty("soapActionString",soapActionString);//Soap1.1使用
        // 其实完全可以不需要
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        
        OutputStream out = httpConn.getOutputStream();
        
        out.write(xmlStr.getBytes());
        out.close();
        
        if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK)
        {
            String result = new BufferedReader(new InputStreamReader(httpConn.getInputStream())).lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println(XmlFormatUtils.format(result));
        }
        else
        {
            // 如果服务器返回的HTTP状态不是HTTP_OK，则表示发生了错误，此时可以通过如下方法了解错误原因。
            String result = new BufferedReader(new InputStreamReader(httpConn.getErrorStream())).lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println(XmlFormatUtils.format(result));
            
        }
        httpConn.disconnect();
    }
}
