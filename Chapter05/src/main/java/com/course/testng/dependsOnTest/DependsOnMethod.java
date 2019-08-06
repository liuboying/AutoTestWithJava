package com.course.testng.dependsOnTest;

import org.testng.annotations.Test;


//可直接运行，也可运行/Users/liuboying/workplace/AutoTestWithJava/Chapter05/src/main/resources/dependsOnMethod.xml
public class DependsOnMethod {


    @Test
    public void serverStartOk(){
        System.out.println("method1 runs after me.....");
    }



    @Test(dependsOnMethods = {"serverStartOk"})
    public void smethods(){
        System.out.println("I am depended on serverStartedOk......");
    }

    @Test
    public void sclientStartOk(){
        System.out.println("clientStartOk.....");
    }
}
