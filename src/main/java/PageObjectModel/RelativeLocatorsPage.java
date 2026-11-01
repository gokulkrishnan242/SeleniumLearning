package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsPage {

    protected WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Relative locators']")
    WebElement relativeLocatorsMenu;

//    @FindBy(xpath = "//button[@id = 'login-button']")
//    WebElement loginBtn;

//    @FindBy(css = "#submit-button")
//    WebElement submitBtn;

    public RelativeLocatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRelativeLocatorMenu() {
        relativeLocatorsMenu.click();
    }

    public WebElement getUserName() {
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id = 'login-button']"));
        return driver.findElement(with(By.xpath("//input[@placeholder = 'Element above anchor']")).above(loginBtn));
    }

    public void enterUserName(String user) {
        WebElement element = getUserName();
        element.click();
        element.sendKeys(user);
    }

    public WebElement getSearchBox() {
        WebElement submitBtn = driver.findElement(By.cssSelector("#submit-button"));
        return driver.findElement(with(By.cssSelector("input[placeholder = 'Element to the left']")).toLeftOf(submitBtn));
    }

    public void enterSearchText(String text) {
        WebElement element = getSearchBox();
        element.click();
        element.sendKeys(text);
    }

    public void navigateTo() {
        driver.navigate().refresh();
    }
}
