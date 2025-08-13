package tests.testcases;

import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utils.helper.PropertiesUtils;

public class TestSearchFeature extends TestBase {

    @Test
    public void testSearchFeature() {
        new P0_HomePage(driver).navigateToPage();
             new P5_SearchPage(driver).setSearchBArTxt(PropertiesUtils.getPropertyValue("ProductName"))
                .openDetailsProductPage()
                .setChelseaTeeWhite()
                .proceedToCheckout()
                .getCheckoutPage();

    }
    @Test
    public void testSuggestionSearch() {
        new P0_HomePage(driver).navigateToPage();
        new P5_SearchPage(driver).setProductFromSuggestionSearch("swi");
        new P7_ProductsPage(driver).setAddToCart();

    }

    @Test
    public void testSearchFeatureWithInvalidName() {
        new P0_HomePage(driver)
                .navigateToPage();
        new P5_SearchPage(driver)
                .setSearchBArTxt(PropertiesUtils.getPropertyValue("InvalidProductName"))
                .openDetailsProductPage();
    }

}
