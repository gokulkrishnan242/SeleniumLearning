package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver getDriver() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        String filePath = "src/test/resources/downloads";
        File file = new File(filePath);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", file.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        option.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(option);
    }
}

