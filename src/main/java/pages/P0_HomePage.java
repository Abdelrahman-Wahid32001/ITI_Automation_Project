package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.actions.BrowserActions;
import utils.dataReader.PropertiesUtils;
import utils.validation.CustomSoftAssertion;

import static utils.actions.ElementsActions.Click;
import static utils.actions.ElementsActions.hoverAndClick;
import static utils.dataReader.PropertiesUtils.getPropertyValue;

public class P0_HomePage {
    private final WebDriver driver;

    public P0_HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private final By accountButton = By.xpath("//*[@id=\"header\"]/div[1]/div[2]/a[1]/span");
    private final By contactUs = By.xpath("/html/body/div/div/footer/div/div[2]/ul/li[2]/a");
    private final By linenBlazerProduct = By.cssSelector("a[title='Linen Blazer']");
    private final By manCategory = By.xpath("//*[@id=\"nav\"]/ol/li[2]/a");
    private final By shirtsOnManCategoryBtn = By.xpath("//*[@id=\"nav\"]/ol/li[2]/ul/li[3]/a");
    private final By goToHomeByLogo = By.cssSelector("a.logo");
    private final By Bed_DecorCategory = By.xpath("//*[@id=\"nav\"]/ol/li[4]");
    private final By bedOnBed_DecorCategory = By.xpath("//*[@id=\"nav\"]/ol/li[4]/ul/li[3]/a");
    private final By cart = By.xpath("//*[@id='header']/div[1]/div[2]/div[2]/a/span[1]");



    public P0_HomePage navigateToPage() {
        BrowserActions.navigateToURL(driver, getPropertyValue("homeURL"));
        return this;
    }
    public P0_HomePage backToHomeByLogo() {
        Click(driver, goToHomeByLogo);
        return this;
    }
    public P1_AccountPage openAccountPage() {
        Click(driver, accountButton);
        return new P1_AccountPage(driver);
    }
    public P4_ContactUsPage openContactUsPage() {
        Click(driver, contactUs);
        return new P4_ContactUsPage(driver);
    }
    public P7_ProductsPage selectProductItem() {
        Click(driver, linenBlazerProduct);
        return new P7_ProductsPage(driver);
    }

    public P6_SubCategoryPage selectFromCategoryMan() {
        hoverAndClick(driver, manCategory, shirtsOnManCategoryBtn);
        return new P6_SubCategoryPage(driver);
    }

    public P6_SubCategoryPage selectFromCategoryHome_Decor() {
        hoverAndClick(driver, Bed_DecorCategory, bedOnBed_DecorCategory);
        return new P6_SubCategoryPage(driver);
    }

    public P12_CartPage openCart() {
        Click(driver, cart);
        return new P12_CartPage(driver);
    }


    public P0_HomePage assertTitle() {
        CustomSoftAssertion.SoftAssertion
                .assertEquals(BrowserActions
                .getPageTitle(driver)
                , PropertiesUtils
                .getPropertyValue("homeTitle"));
        return this;}
    public P0_HomePage assertURL() {
        CustomSoftAssertion.SoftAssertion.assertEquals(BrowserActions.currentURL(driver), PropertiesUtils.getPropertyValue("homeURL"));
        return this;}
    public P0_HomePage assertAll() {
        assertTitle().assertURL();return this;}


}