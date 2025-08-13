package drivers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.report.LogsUtils;
import utils.helper.PropertiesUtils;

import static org.testng.Assert.fail;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    @Step("create driver instance on")
    public static WebDriver createInstance() {
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        LogsUtils.info("Driver created on: ", browserName);
        setDriver(driver);
        return getDriver();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LogsUtils.info("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }
}

