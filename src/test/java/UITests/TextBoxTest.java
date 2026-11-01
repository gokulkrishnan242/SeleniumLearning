package UITests;

import PageObjectModel.TextBoxPage;
import Utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test
    public void firstTestBox(){
        TextBoxPage textBox = new TextBoxPage(driver);
        textBox.clickTextBox();
        ScreenshotUtil.captureScreenshot(driver, "textBox");
        textBox.enterEmail("gocoolab@gmail.com");
        ScreenshotUtil.captureScreenshot(driver, "email");
        textBox.clickSend();
        String msg = textBox.getMessage();
        Assert.assertEquals(msg, "A password reset link has been sent to your email: gocoolab@gmail.com");
    }
}
