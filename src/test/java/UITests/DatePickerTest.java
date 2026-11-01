package UITests;

import PageObjectModel.DatePickerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest{

    @Test
    public void verifyDatePicker() {
        DatePickerPage datePickerPage = new DatePickerPage(driver);
        datePickerPage.clickCalendarMenu();
        datePickerPage.enterFromAddress("Coimbatore");
        datePickerPage.enterToAddress("Bengaluru");
        datePickerPage.selectFromDate();
        datePickerPage.selectToDate();
        datePickerPage.submitDate();
        Assert.assertEquals(datePickerPage.getFlightName(), "IndiGo");
        Assert.assertEquals(datePickerPage.getFlightNo(), "6E-204");
        Assert.assertEquals(datePickerPage.getFlightStatus(), "Available");
    }
}
