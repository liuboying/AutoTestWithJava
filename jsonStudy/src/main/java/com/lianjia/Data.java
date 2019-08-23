package com.lianjia;

import org.json.JSONObject;

import java.util.Objects;

public class Data {

    private Selectors selectors;
    private Param param;
    private Payment payment;


    public void setSelectors(Selectors s){
        this.selectors = s;
    }
    public void setParam(Param p){
        this.param = p;
    }
    public void  setPayment(Payment payment){
        this.payment = payment;
    }


    public Selectors getSelectors(){
        return this.selectors;
    }
    public Param getParam(){
        return this.param;
    }
    public Payment getPayment(){
        return this.payment;
    }
}
