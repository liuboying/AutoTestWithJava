package com.course.testng.dataProvider;


import org.testng.annotations.Test;

/**
 * @Test注释用于class时，会将class下所有未用注释的方法都变成@Test注释的方法。
 */
@Test
public class TestAnotationOnClass {

    public void test(){
        System.out.println("test1111 runs");
    }

    public void test2(){
        System.out.println("test2222 runs");
    }
}
