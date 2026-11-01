package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseAndKeyboardActionsPage {

    protected WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Mouse actions']")
    WebElement mouseActionMenu;

    @FindBy(className = "mouse-hover-trigger")
    WebElement mouseHover;

    @FindBy(css = ".double-click-button")
    WebElement doubleClick;

    @FindBy(id = "double-click-message")
    WebElement doubleClickMessage;

    @FindBy(css = ".drag-and-drop-source ")
    WebElement source;

    @FindBy(css = "#drop-target")
    WebElement target;

    @FindBy(xpath = "//p[@class = 'drag-and-drop-message']")
    WebElement dragAndDropMessage;


    public MouseAndKeyboardActionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMouseHoverMenu() {
        mouseActionMenu.click();
    }

    public void moveMouseToElement() {
        Actions action = new Actions(driver);
        action.moveToElement(mouseHover).perform();
        action.contextClick().perform();
    }

    public String clickDoubleClick() {
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).perform();
        return doubleClickMessage.getText();
    }

    public String doDragAndDrop() {
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).perform();
        return dragAndDropMessage.getText();
    }

    public String manulDragAndDrop() {
        Actions action = new Actions(driver);
        action.clickAndHold(source).moveToElement(target).release().perform();
        return dragAndDropMessage.getText();
    }
}
