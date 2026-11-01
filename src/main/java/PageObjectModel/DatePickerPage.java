package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerPage {

    @FindBy(xpath = "//span[text() = 'Calendar']")
    WebElement calendarMenu;

    @FindBy(css = "input[type = 'text'][id = 'from']")
    WebElement from;

    @FindBy(xpath = "//input[@type = 'text' and @id = 'to']")
    WebElement to;

    @FindBy(css = "#departure")
    WebElement departureDate;

    @FindBy(css = "#return")
    WebElement returnDate;

    @FindBy(xpath = "//button[@aria-label = 'Go to the Next Month']")
    WebElement goToNextMonth;

    @FindBy(xpath = "//button[text() = '30']")
    WebElement selectDepDate;

    @FindBy(xpath = "//button[text() = '31']")
    WebElement selectReturnDate;

    @FindBy(css = ".search-btn")
    WebElement submitBtn;

    @FindBy(xpath = "//span[@id = 'flight-number']")
    WebElement flightNo;

    @FindBy(xpath = "//span[@id = 'flight-number']/preceding-sibling::span")
    WebElement flightName;

    @FindBy(xpath = "//span[@id = 'flight-number']/following-sibling::span")
    WebElement flightAvailability;

    public DatePickerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCalendarMenu() {
        calendarMenu.click();
    }

    public void enterFromAddress(String fromAddress) {
        from.click();
        from.sendKeys(fromAddress);
    }
    public void enterToAddress(String toAddress) {
        to.click();
        to.sendKeys(toAddress);
    }

    public void selectFromDate() {
        departureDate.click();
        selectDepDate.click();
    }

    public void selectToDate() {
        returnDate.click();
        selectReturnDate.click();
    }

    public void submitDate() {
        submitBtn.click();
    }

    public String getFlightNo() {
        return flightNo.getText();
    }

    public String getFlightName() {
        return flightName.getText();
    }

    public String getFlightStatus() {
        return flightAvailability.getText();
    }
}
