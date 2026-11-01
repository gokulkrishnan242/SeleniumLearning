package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {

    protected WebDriver driver;

    private String singleFrame = "jquery-dialog-iframe";
    private String parentFrame = "parent-frame";
    private String childFrame = "child-frame";

    @FindBy(xpath = "//span[text() = 'Iframe']")
    WebElement iframeMenu;

    @FindBy(xpath = "//span[text() = 'Nested Iframe']")
    WebElement nextedIframeMenu;

    @FindBy(css = "#dialog-close-button")
    WebElement closeBtn;

    @FindBy(css = ".iframe-text-field")
    WebElement textBox;

    @FindBy(id = "parent-username")
    WebElement username;

    @FindBy(className = "nested-email-input")
    WebElement email;

    public IFramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickIframeMenu() {
        iframeMenu.click();
    }

    public void clickNextedIframeMenu() {
        nextedIframeMenu.click();
    }

    public void goToSingleIframe() {
        driver.switchTo().frame(singleFrame);
    }

    public void clickClose() {
        closeBtn.click();
    }

    public void goToMainPage() {
        driver.switchTo().defaultContent();
    }

    public void enterText(String text) {
        textBox.click();
        textBox.sendKeys(text);
    }

    public void goToParentInNextedFrame() {
        driver.switchTo().frame(parentFrame);
    }

    public void enterUsername(String user) {
        username.click();
        username.sendKeys("Gokul");
    }

    public void goToChildFrame() {
        driver.switchTo().frame(childFrame);
    }

    public void enterEmail(String mail) {
        email.click();
        email.sendKeys(mail);
    }

    public void goToParent() {
        driver.switchTo().parentFrame();
    }
}
