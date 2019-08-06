package com.course.testng;

import org.testng.annotations.Test;

public class ignoreTest {

    @Test(enabled = true,groups = "test1&test2")
    public void test1(){
        System.out.println("test111111111");
    }

    @Test(enabled = true,groups = "test1&test2")
    public void test2(){
        System.out.println("test222222");
    }


    @Test(enabled = false,groups = "test3&test4")
    public void test3(){
        System.out.println("test333333");
    }

    @Test(groups = "test3&test4")
    public void test4(){
        System.out.println("test4444444");
    }
}
