package PageObjectModel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    protected WebDriver driver;
    private Alert alert;

    @FindBy(xpath = "//span[text() = 'JavaScript Alert']")
    WebElement alertMenu;

    @FindBy(css = "#jsConfirm")
    WebElement alertBtn;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAlertMenu() {
        alertMenu.click();
    }

    public void clickAlertBtn() {
        alertBtn.click();
    }

    public String getAlertText() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

}
