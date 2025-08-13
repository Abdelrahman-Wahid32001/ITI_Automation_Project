package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.actions.ElementsActions.Click;

public class P11_CheckOutPage {
    private  final WebDriver driver;
    public P11_CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    private final By continuoToPaymentPageBtn = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    private final By continuoToOrderReviewPageBtn = By.xpath("//*[@id=\"payment-buttons-container\"]/button");
    private final By submittingOrderBtn = By.xpath("//*[@id=\"review-buttons-container\"]/button");


    public void finishCheckout() {

        Click(driver, continuoToPaymentPageBtn);
        Click(driver, continuoToOrderReviewPageBtn);
        Click(driver, submittingOrderBtn);

    }
}
