package PageObjectModel;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationPage {

    protected WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Synchronization']")
    WebElement synchronizationMenu;

    @FindBy(id = "load-user-profile-button")
    WebElement implicitButton;

    @FindBy(css = "#place-order-button")
    WebElement explicitButton;

    @FindBy(id = "track-payment-status-button")
    WebElement fluentButton;

    @FindBy(id = "implicit-wait-result")
    WebElement implicitStatus;

    @FindBy(id = "explicit-wait-demo")
    WebElement explicitStatus;

    @FindBy(id = "fluent-wait-result")
    WebElement fluetStatus;


    public SynchronizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSyncMenu() {
        synchronizationMenu.click();
    }

    public void clickImplicitButton() {
        implicitButton.click();
    }

    public String implicitString() {
        return implicitStatus.getText();
    }

    public void clickExplicitButton() {
        explicitButton.click();
    }

    public boolean explicitString() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         return wait.until(ExpectedConditions.textToBePresentInElement(explicitStatus, "Order placed successfully! Your order confirmation is now visible."));
    }

    public void clickFluentButton() {
        fluentButton.click();
    }

    public boolean fluentString() {
        Wait<WebElement> wait = new FluentWait<>(fluetStatus)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        return wait.until(e -> e.getText().equals("Payment completed successfully! Funds have been received."));
    }
}
