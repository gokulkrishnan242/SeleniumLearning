package UITests;

import PageObjectModel.SynchronizationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SynchronizationTest extends BaseTest{


    @Test
    public void verifyImplicitWait() {
        SynchronizationPage sPage = new SynchronizationPage(driver);
        sPage.clickSyncMenu();
        sPage.clickImplicitButton();
        Assert.assertEquals(sPage.implicitString(), "Profile loaded successfully.");
    }

    @Test
    public void verifyExplicitWait() {
        SynchronizationPage sPage = new SynchronizationPage(driver);
        sPage.clickSyncMenu();
        sPage.clickExplicitButton();
        Assert.assertTrue(sPage.explicitString(), "Text is not visible");
    }

    @Test
    public void verifyFluentWait() {
        SynchronizationPage sPage = new SynchronizationPage(driver);
        sPage.clickSyncMenu();
        sPage.clickFluentButton();
        Assert.assertTrue(sPage.fluentString(), "Status message is incorrect");
    }
}
