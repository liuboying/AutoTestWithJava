package com.course.testng.suite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 逻辑控制类
 */


//和/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/suite.xml配套使用
public class loginTest {

    @Test
    public void testLogin(){
        System.out.println("淘宝登录成功了！！！！！");
    }

//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("beforeClass!!!!");
//    }
//
//    @AfterClass
//    public void afterClass(){
//        System.out.println("afterClass!!!!!");
//    }
}
