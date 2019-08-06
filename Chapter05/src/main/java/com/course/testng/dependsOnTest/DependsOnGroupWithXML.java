package com.course.testng.dependsOnTest;

import org.testng.annotations.Test;

//运行/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/dependsOnGroupWithXML.xml

public class DependsOnGroupWithXML {

    @Test(groups = "stu")
    public void stu1(){
        System.out.println("stu组中的stu1运行");
    }


    @Test(groups = "stu")
    public void stu2(){
        System.out.println("stu组中的stu2运行");
    }


    @Test(groups = "teacher")
    public void teacher1(){
        System.out.println("teacher组的teacher11111运行");
    }

    @Test(groups = "teacher")
    public void teacher2(){
        System.out.println("teacher组的teacher222222运行");
    }

    @Test(groups = "person")
    public void person1(){
        System.out.println("person组的person111111运行");
    }

    @Test(groups = "person")
    public void person2(){
        System.out.println("person组的person22222运行");
    }


    @Test(groups = "person1")
    public void person1_1(){
        System.out.println("person1组的person1_1111运行");
    }
}
