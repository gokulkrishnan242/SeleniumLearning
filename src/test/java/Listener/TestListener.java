package Listener;

import UITests.BaseTest;
import Utils.ExtentReportManager;
import Utils.ExtentTestManager;
import Utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.creatReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentReportManager
                .creatReport()
                .createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        BaseTest baseTest = (BaseTest) result.getInstance();
        WebDriver driver = baseTest.getDriver();
        test.pass("Test Passed " + result.getMethod().getMethodName());
        String path = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        if (path != null && new File(path).exists()) {
            Path reportDirectory = Paths.get(
                    "src/test/resources/reports"
            ).toAbsolutePath();
            Path screenshotPath = Paths.get(path).toAbsolutePath();
            String relativePath = reportDirectory
                    .relativize(screenshotPath)
                    .toString()
                    .replace("\\", "/");
            test.pass(
                    "Test Passed ",
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(relativePath)
                            .build()
            );
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        BaseTest baseTest = (BaseTest) result.getInstance();
        WebDriver driver = baseTest.getDriver();
        test.fail("Test Failed " + result.getMethod().getMethodName());
        String path = ScreenshotUtil.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );
        if (path != null && new File(path).exists()) {
            Path reportDirectory = Paths.get(
                    "src/test/resources/reports"
            ).toAbsolutePath();
            Path screenshotPath = Paths.get(path).toAbsolutePath();
            String relativePath = reportDirectory
                    .relativize(screenshotPath)
                    .toString()
                    .replace("\\", "/");
            test.fail(
                    result.getThrowable(),
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(relativePath)
                            .build()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.skip(result.getThrowable());
            test.info("Test Skipped");
            ExtentTestManager.unload();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }
}
