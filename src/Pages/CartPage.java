package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By proceedToCheckOutButton=By.xpath("//a[@title='Proceed to checkout']") ;
    By totalPrice=By.id("total_price");
    By checkBox=By.xpath("//*[@id='uniform-cgv']");
    By checkPayment=By.xpath("//a[@title='Pay by check.']");
    By confirmOrderButton=By.xpath("//button[@type='submit']/span[text()='I confirm my order']");
    By message=By.xpath("//p[@class='alert alert-success']");
    By proceedToCheckOutButtonSummary=By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']/span") ;
    By proceedToCheckOutAddress=By.xpath("//button[@name='processAddress']/span");
    By proceedToCheckOutShipping=By.xpath("//button[@name='processCarrier']/span");
    

    public CartPage clickOnProceedToCheckout() {
        click(proceedToCheckOutButton);
        return this;
    }

    public CartPage verifyTotalPrice(String price) {
        String actualTitle = readText(totalPrice);
        assertTextEquals(price, actualTitle);
        return this;
    }

    public CartPage acceptTerms() {
        click(checkBox);
        return this;
    }

    public CartPage choosePayByCheckOption() {
        click(checkPayment);
        return this;
    }

    public CartPage confirmOrder() {
        click(confirmOrderButton);
        return this;
    }

    public CartPage verifySuccessfulOrder(String confirmationMessage) {
        String actualTitle = readText(message);
        assertTextEquals(confirmationMessage, actualTitle);
        return this;
    }

    public CartPage clickOnProceedToCheckoutSummaryPage() {
        click(proceedToCheckOutButtonSummary);
        return this;
    }

    public CartPage clickOnProceedToCheckoutAddress() {
        click(proceedToCheckOutAddress);
        return this;
    }

    public CartPage clickOnProceedToCheckoutShipping() {
        click(proceedToCheckOutShipping);
        return this;
    }
    
}
