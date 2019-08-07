package com.course.testng.groups;


import org.testng.annotations.Test;
//和/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/groupsOnClass.xml配套使用
/**
 * 类的分组测试，运行/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/groupsOnClass.xml
 */
@Test(groups = "stu")
public class groupsOnClass2 {

    public void stu1(){
        System.out.println("groupsOnClass22222中的stu111111运行");
    }

    public void stu2(){
        System.out.println("groupsOnClass22222中的stu2222运行");
    }
}
