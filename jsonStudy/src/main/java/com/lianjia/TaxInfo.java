package com.lianjia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TaxInfo {

    private int total;
    private float tax_base;

    private ArrayList list;

    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }

    public void setTax_base(float tax_base){
        this.tax_base = tax_base;
    }

    public float getTax_base(){
        return this.tax_base;
    }

    public void setList(ArrayList list){
        this.list = list;
    }
    public ArrayList getList(){
        return this.list;
    }
}
