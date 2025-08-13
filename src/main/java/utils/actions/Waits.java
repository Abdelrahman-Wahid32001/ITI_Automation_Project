package utils.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.report.LogsUtils;

import java.time.Duration;

public class Waits {

    public static WebElement waitForElementPresent(WebDriver driver, By locator){
        LogsUtils.info("Waiting the element to be present " + locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 -> driver1.findElement(locator));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator){
        LogsUtils.info("Waiting the element to be visible " + locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                    {
                        WebElement element = waitForElementPresent( driver,locator);
                        return element.isDisplayed() ? element : null ;
                    }
                );
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator){
        LogsUtils.info("Waiting the element to be clickable " + locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                        {
                            WebElement element = waitForElementVisible( driver,locator);
                            return element.isEnabled() ? element : null ;
                        }
                );
    }
    public  static void  waitAlertToBePresent(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(driver1 -> {
            try {
                return driver1.switchTo().alert();
            } catch (NoAlertPresentException e) {
                LogsUtils.error("There is no alert to display");
                return null;
            }
        });
    }


}
