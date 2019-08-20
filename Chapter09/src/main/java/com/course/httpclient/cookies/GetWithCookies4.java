package com.course.httpclient.cookies;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 从配置文件中获取测试地址
 * 获取get请求返回的cookies
 * 使用该cookies去访问一个需要携带cookies信息才能访问的网站
 * 使用CloseableHttpClient代替DefaultHttpClient
 */

public class GetWithCookies4 {


    private String host;
    private CookieStore cookieStore;
    private ResourceBundle bundle;
    private String port;

    @BeforeTest
    public void getProperty(){
        bundle = ResourceBundle.getBundle("cookies1");
        this.host = bundle.getString("test.host");

    }

    //获取cookies
    @Test
    public void getCookies() throws IOException {

        //拼接URL
        this.port = bundle.getString("test.port");
        String url = this.host + this.port + bundle.getString("test.uri");


        //声明get对象
        HttpGet get = new HttpGet(url);

        //声明client对象，设置初始cookies
        this.cookieStore = new BasicCookieStore();
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        //查看初始cookiesstore
        System.out.println("初始cookiesstore值为：" + this.cookieStore);

        //声明response对象，装载client对象执行get请求后的返回
        HttpResponse response = closeableHttpClient.execute(get);
        System.out.println("response = " + response);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println("result = " + result);

        List<Cookie> cookieList = cookieStore.getCookies();

        //打印cookies
        for(Cookie cookie : cookieList){
            System.out.println("cookiesname = " + cookie.getName());
            System.out.println("cookievalue = " + cookie.getValue());
        }


    }


    //携带cookies访问get请求
    @Test(dependsOnMethods = {"getCookies"})
    public void getWithCookies() throws IOException{

        //拼接url
        this.port = bundle.getString("test.port");
        String url = this.host + this.port + bundle.getString("test.get.with.cookies");

        //声明get对象
        HttpGet get = new HttpGet(url);

        //声明client对象，用于执行get请求

        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        System.out.println(this.cookieStore);

        CloseableHttpResponse response = client.execute(get);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println("result = " + result);

        List<Cookie> cookieList = this.cookieStore.getCookies();

        for(Cookie cookie : cookieList){
            System.out.println("cookie name = " + cookie.getName());
            System.out.println("cookie value = " + cookie.getValue());
        }


    }



//携带cookies访问post请求，并json格式数据
    @Test(dependsOnMethods = {"getCookies"})
    public void postWithCookies() throws IOException{
        //拼接URL
        this.port = bundle.getString("test.post.with.cookies2.port");
        String url = this.host + this.port + bundle.getString("test.post.with.cookies2");
        System.out.println("posturl = " + url);
        //声明一个post对象
        HttpPost post = new HttpPost(url);

        //添加post请求参数（json格式）
        JSONObject param = new JSONObject();
        param.put("name","liuboying");
        param.put("age","35");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);



        //添加post请求头header信息
        post.setHeader("content-type","application/json");

        //声明一个client对象
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        //执行post请求,声明一个response对象，装载post请求后返回的response
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(post);
        System.out.println(closeableHttpResponse);

        //

        //处理response
        String result = EntityUtils.toString(closeableHttpResponse.getEntity());
        System.out.println("result = " + result);

        //验证response是否为预期
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);
        if(statusCode == 200){
            System.out.println("返回状态码为200，访问接口成功");
            JSONArray jsonResult = new JSONArray(result);
//        JSONObject jsonResult = new JSONObject(result);
            System.out.println(jsonResult.toString());
            int length = jsonResult.length();

            GetJson json = new GetJson();

            for(int i = 0 ; i < length ; i ++)
            {
                json.setAge(jsonResult.getJSONObject(i).getString("age"));
                json.setName(jsonResult.getJSONObject(i).getString("name"));
                System.out.println("name = " + json.getName());
                System.out.println("age = " + json.getAge());
            }
        }else{
            System.out.println("返回的状态码为：" + statusCode + "，接口访问失败");
        }






    }
}
