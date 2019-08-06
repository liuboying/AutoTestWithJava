package com.course.testng.dependsOnTest;

import org.testng.annotations.Test;

public class DependsOnGroups {

    @Test(groups = "init")
    public void serverStartOk(){
        System.out.println("method1 runs after me.....");
    }

    @Test(groups = "init2")
    public void initEnvironment(){
        System.out.println("initEnvironment.....");
        throw new RuntimeException();
    }

    @Test(dependsOnGroups = {"init.*"},alwaysRun = true)//alwaysRun属性为true时，被依赖方法执行失败，不影响依赖的方法执行，称为软依赖
    public void method1(){
        System.out.println("Im over here....");
    }
}
