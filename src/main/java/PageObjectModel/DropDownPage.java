package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage {

    @FindBy(xpath = "//span[text()= 'Dropdown']")
    WebElement dropdownMenu;

    @FindBy(css = "select[id='jobTitle']")
    WebElement dropdownElement;

    @FindBy(css = ".dropdown-selection-summary")
    WebElement selectedOption;

    @FindBy(name = "skills")
    WebElement multipleOption;

    public DropDownPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDropDownMenu() {
        dropdownMenu.click();
    }

    public void clickDropDownButton() {
        dropdownElement.click();
    }

    public void selectOption() {
        Select select = new Select(dropdownElement);
//        select.selectByVisibleText("Engineering");
        select.selectByValue("Engineering");
    }

    public String viewSelectedOption() {
        return selectedOption.getText();
    }

    public String viewSelectedFirstOption() {
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }

    public void viewAllOptionsAndSelect(WebDriver driver) {
        Select select = new Select(multipleOption);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).perform();
       List<WebElement> options = select.getOptions();
       for(WebElement element : options) {
           String text = element.getText();
           element.click();
       }
       action.keyUp(Keys.CONTROL).perform();
    }

    public boolean verifySelectedOption() {
        Select select = new Select(multipleOption);
        List<WebElement> selectedOption = select.getAllSelectedOptions();
        for(WebElement selected : selectedOption) {
            if (selected.getText().contains("API Testing")) {
                return true;
            }
        }
        return false;
    }
}
