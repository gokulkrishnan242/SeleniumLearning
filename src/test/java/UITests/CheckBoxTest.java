package UITests;

import PageObjectModel.CheckBoxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest{

    @Test
    public void verifyCheckBoxes() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.clickCheckBoxMenu();
        checkBoxesPage.isPythonCheckBoxEnabledAndClick();
        Assert.assertTrue(checkBoxesPage.isPythonCheckBoxSelected(), "Python checkBox is not selected");
        checkBoxesPage.isSeleniumCheckBoxEnabledAndClick();
        Assert.assertTrue(checkBoxesPage.isSeleniumCheckBoxSelected(), "Selenium CheckBox is not seected");
    }
}
