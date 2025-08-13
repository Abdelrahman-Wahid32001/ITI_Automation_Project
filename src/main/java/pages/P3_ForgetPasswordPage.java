package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.actions.ElementsActions.Click;
import static utils.actions.ElementsActions.SetText;

public class P3_ForgetPasswordPage {

    private final WebDriver driver;

    public P3_ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By forgotPassEmailTxt = By.id("email_address");
    private final By submitForgotPasswordBtn = By.cssSelector("button[title='Submit']");

    public P3_ForgetPasswordPage setForgotPasswordField(String Email) {

        SetText(driver, forgotPassEmailTxt, Email);
        Click(driver, submitForgotPasswordBtn);
        return this;
    }
}
