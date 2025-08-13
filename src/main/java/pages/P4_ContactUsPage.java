package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.helper.PropertiesUtils;

import static utils.actions.ElementsActions.Click;
import static utils.actions.ElementsActions.SetText;
import static utils.validation.CustomSoftAssertion.SoftAssertion;

public class P4_ContactUsPage {
    private final WebDriver driver;

    public P4_ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By Name = By.id("name");
    private final By Email = By.id("email");
    private final By phone = By.id("telephone");
    private final By message = By.id("comment");
    public final By submitBtn = By.cssSelector("button[title='Submit']");

    private final By infoMessageContactUsPage = By.id("messages_product_view");
    private final By errorMessageContactUsPage = By.id("advice-required-entry-comment");

    public P4_ContactUsPage fullContactUsFields(String name, String email, String masg) {
        SetText(driver, Name, name);
        SetText(driver, Email, email);
        SetText(driver, message, masg);

        return this;
    }

    public void clickToSubmitMessage() {
        Click(driver, submitBtn);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Validation

    public P4_ContactUsPage assertContactUsURL() {
        SoftAssertion.assertEquals(driver.getCurrentUrl(), PropertiesUtils.getPropertyValue("ContactUs"), "URL is not expected");
        return this;
    }

    public void assertContactUsTitle() {
        SoftAssertion.assertEquals(driver.getTitle(), "contacts", "Title is not expected");
    }

    public P4_ContactUsPage allAssertContactUs() {
        assertContactUsURL().assertContactUsTitle();
        return this;
    }


}
