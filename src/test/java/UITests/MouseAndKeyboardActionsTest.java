package UITests;

import PageObjectModel.MouseAndKeyboardActionsPage;
import Utils.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(Listener.TestListener.class)
public class MouseAndKeyboardActionsTest extends BaseTest{

    private static final Logger log = LogManager.getLogger(MouseAndKeyboardActionsTest.class);


    @Test (priority = 1, groups = {"smoke"})
    public void verifyMouseAction() throws InterruptedException{
        MouseAndKeyboardActionsPage mouse = new MouseAndKeyboardActionsPage(driver);
        ExtentTestManager.logInfo("Mouse action is being Started");
        log.info("Clicking the Mouse Hover menu button");
        mouse.clickMouseHoverMenu();
        Thread.sleep(5000);
        log.info("Clicking the mouse action");
        ExtentTestManager.logInfo("Mouse action is being Ended");
        mouse.moveMouseToElement();
    }

    @Test (priority = 2, groups = {"smoke"})
    public void verfyDoubleClick() {
        SoftAssert softAssert = new SoftAssert();
        ExtentTestManager.logInfo("Double click action is being Started");
        MouseAndKeyboardActionsPage mouse = new MouseAndKeyboardActionsPage(driver);
        mouse.clickMouseHoverMenu();
        String msg = mouse.clickDoubleClick();
        softAssert.assertEquals(msg, "Double click successful! You have triggered the double-click action.");
        ExtentTestManager.logInfo("Double click action is being Ended");
        softAssert.assertAll();
    }

    @Test (priority = 3, groups = {"smoke"})
    public void verifyDragAndDrop() {
        ExtentTestManager.logInfo("Drag and Drop action is being Started");
        MouseAndKeyboardActionsPage mouse = new MouseAndKeyboardActionsPage(driver);
        mouse.clickMouseHoverMenu();
        String message = mouse.doDragAndDrop();
        Assert.assertEquals(message, "Drag and drop successful! The box was moved to the drop zone.");
        ExtentTestManager.logInfo("Drag and Drop action is being Ended");
    }

    @Test (priority = 4, groups = {"smoke"})
    public void verifyManualDragAndDrop() {
        ExtentTestManager.logInfo("Drag and Drop action is being Started");
        MouseAndKeyboardActionsPage mouse = new MouseAndKeyboardActionsPage(driver);
        mouse.clickMouseHoverMenu();
        String message = mouse.manulDragAndDrop();
        Assert.assertEquals(message, "Drag and drop successful! The box was moved to the drop zone.");
        ExtentTestManager.logInfo("Drag and Drop action is being Ended");
    }
}
