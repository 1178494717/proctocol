package com.learn.lph.webservice.Client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import com.learn.lph.webservice.utils.XmlFormatUtils;

public class HttpClientDemo
{
    @SuppressWarnings("deprecation")
    public static void soap()
        throws Exception
    {
        
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:9090/lph?wsdl");
        
        String xmlStr = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.webservice.lph.learn.com/\">\r\n" + 
            "   <soapenv:Header/>\r\n" + 
            "   <soapenv:Body>\r\n" + 
            "      <ser:say>\r\n" + 
            "         <name>刘培恒</name>\r\n" + 
            "      </ser:say>\r\n" + 
            "   </soapenv:Body>\r\n" + 
            "</soapenv:Envelope>"; 
        postMethod.setRequestBody(xmlStr); // 文件名自定义
        // 修改请求的头部
        postMethod.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
        // 4.执行请求 ,结果码
        int code = client.executeMethod(postMethod);
        System.out.println("结果码:" + code);
        // 5. 获取结果
        String result = postMethod.getResponseBodyAsString();
        System.out.println("Post请求的结果：" + XmlFormatUtils.format(result));
    }
    
    public static void main(String[] args)
        throws Exception
    {
        soap();
    }
}
