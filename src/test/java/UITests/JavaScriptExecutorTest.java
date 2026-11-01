package UITests;

import PageObjectModel.JavaScriptExecutorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest{

    @Test
    public void verifyJavaScriptExecutorSendKeys() {
        JavaScriptExecutorPage jsPage = new JavaScriptExecutorPage(driver);
        jsPage.clickJsMenu();
        jsPage.sendText("Gokulkrishnan");
        Assert.assertTrue(jsPage.viewStatus().contains("Gokulkrishnan"), "Status does not contains Gokulkrishnan");
    }

    @Test
    public void verifyClick() {
        JavaScriptExecutorPage jsPage = new JavaScriptExecutorPage(driver);
        jsPage.clickJsMenu();
        jsPage.clickJsBtn();
    }

    @Test
    public void verifyScroLLToThirdButton() {
        JavaScriptExecutorPage jsPage = new JavaScriptExecutorPage(driver);
        jsPage.clickScrollMenu();
        jsPage.scrollIntoLastButton();
    }

    @Test
    public void verifyScrollToThirdButtonToCenter() {
        JavaScriptExecutorPage jsPage = new JavaScriptExecutorPage(driver);
        jsPage.clickScrollMenu();
        jsPage.scrollToThirdButtonToCenter();
    }

    @Test
    public void verifyScrollDown() {
        JavaScriptExecutorPage jsPage = new JavaScriptExecutorPage(driver);
        jsPage.clickScrollMenu();
        jsPage.scrollDown();
    }

    @Test
    public void verifyScrollDownToBottom() throws InterruptedException {
        JavaScriptExecutorPage jsPage = new JavaScriptExecutorPage(driver);
        jsPage.clickScrollMenu();
        jsPage.scrollToBottomWithSmooth();
        Thread.sleep(5000);
//        jsPage.scrollToTop();
        jsPage.scrollTopSmooth();
    }
}
