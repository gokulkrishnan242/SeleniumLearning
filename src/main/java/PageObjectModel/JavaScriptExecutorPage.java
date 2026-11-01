package PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptExecutorPage {

    protected WebDriver driver;
//    private String text = "RadhaKrishnan";

    @FindBy(xpath = "//span[text() = 'JavaScript Executor']")
    WebElement jsMenu;

    @FindBy(css = "#js-executor-text-input")
    WebElement textBox;

    @FindBy(id = "js-executor-text-value")
    WebElement textResult;

    @FindBy(className = "js-executor-button")
    WebElement clickBtn;

    @FindBy(xpath = "//span[text() = 'Scroll']")
    WebElement scrollMenu;

    @FindBy(xpath = "//button[text() = 'Button 3']")
    WebElement button3;

    public JavaScriptExecutorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickJsMenu() {
        jsMenu.click();
    }

    public void sendText(String text) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = arguments[1];", textBox, text);

    }

    public String viewStatus() {
        return textResult.getText();
    }

    public void clickJsBtn() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clickBtn);
    }

    public void clickScrollMenu() {
        scrollMenu.click();
    }

    public void scrollIntoLastButton() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", button3);
    }

    public void scrollToThirdButtonToCenter() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView({block : 'center'});", button3);
    }

    public void scrollDown() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0, 500);");
    }

    public void scrollToBottom() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToBottomWithSmooth() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo({top : document.body.scrollHeight, behavior : 'smooth'});");
    }

    public void scrollToTop() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollTopSmooth() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo({top : 0, behavior : 'smooth'})");
    }
}
