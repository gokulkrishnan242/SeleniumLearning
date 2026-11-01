package UITests;

import PageObjectModel.AlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    @Test
    public void verifyAcceptAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickAlertMenu();
        alertPage.clickAlertBtn();
        Assert.assertEquals(alertPage.getAlertText(), "I am a JS Confirm!");
        alertPage.acceptAlert();
    }

    @Test
    public void verifyDismissAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickAlertMenu();
        alertPage.clickAlertBtn();
        Assert.assertEquals(alertPage.getAlertText(), "I am a JS Confirm!");
        alertPage.dismissAlert();
    }
}
