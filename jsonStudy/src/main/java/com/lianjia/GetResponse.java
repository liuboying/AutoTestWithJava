package com.lianjia;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.ResourceBundle;

public class GetResponse {

    private String host;
    private ResourceBundle bundle;
    private String result;



    //从配置文件中获取地址
    @BeforeTest
    public void getProperties(){
        this.bundle = ResourceBundle.getBundle("config");
        this.host = bundle.getString("lianjia.host");


    }
    //访问接口，获得response
    @Test
    public void getLianja() throws IOException {
        //拼接Url
        String uri = bundle.getString("lianjia.uri");
        String url = host + uri;
        System.out.println("///////////url = " + url);

        //声明get方法
        HttpGet get = new HttpGet(url);
        //声明client对象，执行get请求
        CloseableHttpClient client = HttpClients.custom().build();
        CloseableHttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity());
        System.out.println("result = " + result);

    }


    //解析response中的json数据
    @Test(dependsOnMethods = {"getLianja"})
    public void getJson(){
        JSONObject jsonObject = new JSONObject(this.result);
        JsonTest jsonTest = new JsonTest();
        jsonTest.setErrorCode(jsonObject.getInt("errorCode"));
        System.out.println("errorcode = " + jsonTest.getErrorCode());

        //解析第二个大括号Data
        Data data = new Data();
        JSONObject jsonObjectData = jsonObject.getJSONObject("data");
        System.out.println(jsonObjectData.toString());

        //解析第三个大括号payment
        Payment payment = new Payment();
        JSONObject jsonObjectPyament = jsonObjectData.getJSONObject("payment");
        payment.setCost_tax(jsonObjectPyament.getFloat("cost_tax"));
        payment.setCost_jingjiren(jsonObjectPyament.getFloat("cost_jingjiren"));
        payment.setCost_house(jsonObjectPyament.getInt("cost_house"));
        System.out.println("cost_tax = " + payment.getCost_tax() + " ,cost_jingjiren = "
                + payment.getCost_jingjiren()
                + ", cost_house = " + payment.getCost_house());
        //解析payment下的大括号loan_info

        LoanInfo loanInfo = new LoanInfo();
        JSONObject jsonObjectLoan_info = jsonObjectPyament.getJSONObject("loan_info");
        //解析loaninfo下的epp
        Epp epp = new Epp();
        JSONObject jsonObjectEpp = jsonObjectLoan_info.getJSONObject("epp");
        System.out.println(jsonObjectEpp.toString());
        epp.setInterest(jsonObjectEpp.getInt("interest"));
        epp.setMpd(jsonObjectEpp.getInt("mpd"));
        epp.setTm(jsonObjectEpp.getInt("tm"));
        epp.setTotal(jsonObjectEpp.getInt("total"));

        System.out.println("interest = " + epp.getInterest()
                + ",mpd = " + epp.getMpd() + ",tm = " + epp.getMp()
                + ",total = " + epp.getTotal());

        //解析payment下的大括号tax_info
        TaxInfo taxInfo = new TaxInfo();
        JSONObject jsonObjectTaxInfo = jsonObjectPyament.getJSONObject("tax_info");
        System.out.println(jsonObjectTaxInfo.toString());
        JSONArray jsonArrayList = jsonObjectTaxInfo.getJSONArray("list");
        System.out.println(jsonArrayList.toString());

        for(int i = 0 ;i < jsonArrayList.length(); i ++){
            //System.out.println(jsonArrayList.get(i));
            JSONObject temp = new JSONObject(jsonArrayList.get(i).toString());
            System.out.println("name = " + temp.getString("name") + ",tax = " + temp.getInt("tax"));
        }

    }



}
