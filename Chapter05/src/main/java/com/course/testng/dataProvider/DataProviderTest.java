package com.course.testng.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.lang.reflect.Method;//

public class DataProviderTest {

////////实现方法一
    @Test(dataProvider = "data")
    public void dataProviderTest1(String name, int age){
        System.out.println("name = " + name + ";age = " + age);
    }


//注意：此例子中的Object为java.lang包中的对象
    @DataProvider(name="data")
    public Object[][] data(){
        Object[][] o = new Object[][]{
                {"zhangsan",15},
                {"lisi",18},
                {"wangwu",30}
        };
        return o;
    }


    ////////实现方法二
    /**
     *
     * @param name
     * @param age
     * 根据方法不同，传递不同的参数
     */

    @Test(dataProvider = "data2")
    public void dataProviderTest2(String name, int age){
        System.out.println("Test2: name = " + name + "; age = " + age);
    }

    @Test(dataProvider = "data2")
    public void dataProviderTest3(String name, int age){
        System.out.println("Test3: name = " + name + "; age = " + age);
    }
    @DataProvider(name="data2")
    public Object[][] dataProvider2(Method method) {
        //注意引入包：import java.lang.reflect.Method;
        Object[][] o = null;
        if (method.getName().equals("dataProviderTest2")) {

            o = new Object[][]{
                    {"刘1", 10},
                    {"刘2", 20},
                    {"刘3", 30}
            };
            //return o;
        } else if (method.getName().equals("dataProviderTest3")) {
            o = new Object[][]{
                    {"伟1", 30},
                    {"伟2", 40},
                    {"伟3", 50}

            };


        }
        return o;
    }
}
