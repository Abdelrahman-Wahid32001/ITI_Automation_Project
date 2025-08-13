package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.actions.ElementsActions.Click;
import static utils.actions.ElementsActions.Select;


public class P6_SubCategoryPage {
    private final WebDriver driver;

    public P6_SubCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By shirtsPriceFilter = By.xpath("//*[@id='narrow-by-list']/dd[1]/ol/li[3]/a/span");
    private final By shirtsColorWhite = By.xpath("//*[@id='narrow-by-list']/dd[2]/ol/li[6]/a/img");
    private final By manShirtsFrench = By.cssSelector("a[title='French Cuff Cotton Twill Oxford']");
    private final By sortByList = By.id("toolbar-sortby");
    private final By parkRowThrow = By.id("product-collection-image-384");
    private final By gramercyThrow = By.id("product-collection-image-385");



    public P7_ProductsPage getFrenchCuffItemPage() {
        Click(driver, manShirtsFrench);
        return new P7_ProductsPage(driver);

    }

    public P7_ProductsPage getParkRowThrowPage() {
        Click(driver, parkRowThrow);
        return new P7_ProductsPage(driver);

    }
    public P7_ProductsPage getGramercyThrowPage() {
        Click(driver, gramercyThrow);
        return new P7_ProductsPage(driver);

    }


    public P6_SubCategoryPage filterByPrice() {
        Click(driver, shirtsPriceFilter);
        return this;
    }

    public P6_SubCategoryPage filterByColor() {
        Click(driver, shirtsColorWhite);
        return this;
    }

    public P6_SubCategoryPage sortByPrice() {
        Select(driver, sortByList, 2);
        return this;
    }

    public P6_SubCategoryPage sortByName() {
        Select(driver, sortByList, 1);
        return this;
    }


}
