package tests.happy_scenario;

import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;

public class E2eTests extends TestBase {

    @Test
    public void E2EUsingSearch() {
        new P0_HomePage(driver)
                .navigateToPage();
        new P5_SearchPage(driver)
                .setSearchBArTxt(item.ChelseaTee.name)
                .openDetailsProductPage()
                .setChelseaTeeWhite()
                .modifyNumberOfProduct(item.numberOfProduct.get(0))
                .submitToUpdateNumberOfProduct()
                .assertPrice(item.numberOfProduct.get(0), item.ChelseaTee.price)
                .assertURL();
        new P0_HomePage(driver)
                .navigateToPage();
        new P5_SearchPage(driver)
                .setProductFromSuggestionSearch(item.SuggestProduct.get(0))
                .selectProduct(0)
                .setAddToCart()
                .proceedToCheckout()
                .assertURL()
                .getCheckoutPage()
                .assertURL()
                .fillBillingInformationFields
                        (data.getFname(), data.getLname(), data.getEmail()
                                , data.getAddress(), data.getCity()
                                , data.getZip(), data.getPhoneNo())
                .selectTheAddressType()
                .submitTheInformation()
                .finishCheckout();
    }

    @Test
    public void E2eGetProductFromCategories() {
        new P0_HomePage(driver)
                .navigateToPage()
                .assertTitle()
                .assertURL()
                .selectFromCategoryMan()
                .filterByColor()
                .getFrenchCuffItemPage()
                .setFrenchCuff()
                .modifyNumberOfProduct(item.numberOfProduct.get(2))
                .submitToUpdateNumberOfProduct()
                .assertTheMaxOfQuantity(MSG.aboveMaxOfCount)
                .assertPrice(item.numberOfProduct.get(2), item.FrenchCuff.price)
                .removeFirstItem()
                .assertProductRemoved(item.FrenchCuff.name);
        new P0_HomePage(driver)
                .backToHomeByLogo()
                .selectFromCategoryHome_Decor()
                .sortByPrice()
                .sortByName()
                .getGramercyThrowPage()
                .setAddToCart()
                .assertURL()
                .assertPrice(item.numberOfProduct.get(0), item.ParkRowThrow.price)
                .proceedToCheckout()
                .assertURL()
                .getCheckoutPage()
                .fillBillingInformationFields
                        (user.Fname, user.Lname
                                , user.Email.get(1)
                                , user.Address, user.City
                                , user.Zip, user.PhoneNo)
                .selectTheAddressType()
                .submitTheInformation()
                .finishCheckout();
    }

    @Test
    public void E2eGetProductFromHome() {
        new P0_HomePage(driver)
                .navigateToPage()
                .assertTitle()
                .assertURL()
                .openCart()
                .assertCartOpen(MSG.cartPageISOpened)
                .assertCartEmpty(MSG.cartPageISEmpty)
                .closeCartFeature(P0_HomePage.class)
                .assertAll()
                .selectProductItem()
                .setLinenBlazer();
        new P5_SearchPage(driver)
                .setProductFromSuggestionSearch(item.SuggestProduct.get(1))
                .selectProduct(2)
                .setAddToCart()
                .navigateToHmePage()
                .openCart()
                .editItemOnCart()
                .removeItemFromCart()
                .openShoppingCartPage()
                .modifyNumberOfProduct(item.numberOfProduct.get(1))
                .proceedToCheckout()
                .assertURL()
                .getCheckoutPage()
                .fillBillingInformationFields
                        (user.Fname, user.Lname
                                , user.Email.get(1)
                                , user.Address, user.City
                                , user.Zip, user.PhoneNo)
                .selectTheAddressType()
                .submitTheInformation()
                .finishCheckout();

    }
}

