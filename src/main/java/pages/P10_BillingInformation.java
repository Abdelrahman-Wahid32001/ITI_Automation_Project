package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.dataReader.PropertiesUtils;
import utils.validation.CustomSoftAssertion;

import static utils.actions.ElementsActions.*;

public class P10_BillingInformation {
    private final WebDriver driver;

    public P10_BillingInformation(WebDriver driver) {
        this.driver = driver;

    }

    private final By firstName = By.id("billing:firstname");
    private final By lastName = By.id("billing:lastname");
    private final By email = By.id("billing:email");
    private final By address = By.id("billing:street1");
    private final By city = By.id("billing:city");
    private final By stateDropList = By.id("billing:region_id");
    private final By postalCode = By.id("billing:postcode");
    private final By countryDroplist = By.id("billing:country_id");
    private final By telephone = By.id("billing:telephone");
    private final By password = By.id("billing:customer_password");
    private final By confirmPassword = By.id("billing:confirm_password");
    private final By addressTypeBtn = By.id("billing:use_for_shipping_yes");
    private final By continueBtn = By.xpath("//*[@id=\"billing-buttons-container\"]/button");


    @Step("Enter : {information) ")
    public P10_BillingInformation fillBillingInformationFields(String fname, String lname, String Email, String Address, String City, String ZIP, String telephoneNo) {

        SetText(driver, firstName, fname);
        SetText(driver, lastName, lname);
        SetText(driver, email, Email);
        SetText(driver, address, Address);
        SetText(driver, city, City);
        SetText(driver, postalCode, ZIP);
        SetText(driver, telephone, telephoneNo);
        Select(driver, stateDropList, 5);
        Select(driver, countryDroplist, 231);
        return this;


    }

    public P10_BillingInformation selectTheAddressType() {
        Click(driver, addressTypeBtn);
        return this;
    }

    public P11_CheckOutPage submitTheInformation() {
        Click(driver, continueBtn);
        return new P11_CheckOutPage(driver);
    }

    public P10_BillingInformation assertURL() {
        CustomSoftAssertion.SoftAssertion.assertEquals(driver.getCurrentUrl(), PropertiesUtils.getPropertyValue("CheckoutURL"));
        return this;
    }


}
