package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.validation.CustomSoftAssertion;

import static utils.actions.ElementsActions.Click;
import static utils.actions.ElementsActions.SetText;

public class P7_ProductsPage {
    private final By chelseaTeeWhite = By.id("product-collection-image-409");
    private final By LinenBlazer = By.cssSelector("img[alt='Linen Blazer']");
    private final By sizeM = By.id("option79");
    private final By sizeXS = By.id("option81");
    private final By sizeXL = By.id("swatch77");
    private final By colorWhite = By.id("swatch22");
    private final By colorBlack = By.id("swatch20");
    private final By addToCartBtn = By.cssSelector("button[title='Add to Cart']");
    private final By editItemNo = By.cssSelector("input[title='Qty']");


    private final WebDriver driver;

    public P7_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public P8_ShoppingCartPage setChelseaTeeWhite() {
        Click(driver, colorBlack);
        Click(driver, sizeM);
        Click(driver, addToCartBtn);
        return new P8_ShoppingCartPage(driver);
    }

    public P8_ShoppingCartPage setLinenBlazer() {
        Click(driver, sizeXL);
        Click(driver, colorWhite);
        Click(driver, addToCartBtn);
        return new P8_ShoppingCartPage(driver);
    }

    public P8_ShoppingCartPage setFrenchCuff() {
        Click(driver, sizeXS);
        Click(driver, colorWhite);
        Click(driver, addToCartBtn);
        return new P8_ShoppingCartPage(driver);
    }

    public P8_ShoppingCartPage setAddToCart() {
        Click(driver, addToCartBtn);
        return new P8_ShoppingCartPage(driver);
    }

    public P7_ProductsPage editProductNO(String No) {
        SetText(driver, editItemNo, No);
        Click(driver, editItemNo);

        return this;
    }

    public P7_ProductsPage assertButtonAvailable() {
        CustomSoftAssertion.SoftAssertion.assertTrue(driver.getPageSource().contains("Update"), "Update Button is not available");
        return this;
    }


}