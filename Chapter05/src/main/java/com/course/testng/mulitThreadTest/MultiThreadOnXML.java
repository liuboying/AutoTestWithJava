package com.course.testng.mulitThreadTest;


import org.testng.annotations.Test;

/**
 * 通过XML实现多线程
 * 运行/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/MultiThreadOnXML.xml
 */
public class MultiThreadOnXML {

    @Test
    public void test1(){
        System.out.printf("Threa Id : %s%n",Thread.currentThread().getId());
    }


    @Test
    public void test2()
    {
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }


    @Test
    public void test3(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}
