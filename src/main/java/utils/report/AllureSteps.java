package utils.report;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AllureSteps {
    @Step("Hover on element: {0} and click on: {1}")
    public static void logHoverAndClick(By locator, By locator1) {
    }
    @Step("Clicking on element : {locator}")
    public static void logClick( By locator) {}

    @Step("Selecting From list :{locator} the element of index :{index}")
    public static void logSelect( By locator, Integer index) {}

    @Step("Get the text from element  :{locator}")
    public static void logGetText( By locator) {}

    @Step("Finding element : {locator}")
    public static void logFindElement( By locator) {}

    @Step("Get Product with {index} from : {locator}")
    public static void logGetProductFromList(By locator, int index) {}

    @Step("Scrolling to the element:{0}")
    public static void logScrollToElement( By locator){}

}
