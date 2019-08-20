package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 使用CloseableHttpClient对象代替DefaultHttpClient对象执行get请求，获取response及cookies
 */

public class GetCookie3 {

    ResourceBundle bundle;
    String host;
    CookieStore store;

    @BeforeTest
    public void getProperty(){
        bundle = ResourceBundle.getBundle("cookies");
        this.host = bundle.getString("test.host");

    }

    @Test
    public void getCookies() throws IOException {

        //从配置文件中拼接URL
        String uri = bundle.getString("test.uri");
        String testUrl = this.host + uri;

        //获取cookies信息
        this.store = new BasicCookieStore();

        //声明一个client对象，设置初始cookies信息
        CloseableHttpClient client1 = HttpClients.custom().setDefaultCookieStore(this.store).build();


        //测试逻辑
        //声明一个get方法
        HttpGet get = new HttpGet(testUrl);
        //声明一个response对象，使用client执行get请求，执行get请求后，this.store才有值，并装载返回的响应信息
        CloseableHttpResponse response = client1.execute(get);
        System.out.println("/////////" + this.store);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        System.out.println(this.store);


        List<Cookie> cookiesList = store.getCookies();

        for(Cookie cookie:cookiesList){
            System.out.println("cookiename = " + cookie.getName());
            System.out.println("cookievalue = " + cookie.getValue());
        }

    }

    @Test(dependsOnMethods = {"getCookies"})
    public void getWithCookies() throws IOException{

        //获取uri
        String uri = bundle.getString("test.get.with.cookies");
        String getWithCookiesUrl = this.host + uri;

        //创建get请求

        HttpGet get = new HttpGet(getWithCookiesUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        System.out.println(response);
        System.out.println(response.getStatusLine().getStatusCode());
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

    }
}
