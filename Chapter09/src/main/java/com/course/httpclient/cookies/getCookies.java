package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;

import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;


import java.io.IOException;

import java.util.List;
import java.util.ResourceBundle;

public class getCookies {

    private String host;
    private ResourceBundle bundle;
    private CookieStore store;


    @BeforeTest
    public void getProperties(){
        bundle = ResourceBundle.getBundle("cookies");
        this.host = bundle.getString("test.host");
        System.out.println("testUrl = " + this.host);
    }

    @Test
    public void getCookies() throws IOException {
        //从配置文件中获取信息，拼接测试的URL
        String Url;
        String result;
        Url = this.host + bundle.getString("test.uri");

        //发送请求
        HttpGet get = new HttpGet(Url);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        System.out.println(response.getStatusLine().getReasonPhrase());

        //获取cookies信息
        this.store = client.getCookieStore();

        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name " + name
            + ";cookie value = " +value);
        }



    }
    //访问需携带cookies的接口

    @Test(dependsOnMethods = {"getCookies"})
    public void testGetWithCookies() throws IOException {
        //从配置文件中获取字段，拼接URL。
        String uri = bundle.getString("test.get.with.cookies");
        String url = this.host + uri;

        //访问接口逻辑

        HttpGet get = new HttpGet(url);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

    }
}
