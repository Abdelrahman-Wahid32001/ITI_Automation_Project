package utils.helper;


import drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.report.AllureUtils;
import utils.report.LogsUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotsUtils {
    public static final String SCREENSHOTS_PATH = "test-outputs/ScreenShots/";
    private ScreenShotsUtils(){
        super();
    }
    public static void takeScreenShot(String screenshotName){

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + "_" +screenshotName + timeStamp +"_" + ".png");
            FileUtils.copyFile(screenshot,screenshotFile);
            AllureUtils.attachScreenshotsToAllure(screenshotName,screenshotFile.getPath());
        } catch (Exception e) {
            LogsUtils.error("failed to take screenshot:"+e.getMessage());
        }
    }

}

