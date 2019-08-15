////import org.junit.After;
////import org.junit.Before;
////import org.junit.Test;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import static com.github.dreamhead.moco.Moco.httpserver;
//import static com.github.dreamhead.moco.Runner.runner;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//public class MocoApiTest {
//    private Runner runner;
//
//    @BeforeTest
//    public void setup() {
//        HttpServer server = httpserver(12306);
//        server.response("foo");
//        runner = runner(server);
//        runner.start();
//        helper = new MocoTestHelper();
//    }
//    @AfterTest
//    public void tearDown() {
//        runner.stop();
//    }
//    @Test
//    public void should_response_as_expected() throws IOException {
//        Content content = Request.Get("http://localhost:12306").execute().returnContent();
//        assertThat(content.asString(), is("foo"));
//    }
//}
