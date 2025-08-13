package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.actions.BrowserActions;
import utils.validation.CustomSoftAssertion;
import utils.actions.ElementsActions;
import utils.helper.PropertiesUtils;


import static utils.actions.ElementsActions.*;

public class P1_AccountPage  {
    private  final WebDriver driver;
    public P1_AccountPage(WebDriver driver){
        this.driver = driver;
    }

    private final By loginEmailBxt = By.id("email");
    private final By loginPasswordBox = By.id("pass");
    private final By loginBtn = By.id("send2");
    private final By ConfirmLoginBtn = By.linkText("Click here");
    private final By SendConfirmationLoginBtn = By.cssSelector("button[title='Submit']");
    private final By infoMessageLoginConfirmed = By.cssSelector("ul.messages");
    private final By forgotPasswordBtn = By.cssSelector("a.f-left");
    private final By createAccountLink = By.xpath ("//a[@title='Create an Account']") ;
    private final By messageAfterLogin = By.xpath("//*[@id=\"main-content\"]/div/ul/li/ul/li");

@Step("Enter Eamil and password:{0},{1}")
    public P1_AccountPage setLoginFields(String Email , String pass){
        SetText(driver,loginEmailBxt,Email);
        SetText(driver,loginPasswordBox,pass);
        return this;
    }

    public P1_AccountPage clickOnSubmit(){
        Click(driver, loginBtn);
        return this;
    }
    public P1_AccountPage getConfirmationLoginEmail(){
        Click(driver,ConfirmLoginBtn);
        return this;
    }

    public P1_AccountPage setConfirmationLoginEmail(){
        Click(driver,SendConfirmationLoginBtn);
        return this;
    }

    public P3_ForgetPasswordPage goForgotPasswordPage(){
        Click(driver,forgotPasswordBtn);
        return new P3_ForgetPasswordPage(driver);
    }
    public P2_RegistrationPage createNewAccount(){
        Click(driver,createAccountLink);
        return new P2_RegistrationPage(driver);
}

    public String successfulLoginMssg(){
    return ElementsActions.getText(driver,messageAfterLogin);
    }

    //Validation

    public P1_AccountPage assertTitle(){
        CustomSoftAssertion.SoftAssertion.assertEquals(BrowserActions.getPageTitle(driver), "Customer Login" );
        return this;

    }
    public P1_AccountPage assertURL(){
        CustomSoftAssertion.SoftAssertion.assertEquals(BrowserActions.currentURL(driver), PropertiesUtils.getPropertyValue("LoginURL") );
        return this;
        }

    public P1_AccountPage asserSuccessLoginMessage(){
        CustomSoftAssertion.SoftAssertion.assertEquals(successfulLoginMssg(), "This account is not confirmed. Click here to resend confirmation email." );
        return this;
    }
    public P1_AccountPage asserUnsuccessLoginMessage(){
        CustomSoftAssertion.SoftAssertion.assertEquals(successfulLoginMssg(), "Invalid login or password." );
        return this;
    }



}

