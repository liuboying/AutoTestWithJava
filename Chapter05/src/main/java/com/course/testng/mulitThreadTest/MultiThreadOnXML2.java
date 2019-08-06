package com.course.testng.mulitThreadTest;


import org.testng.annotations.Test;

/**
 * 通过XML实现多线程
 * 运行/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/MultiThreadOnXML.xml
 */
public class MultiThreadOnXML2 {


    @Test
    public void test1(){
        System.out.printf("线程id为：%s%n",Thread.currentThread().getId());

    }

    @Test
    public void test2(){
        System.out.printf("线程id为：%s%n",Thread.currentThread().getId());

    }

    @Test
    public void test3(){
        System.out.printf("线程id为：%s%n",Thread.currentThread().getId());

    }
}
