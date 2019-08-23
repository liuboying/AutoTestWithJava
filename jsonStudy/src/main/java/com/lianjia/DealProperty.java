package com.lianjia;

public class DealProperty {
    private String name;
    private int value;
    private boolean selected;

    public void setName(String name){
        this.name = name;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }
    public boolean getSelected(){
        return this.selected;
    }
}
