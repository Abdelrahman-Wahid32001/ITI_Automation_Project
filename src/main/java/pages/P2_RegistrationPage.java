package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.dataReader.PropertiesUtils;
import utils.report.LogsUtils;
import utils.validation.CustomSoftAssertion;

import static utils.actions.ElementsActions.Click;
import static utils.actions.ElementsActions.SetText;

public class P2_RegistrationPage {
    private final WebDriver driver;

    public P2_RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By email = By.id("email_address");
    private final By password = By.id("password");
    private final By confirmPassword = By.id("confirmation");
    private final By registerBtn = By.cssSelector("button[title='Register']");
    private final By registrationAccountMSG = By.xpath("//*[@id='main-content']/div/ul/li/ul/li");
    private final By invalidEmailMSG = By.id("advice-validate-email-email_address");
    private final By invalidNameMSG = By.id("advice-required-entry-firstname");
    private final By invalidPassMSG = By.id("advice-required-entry-password");


    public P2_RegistrationPage userRegistration(String fname, String lname, String emailText, String pass) {
        SetText(driver, firstName, fname);
        SetText(driver, lastName, lname);
        SetText(driver, password, pass);
        SetText(driver, confirmPassword, pass);
        SetText(driver, email, emailText);
        return this;
    }

    public P2_RegistrationPage submitRegistration() {
        Click(driver, registerBtn);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public P2_RegistrationPage assertURL() {
        CustomSoftAssertion.SoftAssertion.assertEquals(driver.getCurrentUrl(), PropertiesUtils.getPropertyValue("RegisterURL"));
        return this;
    }

    public P2_RegistrationPage assertMSG(String errorMSG) {
        CustomSoftAssertion.SoftAssertion.assertTrue(driver.getPageSource().contains(errorMSG));
        LogsUtils.debug("MSG : " + driver.getPageSource().contains(errorMSG));
        return this;
    }


}