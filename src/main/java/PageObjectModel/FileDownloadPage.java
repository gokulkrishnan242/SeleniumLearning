package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloadPage {

    @FindBy(xpath = "//span[text() = 'Download File']")
    WebElement fileDownloadMenu;

    @FindBy(id = "download-sample-file")
    WebElement downloadBtn;

    public FileDownloadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDownloadMenu() {
        fileDownloadMenu.click();
    }

    public void clickDownloadBtn() {
        downloadBtn.click();
    }


    public boolean verifyDownloadedFile() {
        File file = new File("src/test/resources/downloads", "practice-sample.txt").getAbsoluteFile();
        if(file.exists()) {
            return true;
        }
        return false;
    }

    public void deleteFile() {
        File file = new File("src/test/resources/downloads", "practice-sample.txt").getAbsoluteFile();
        if(file.exists()) {
            file.delete();
        }
    }
}
