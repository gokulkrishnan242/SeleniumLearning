package UITests;

import PageObjectModel.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void verifyRadioButton() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickRadioButtonMenu();
        radioButtonPage.isEnabledAndClickBeginner();
        Assert.assertTrue(radioButtonPage.isBeginnerRadioButtonSelected(), "Beginner Radio button is not Selected");
        radioButtonPage.isRadioAdvancedRadioButtonEnabledAndClick();
        Assert.assertTrue(radioButtonPage.isAdvancedRadioSelected(), "Advanced Radio Button is not Selected");
        Assert.assertFalse(radioButtonPage.isBeginnerRadioButtonSelected(), "Beginner Radio button is Selected");
    }
}
