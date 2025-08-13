package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.actions.ElementsActions.*;

public class P5_SearchPage  {

    private  final WebDriver driver;
    public P5_SearchPage (WebDriver driver){
        this.driver = driver;
    }

    private final By SearchBox = By.id("search");
    private final By SearchBtn = By.cssSelector("button.button.search-button");
    private final By suggestionItem = By.cssSelector("#products-list > li");
    private final By chelseaTeeWhiteBtn = By.id("product-collection-image-409");


    //Action


    @Step("enter all product name  in search box : {productName}")
    public P5_SearchPage setSearchBArTxt(String productName) {
        SetText(driver, SearchBox, productName);
        Click(driver, SearchBtn);
        return this;
    }

    @Step("Open product details page ")
    public P7_ProductsPage openDetailsProductPage() {
        Click(driver, chelseaTeeWhiteBtn);
        return new P7_ProductsPage(driver);
    }

    @Step("Writing letter of product name on search box  : {text}")
    public P5_SearchPage setProductFromSuggestionSearch(String text) {
        SetText(driver, SearchBox, text);
        return this;

    }
    @Step("Select item fom suggestion search : {index}")
    public P7_ProductsPage selectProduct( int index){
        getProductFromList(driver, suggestionItem,index);
        return new P7_ProductsPage(driver);
    }

}