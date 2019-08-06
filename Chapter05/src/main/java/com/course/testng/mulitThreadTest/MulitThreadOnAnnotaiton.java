package com.course.testng.mulitThreadTest;

import org.testng.annotations.Test;

/**
 * 通过invocationCount及threadPoolSize实现多线程
 */

public class MulitThreadOnAnnotaiton {


    //invocationCount+threacSize来控制线程个数，和Size数量一致，threadPoolSize为最大并发数
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void mulitThreadOnAnnotation(){
        System.out.println(1);

        System.out.printf("Thread Id: %s%n", Thread.currentThread().getId() );
    }
}
