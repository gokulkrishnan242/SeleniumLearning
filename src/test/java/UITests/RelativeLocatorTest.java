package UITests;

import PageObjectModel.RelativeLocatorsPage;
import org.testng.annotations.Test;

public class RelativeLocatorTest extends BaseTest{

    @Test
    public void verifyRelators() {
        RelativeLocatorsPage relativeLocatorsPage = new RelativeLocatorsPage(driver);
        relativeLocatorsPage.clickRelativeLocatorMenu();
        relativeLocatorsPage.enterUserName("Gokulkrishnan");
        relativeLocatorsPage.enterSearchText("QA Engineer");
    }
}
