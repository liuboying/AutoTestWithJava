package com.course.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//和/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/parametertest.xml配套使用
public class ParameterTest {

    @Test
    @Parameters({"name","age"})//该标签只能和@Test，@BeforeTest@AfterTest标签一起使用
    public void parameterTest(String name, int age){
        System.out.println("name = " + name + ";age = " + age);
    }


    @Test
    @Parameters({"param1"})
    public void parameterTestOptional(@Optional("如果xml中无对应参数则使用我") String name){///@Option修饰后，xml文件中无param1参数，则使用@Optional修饰的字段。
        System.out.println("name = " + name);

    }
}
