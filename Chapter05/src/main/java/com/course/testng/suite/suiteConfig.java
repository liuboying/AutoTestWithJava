package com.course.testng.suite;

import org.testng.annotations.*;

/**
 * 测试套件运行前的公共配置文件
 */

//和/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/suite.xml配套使用
public class suiteConfig {


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite 运行啦！！！");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite运行啦！！！！");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("bbbbbeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("aaaaaafterTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass!!!!");//@BeforeClass只在有@Test标签的类中起作用。此类中不起作用
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass!!!!!");//@BeforeClass只在有@Test标签的类中起作用。此类中不起作用
    }

//    @Test
//    public void test1(){
//        System.out.println("这是suiteConfig里的带@Test标签的测试方法");
//    }
}
