package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.dataReader.PropertiesUtils;
import utils.validation.CustomSoftAssertion;

import static utils.actions.ElementsActions.Click;

public class P9_CheckOutMethodPage {
    private final WebDriver driver;

    public P9_CheckOutMethodPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutAsGuest = By.id("login:guest");
    private final By checkoutAsRegister = By.id("login:register");
    private final By continuoBtn = By.id("onepage-guest-register-button");

    public P10_BillingInformation getCheckoutPage() {
        Click(driver, checkoutAsGuest);
        Click(driver, continuoBtn);
        return new P10_BillingInformation(driver);
    }

    public P10_BillingInformation getCheckoutPage(String AsRegister) {
        Click(driver, checkoutAsRegister);
        Click(driver, continuoBtn);
        return new P10_BillingInformation(driver);
    }

    public P9_CheckOutMethodPage assertURL() {
        CustomSoftAssertion.SoftAssertion.assertEquals(driver.getCurrentUrl(), PropertiesUtils.getPropertyValue("CheckoutURL"));
        return this;
    }

}
