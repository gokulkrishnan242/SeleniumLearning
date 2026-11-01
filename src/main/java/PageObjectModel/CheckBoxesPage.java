package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPage {

    @FindBy(xpath = "//span[text() = 'Checkbox']")
    WebElement checkBox;

    @FindBy(xpath = "//input[@type = 'checkbox' and @id = 'checkbox-python']")
    WebElement pythonCheckBox;

    @FindBy(css = "input[type='checkbox'][id = 'checkbox-selenium']")
    WebElement seleniumCheckBox;

    public CheckBoxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckBoxMenu() {
        checkBox.click();
    }

    public void isPythonCheckBoxEnabledAndClick() {
        if(pythonCheckBox.isEnabled()) {
            pythonCheckBox.click();
        }
    }

    public boolean isPythonCheckBoxSelected() {
        if(pythonCheckBox.isSelected()) {
            return true;
        }
        return false;
    }

    public void isSeleniumCheckBoxEnabledAndClick() {
        if (seleniumCheckBox.isEnabled()) {
            seleniumCheckBox.click();
        }
    }

    public boolean isSeleniumCheckBoxSelected() {
        if(seleniumCheckBox.isSelected()) {
            return true;
        }
        return false;
    }

}
