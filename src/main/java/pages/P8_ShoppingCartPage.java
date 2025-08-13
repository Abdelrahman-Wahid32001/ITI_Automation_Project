package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.actions.BrowserActions;
import utils.actions.ElementsActions;
import utils.report.LogsUtils;
import utils.validation.CustomSoftAssertion;

import java.text.DecimalFormat;

import static utils.actions.ElementsActions.Click;
import static utils.actions.ElementsActions.SetText;
import static utils.helper.PropertiesUtils.getPropertyValue;

public class P8_ShoppingCartPage {
    private final WebDriver driver;

    public P8_ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By proceedToCheckoutBtn = By.xpath("//*[@id='main-content']/div/div[1]/ul/li/button");
    private final By discountCodesBox = By.id("coupon_code");
    private final By applyDiscountBtn = By.cssSelector("button.button2");
    private final By ProductQtyBox = By.cssSelector("input[title='Qty']");
    private final By ProductUpdateBtn = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button");
    private final By removeItemX = By.cssSelector("a[title='Remove Item']");
    private final By errorMessage = By.cssSelector("li.error-msg");
    private final By totalPrice = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[5]/span/span");


    public P8_ShoppingCartPage modifyNumberOfProduct(String num) {
        SetText(driver, ProductQtyBox, num);
        Click(driver, ProductQtyBox);
        return this;
    }

    public P8_ShoppingCartPage submitToUpdateNumberOfProduct() {
        Click(driver, ProductUpdateBtn);
        return this;
    }


    public P8_ShoppingCartPage removeFirstItem() {
        Click(driver, removeItemX);
        return this;
    }

    public P8_ShoppingCartPage addDiscountCode(String code) {
        SetText(driver, discountCodesBox, code);
        Click(driver, applyDiscountBtn);
        return this;
    }

    public P9_CheckOutMethodPage proceedToCheckout() {
        Click(driver, proceedToCheckoutBtn);
        return new P9_CheckOutMethodPage(driver);
    }


    public P8_ShoppingCartPage assertProductRemoved(String productName) {
        String pageSource = driver.getPageSource();
        CustomSoftAssertion.SoftAssertion.assertFalse(
                pageSource.contains(productName),
                "This product is not exist" + productName
        );
        return this;
    }

    public P8_ShoppingCartPage assertURL() {
        CustomSoftAssertion.SoftAssertion.assertTrue(driver.getCurrentUrl().contains("checkout/cart"), "wrong URl");
        return this;
    }

    public P8_ShoppingCartPage assertTheMaxOfQuantity(String errorMSG) {
        CustomSoftAssertion.SoftAssertion.assertTrue(ElementsActions.getText(driver, errorMessage).contains(errorMSG));
        return this;
    }

    public P0_HomePage navigateToHmePage() {
        BrowserActions.navigateToURL(driver, getPropertyValue("homeURL"));
        return new P0_HomePage(driver);
    }

    private String getTotalPriceForEachProduct(String quantity, String price) {
        int validQty = Integer.parseInt(quantity);
        double unitPrice = Double.parseDouble(price.replace("$", "").trim());
        double expectedTotal = validQty * unitPrice;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return formatter.format(expectedTotal);
    }

    public P8_ShoppingCartPage assertPrice(String quantity, String price) {
        String actualPrice = ElementsActions.getText(driver, totalPrice).replace("$", "").trim();
        String expectedPrice = getTotalPriceForEachProduct(quantity, price);

        CustomSoftAssertion.SoftAssertion.assertEquals(
                actualPrice, expectedPrice, "The expected price :" + expectedPrice + "is not as actual" + actualPrice);
        LogsUtils.info("The expected price :" + expectedPrice + "is not as actual" + actualPrice);
        return this;
    }


}
