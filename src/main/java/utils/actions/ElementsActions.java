package utils.actions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.report.LogsUtils;

import java.util.List;

import static utils.report.AllureSteps.*;

public class ElementsActions {

    public static void SetText(WebDriver driver, By locator, String data) {
        Waits.waitForElementVisible(driver, locator);
        WebElement el = findElement(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        //el.click();
        el.clear();
        el.sendKeys(data);
        LogsUtils.info("Data entered: " + data + "' into " + locator.toString());
    }

    public static void Click(WebDriver driver, By locator) {
        logClick(locator);
        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).click();
        LogsUtils.info("Clicking on element: ", locator.toString());

    }

    public static void hoverAndClick(WebDriver driver, By locator, By locator1) {
        logHoverAndClick(locator, locator1);
        Waits.waitForElementVisible(driver, locator);
        //Scrolling.scrollToElement(driver, locator);
        new Actions(driver).moveToElement(findElement(driver, locator)).perform();
        LogsUtils.info("Hover on element: " + locator.toString());
        findElement(driver, locator1).click();
        LogsUtils.info("Hover and click on element: " + locator1.toString());
    }

    public static void Select(WebDriver driver, By locator, Integer index) {
        logSelect(locator, index);
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        new Select(findElement(driver, locator)).selectByIndex(index);
        LogsUtils.info("Select the item with index : ", index.toString());
    }

    public static String getText(WebDriver driver, By locator) {
        logGetText(locator);
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        LogsUtils.info("Getting the text from the " + locator+ " Text: " + findElement(driver, locator).getText());
        return findElement(driver, locator).getText();
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        logFindElement(locator);
        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            try {
                return driver.findElement(locator);
            } catch (StaleElementReferenceException e) {
                attempts++;
               LogsUtils.warn("🔁 Trying " + attempts + "  StaleElementReferenceException");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        throw new RuntimeException("disable to find the element " + maxAttempts + "  StaleElementReferenceException: " + locator);
    }

    @Step("Confirm the alert")
    public static void confirmAlert(WebDriver driver) {
        Waits.waitAlertToBePresent(driver);
        driver.switchTo().alert().accept();
    }

    @Step("Decline the alert")
    public static void declineAlert(WebDriver driver) {
        Waits.waitAlertToBePresent(driver);
        driver.switchTo().alert().dismiss();
    }

    public static void getProductFromList(WebDriver driver, By locator, int index) {
       // logGetProductFromList( locator,  index);
        try {
            Waits.waitForElementVisible(driver, locator); // وقت انتظار قصير
            List<WebElement> list = driver.findElements(locator);
            Waits.waitForElementClickable(driver, locator); // وقت انتظار قصير
            if (!list.isEmpty()) {
                list.get(index)
                        .click();
                LogsUtils.info("Clicked on the " + index + " into suggestion product: " + list.get(index).getText());
            } else {
                LogsUtils.warn("No suggestions appeared.");
            }
        } catch (Exception e) {
            //LogsUtils.error("No Elements");
        }
    }

}













