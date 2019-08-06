package com.course.testng;

import org.testng.annotations.*;

public class baseAnnotation {

    @Test
    public void testCase1(){
        System.out.println("这是一个测试用例1");
    }

    @BeforeMethod
    public void beforMethod(){
        System.out.println("在测试方法前运行的beforMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("在测试方法之后运行");
    }

    @Test
    public void testCase2(){
        System.out.println("测试用例2");
    }

    @AfterClass
    public void beforeClass(){
        System.out.println("在类运行后运行：AfterClass");
    }

    @BeforeClass
    public void afterClass(){
        System.out.println("类运行前运行：BeforeClass");
    }


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("类运行前运行：BeforeSutie");//suite可包含多个类class，在类运行前运行
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("类运行前运行：AfterSuite");//suite可包含多个类class，在类运行后运行
    }


}

