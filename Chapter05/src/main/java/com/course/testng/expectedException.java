package com.course.testng;

import org.testng.annotations.Test;

public class expectedException {
    /**
     * 在期望结果为某个异常的时候，需要使用异常测试，如传入某些不合法的参数，程序会抛出异常，此时需要用TestNG的异常测试
     */

    //这是一个测试结果失败的异常测试

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionTestFailed(){
        System.out.println("这是一个失败的异常测试");

    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionTestSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }

}
