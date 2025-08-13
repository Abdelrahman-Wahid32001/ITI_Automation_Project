package utils.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.report.LogsUtils;

import static utils.report.AllureSteps.logScrollToElement;
import static utils.actions.ElementsActions.findElement;

public class Scrolling {
     private Scrolling(){
     }
    public static void scrollToElement(WebDriver driver, By locator){
    logScrollToElement(locator);
        LogsUtils.info("Scrolling to the element: ", locator.toString());
         ((JavascriptExecutor) driver).executeScript(
                "var element = arguments[0];" +
                        "var rect = element.getBoundingClientRect();" +
                        "window.scrollBy(0, rect.top + window.pageYOffset - (window.innerHeight / 2));",
                findElement(driver, locator)
        );
    }

}
