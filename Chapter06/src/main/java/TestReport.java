import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestReport {

    @Test
    public void test1(){
        Assert.assertEquals("love","Love");
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test3(){
        Assert.assertFalse(false);
    }

    @Test
    public void test4(){
        Assert.assertEquals("like","like","actual is the same ase the expected");

    }

    @Test
    public void logDemo(){
        Reporter.log("这是我们自己输出的日志");
        throw new RuntimeException("这是我们自己输出的运行时异常");
    }
}
