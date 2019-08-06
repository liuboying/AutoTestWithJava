package com.course.testng;

import org.testng.annotations.Test;

public class dependTest {


    @Test
    public void test1(){
        System.out.println("test111111");
    }


    @Test(dependsOnMethods = {"test7"})
    public void test2(){
        System.out.println("test22222");

    }


    @Test
    public void test3(){
        System.out.println("test33333");
    }


    @Test
    public void test4(){
        System.out.println("test4444");
    }


    @Test
    public void test5(){
        System.out.println("test5555");
    }

    @Test
    public void test6(){
        System.out.println("test66666");
    }


    @Test
    public void test7(){
        System.out.println("test7777");
    }
}
