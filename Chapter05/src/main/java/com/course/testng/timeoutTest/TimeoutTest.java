package com.course.testng.timeoutTest;

import org.testng.annotations.Test;

public class TimeoutTest {

    @Test(timeOut = 4000)
    public void timeoutSuccess() throws InterruptedException {
        Thread.sleep(3000);
    }


    @Test(timeOut = 2000)
    public void test2() throws InterruptedException {
        Thread.sleep(2001);
    }
}
