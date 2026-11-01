package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {

    //Locators

    @FindBy(xpath = "//span[text() = 'Text box']")
    WebElement textBox;

    @FindBy(css = "#email-input")
    WebElement emailBox;

    @FindBy(css = ".send-button")
    WebElement sendBtn;

    @FindBy(className = "message")
    WebElement message;

    public TextBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

        //Methods

        public void clickTextBox() {
        textBox.click();
        }

        public void enterEmail(String email) {
            emailBox.sendKeys(email);
        }

        public void clickSend() {
            sendBtn.click();
        }
        public String getMessage() {
            return message.getText();
            }

    }
