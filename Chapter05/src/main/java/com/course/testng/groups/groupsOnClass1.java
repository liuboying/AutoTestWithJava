package com.course.testng.groups;


//和/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/groupsOnClass.xml配套使用
import org.testng.annotations.Test;

/**
 * 类的分组测试，运行/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/groupsOnClass.xml
 */

@Test(groups = "stu")
public class groupsOnClass1 {

    public void stu1(){
        System.out.println("groupsOnClass11111中的stu111111运行");
    }


    public void stu2(){
        System.out.println("groupsOnClass11111中的stu22222运行");
    }

}
