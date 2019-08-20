package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GetCookies2 {


    ResourceBundle bundle;
    String host;
    CookieStore cookieStore;

    //Step1 获取配置文件

    @BeforeTest
    public void getProperty(){
        bundle = ResourceBundle.getBundle("cookies");
        this.host = bundle.getString("test.host");
    }


    //step2：获取cookies
    @Test
    public void getCookies() throws IOException {
        String uri = bundle.getString("test.uri");
        String testUrl = this.host + uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity());

        //获取返回的cookies值
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookieList = this.cookieStore.getCookies();

        for(Cookie cookie : cookieList){
            System.out.println("cookiename = " + cookie.getName());
            System.out.println("cookievalue = " + cookie.getValue());
        }
    }

    //step3：利用获取的cookies访问需要携带cookies才能访问的请求

    @Test(dependsOnMethods = {"getCookies"})
    public void getWithCookies() throws Exception{
        String uri = bundle.getString("test.get.with.cookies");
        String getWithCookesiUrl = this.host + uri;
        System.out.println("getWithCookesiUrl = " + getWithCookesiUrl);

        HttpGet get  = new HttpGet(getWithCookesiUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);


    }
}
