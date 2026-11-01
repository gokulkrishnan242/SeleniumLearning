package UITests;

import PageObjectModel.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest{

    @Test
    public void verifyDownload() {
        FileDownloadPage fPage = new FileDownloadPage(driver);
//        fPage.clickDownloadMenu();
//        fPage.clickDownloadBtn();
        Assert.assertTrue(fPage.verifyDownloadedFile(), "File is not downloaded");
        fPage.deleteFile();
    }
}
