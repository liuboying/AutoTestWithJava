package com.lianjia;

public class Payment {
    private float cost_house;
    private float cost_tax;
    private float cost_jingjiren;
    private TaxInfo tax_info;
    private LoanInfo loan_Info;

    public void setCost_house(float cost_house){
        this.cost_house = cost_house;
    }
    public void setCost_tax(float cost_tax){
        this.cost_tax = cost_tax;
    }

    public void setCost_jingjiren(float cost_jingjiren){
        this.cost_jingjiren = cost_jingjiren;
    }


    public void setTax_info(TaxInfo tax_info){
        this.tax_info = tax_info;
    }

    public void setLoan_Info(LoanInfo loan_Info){
        this.loan_Info = loan_Info;
    }

    public float getCost_house(){
        return this.cost_house;
    }

    public float getCost_tax(){
        return this.cost_tax;
    }
    public float getCost_jingjiren(){
        return this.cost_jingjiren;
    }
    public TaxInfo getTax_info(){
        return this.tax_info;
    }
    public LoanInfo getLoan_Info(){
        return this.loan_Info;
    }


}
