package utils;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String stepName) {

        String timestamp =

                new SimpleDateFormat("yyyyMMdd_HHmmss")

                        .format(new Date());

        String screenshotPath =

                System.getProperty("user.dir")

                        + "/Screenshots/"

                        + stepName

                        + "_"

                        + timestamp

                        + ".png";

        File srcFile =

                ((TakesScreenshot) driver)

                        .getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(

                    srcFile,

                    new File(screenshotPath));

            System.out.println(

                    "Screenshot Saved : "

                            + screenshotPath);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return screenshotPath;

    }

}
