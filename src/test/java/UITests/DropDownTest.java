package UITests;

import PageObjectModel.DropDownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest{

    @Test
    public void verifyDropDownForSingleOption() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.clickDropDownMenu();
        dropDownPage.clickDropDownButton();
        dropDownPage.selectOption();
        Assert.assertEquals(dropDownPage.viewSelectedFirstOption(), "Engineering");

    }

    @Test
    public void verifyMultiOptionDropDown() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.clickDropDownMenu();
        dropDownPage.viewAllOptionsAndSelect(driver);
        Assert.assertTrue(dropDownPage.verifySelectedOption(), "API Testing is not selected");
    }
}
