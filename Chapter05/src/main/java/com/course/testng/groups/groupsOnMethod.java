package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("服务端test11111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("服务端test22222");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("客户端test3333");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("客户端test4444");
    }


    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("在客户端组运行前执行beforeGroupsOnServer");
    }

    @AfterGroups("server")
    public void afterGropusOnServer(){
        System.out.println("在客户端组运行后执行afterGropusOnServer");
    }


    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("在客户端组运行前执行beforeGroupsOnClient");
    }

    @AfterGroups("client")
    public void afterGropusOnClient(){
        System.out.println("在客户端组运行后执行afterGropusOnClient");
    }

}
