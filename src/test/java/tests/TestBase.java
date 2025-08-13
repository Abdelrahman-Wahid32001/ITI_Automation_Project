package tests;

import drivers.DriverManager;
import io.qameta.allure.Step;
import listeners.TestNGListeners;
import model.ProductData;
import model.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.actions.BrowserActions;
import utils.dataReader.JsonUtils;
import utils.dataReader.Properties_Data;
import utils.validation.CustomSoftAssertion;

@Listeners(TestNGListeners.class)
public class TestBase {
    protected WebDriver driver;
    public Properties_Data data = new Properties_Data();
    String path_1 = "src/test/resources/Information.json";
    String path_2 = "src/test/resources/ProductName.json";
    String path_3 = "src/test/resources/MSG.json";
    public UserData user = JsonUtils.readJsonAsObject(path_1, UserData.class);
    public ProductData item = JsonUtils.readJsonAsObject(path_2, ProductData.class);
    public ProductData MSG = JsonUtils.readJsonAsObject(path_3, ProductData.class);


    @BeforeMethod
    @Step("Setup the environment")
    public void setUp() {
        DriverManager.createInstance();
        driver = DriverManager.getDriver();
    }


@AfterMethod
@Step("shut down the environment")
public void tearDown() {
    BrowserActions.clossBrowser(DriverManager.getDriver());
    CustomSoftAssertion.AssertAll();
}
}

