package UITests;

import PageObjectModel.MultipleWindowPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowTest extends BaseTest{

    @Test
    public void verifyMultipleWindows() {
        MultipleWindowPage multipleWindowPage = new MultipleWindowPage(driver);
        multipleWindowPage.clickWindowMenu();
        multipleWindowPage.clickWindow();
        multipleWindowPage.switchToAnotherTab();
        Assert.assertEquals(multipleWindowPage.getUrl(), "https://shelendrakumaracademy.com/web/windows/new-tab.html");
    }
}
