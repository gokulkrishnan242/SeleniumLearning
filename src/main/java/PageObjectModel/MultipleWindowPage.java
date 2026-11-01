package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class MultipleWindowPage {

    protected WebDriver driver;

    @FindBy (xpath = "//span[text() = 'Multiple windows']")
    WebElement windowsMenu;

    @FindBy (css = ".open-window-button")
    WebElement newWindowBtn;

    public MultipleWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWindowMenu() {
        windowsMenu.click();
    }

    public void clickWindow() {
        newWindowBtn.click();
    }

    public void switchToAnotherTab() {
        String parent = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles) {
            if(!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
