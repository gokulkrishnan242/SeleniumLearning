package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {


    private static ExtentReports extent;

    //Method to create report
    public static ExtentReports creatReport() {
        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "src/test/resources/reports/ExtentReport.html"
                    );
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static void flushReport() {
        extent.flush();
    }
}
