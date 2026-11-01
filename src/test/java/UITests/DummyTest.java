package UITests;

import org.testng.annotations.Test;

public class DummyTest extends BaseTest{

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
