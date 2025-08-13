package utils.actions;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.report.LogsUtils;

public class BrowserActions {
    private BrowserActions(){}
    public static void navigateToURL(WebDriver driver , String url){
        driver.get(url);
        LogsUtils.info("Navigate to URL:", url);
    }
    public static String currentURL(WebDriver driver){
        LogsUtils.info("Current URL:",driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }
    public static String getPageTitle(WebDriver driver){
        LogsUtils.info("Page title:",driver.getTitle());
        return driver.getTitle();

    }
    public static WebDriver refreshDreiver(){
        return DriverManager.getDriver();
    }

    public static void clossBrowser(WebDriver driver){
        if (driver != null) {
            driver.quit();
            LogsUtils.info("Driver down");
        }
    }
}
