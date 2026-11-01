package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {

    @FindBy(xpath = "//span[text() = 'Radio button']")
    WebElement radioButtonMenu;

    @FindBy(css = "#radio-beginner.radio")
    WebElement beginnerRadioBtn;

    @FindBy(xpath = "//form[@class = 'radio-group']/descendant::input[@id ='radio-advanced']")
    WebElement advancedRadioButton;

    public RadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRadioButtonMenu() {
        radioButtonMenu.click();
    }

    public void isEnabledAndClickBeginner() {
        if(beginnerRadioBtn.isEnabled()) {
            beginnerRadioBtn.click();
        }
    }

    public boolean isBeginnerRadioButtonSelected() {
        if(beginnerRadioBtn.isSelected()) {
            return true;
        }
        return false;
    }

    public void isRadioAdvancedRadioButtonEnabledAndClick() {
        if(advancedRadioButton.isEnabled()) {
            advancedRadioButton.click();
        }
    }

    public boolean isAdvancedRadioSelected() {
        if(advancedRadioButton.isSelected()) {
            return true;
        }
        return false;
    }
}
