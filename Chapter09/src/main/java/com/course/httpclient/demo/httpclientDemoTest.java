package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class httpclientDemoTest {

    @Test
    public void httpclientdemo() throws IOException {

        //接收返回的response
        String result;
//声明一个get请求
        HttpGet get = new HttpGet("http://www.baidu.com");//此处需要带上http://
        //声明一个client，用于执行get请求
        HttpClient client = new DefaultHttpClient();
        //声明一个response接收请求返回的response信息
        HttpResponse response = client.execute(get);
        //使用EntityUtils.toString将返回的response信息转化为String类型。
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


    }


//请求自己moco的接口
    @Test
    public void testMywebsite() throws IOException {
        String result;

        HttpGet get = new HttpGet("http://localhost:8889/mywebsite");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString((response.getEntity()));
        System.out.println(result);
    }
}
