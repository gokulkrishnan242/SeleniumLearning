package UITests;

import PageObjectModel.IFramePage;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest{

    @Test
    public void verifyIframe() {
        IFramePage iFramePage = new IFramePage(driver);
        iFramePage.clickIframeMenu();
        iFramePage.goToSingleIframe();
        iFramePage.clickClose();
        iFramePage.goToMainPage();
        iFramePage.enterText("QA Engineer at Accenture");
    }

    @Test
    public void verifyNextedIframe() {
        IFramePage iFramePage = new IFramePage(driver);
        iFramePage.clickNextedIframeMenu();
        iFramePage.goToParentInNextedFrame();
        iFramePage.enterUsername("Gokul");
        iFramePage.goToChildFrame();
        iFramePage.enterEmail("gocoolab@gmail.com");
        iFramePage.goToParent();
        iFramePage.enterUsername(" Krishnan");
        iFramePage.goToMainPage();
    }
}
