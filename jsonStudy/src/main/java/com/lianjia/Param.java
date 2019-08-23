package com.lianjia;

public class Param {
    private int city_id;
    private int price_listing;
    private String deal_property;

    public void setCity_id(int city_id){
        this.city_id = city_id;
    }

    public void setpPrice_listing(int price_listing){
        this.price_listing = price_listing;
    }

    public void setDeal_property(String deal_property){
        this.deal_property = deal_property;
    }

    public int getCity_id(){
        return this.city_id;
    }

    public int getPrice_listing(){
        return this.price_listing;
    }

    public String getDeal_property(){
        return this.deal_property;
    }
}
