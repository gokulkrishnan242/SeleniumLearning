package UITests;

import Utils.ConfigReader;
import Utils.ExcelDataProvider;
import Utils.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class ExcelReaderTest {

    @Test (dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
    public void printData(String key) {

        Map<String, String> data = ExcelReader.getRowValues(key);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(data.get("username"));
        driver.findElement(By.id("password")).sendKeys(data.get("password"));
        driver.findElement(By.id("login-button")).click();
    }


    @Test
    public void login() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(ConfigReader.getConfigData("username"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getConfigData("password"));
        driver.findElement(By.id("login-button")).click();
    }
}
