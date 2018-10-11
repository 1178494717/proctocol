package com.learn.lph.webservice;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.HttpClient;
public class HttpClientDemo
{
    @SuppressWarnings("deprecation")
    public static void soap()
        throws Exception
    {
        
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:12452/prov?wsdl");
        
        String xmlStr = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.lph.learn.com/\">\r\n" + 
            "   <soapenv:Header/>\r\n" + 
            "   <soapenv:Body>\r\n" + 
            "      <web:say>\r\n" + 
            "         <!--Optional:-->\r\n" + 
            "         <arg0>aaa</arg0>\r\n" + 
            "      </web:say>\r\n" + 
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
