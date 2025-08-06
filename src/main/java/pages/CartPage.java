package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomSoftAssertion;
import utils.ElementsActions;

import static utils.ElementsActions.*;

public class CartPage {

    private final WebDriver driver;
    private final By cart = By.xpath("//*[@id='header']/div[1]/div[2]/div[2]/a/span[1]");
    private final By cartRemove = By.cssSelector("a.remove");
    private final By cartEdit = By.cssSelector("a.btn-edit");
    private final By cartDetails = By.cssSelector("a.details");
    private final By cartQuantityBox = By.cssSelector("input.qty");
    private final By shoppingCartLink = By.cssSelector("a.cart-link");
    private final By OkBtn = By.id("qbutton-401");
    private final By XBtn = By.cssSelector("button.offcanvas-close");

    public CartPage (WebDriver driver) {
        this.driver = driver;
    }


    // Cart Action
    public CartPage openCart() {
        Click(driver, cart);
        return this;
    }

    public CartPage removeItemFromCart() {
        Click(driver, cartRemove);
        confirmAlert(driver);
        return this;
    }
    public CartPage editItemOnCart() {
        SetText(driver, cartQuantityBox, "3");
        Click(driver, cartQuantityBox);
        return this;
    }
    public <T> T closeCartFeature(Class<T> returnPage) {
        Click(driver, XBtn);
        try {
            return returnPage.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to return to page: " + returnPage.getSimpleName(), e);
        }
    }

    public P8_ShoppingCartPage openShoppingCartPage() {
        Click(driver, shoppingCartLink);
        return new P8_ShoppingCartPage(driver);
    }
    public CartPage assertCartOpen(String message){
        CustomSoftAssertion.SoftAssertion.assertEquals(ElementsActions.getText(driver,By.cssSelector("div.offcanvas-title")),message);
        return this;
    }
    public CartPage assertCartEmpty(String message){
        CustomSoftAssertion.SoftAssertion.assertEquals(ElementsActions.getText(driver,By.cssSelector("p.empty")), message);
        return this;
    }
}
