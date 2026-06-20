package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            System.getProperty("user.dir")
                                    + "/Reports/ExtentReport.html");

            sparkReporter.config().setDocumentTitle(
                    "PetStore Automation Report");

            sparkReporter.config().setReportName(
                    "PetStore End-to-End Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo(
                    "Project",
                    "PetStore Automation Framework");

            extent.setSystemInfo(
                    "Tester",
                    "Diya B");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG + Maven");

            extent.setSystemInfo(
                    "Environment",
                    "QA");

            extent.setSystemInfo(
                    "Browser",
                    "Chrome");
        }

        return extent;
    }
}