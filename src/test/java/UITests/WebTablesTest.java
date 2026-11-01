package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest{

    @Test
    public void displayWebTables() {
        driver.findElement(By.xpath("//span[text() = 'Web table']")).click();
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id = 'employee-table']/child::thead/child::tr/child::th"));
        for (WebElement header : headers) {
            System.out.print(header.getText() + " | ");
        }
        System.out.println();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'employee-table']/child::tbody/child::tr"));
        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println();
        }
    }
}
