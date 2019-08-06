package com.course.testng.groups;


import org.testng.annotations.Test;
//和/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/groupsOnClass.xml配套使用
@Test(groups = "teacher")
public class groupsOnClass3 {

    public void teacher1(){
        System.out.println("groupsOnClass33333中的teacher11111运行");
    }

    public void teacher2(){
        System.out.println("groupsOnClass33333中的teacher22222运行");
    }
}
