package Tests;

import org.junit.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignInPage;

public class HomePageTest extends BaseTest{
    
    HomePage homePage;
    LoginPage loginPage;
    LoginTest loginTest;
    CartPage cartPage;
    SignInPage signInPage;

    int numberOfPopularProducts=7;
    int numberOfBestSellerProducts=7;
    String price="$19.25";
    String password="Qwer123$";
    String username="jovanacvijovic@gmail.com";
    String confirmationMessage="Your order on My Store is complete.";
    
    @Test
    public void verifyNumberOfProductsOnPopularPage(){

       
        homePage = new HomePage(driver);
    
        homePage.goToWebsite();
        homePage.verifyNumberOfProductsOnPopularPage(numberOfPopularProducts);

    }
   
    @Test
    public void verifyNumberOfProductsOnBestSellerPage(){

      
        homePage = new HomePage(driver);
    
        homePage.goToWebsite();
        homePage.clickOnBestSeller();
        homePage.verifyNumberOfProductsOnBestSellerPage(numberOfBestSellerProducts);
    }



    @Test
    public void addProductToCart(){
      
        homePage = new HomePage(driver);
        loginPage=new LoginPage(driver);
        cartPage=new CartPage(driver);
        signInPage=new SignInPage(driver);
        homePage.goToWebsite();
        homePage.clickOnSignInButton();
        loginPage.signIn(username, password);
        homePage.clickOnTShirts();
        homePage.clickOnProduct();
        homePage.clickOnAddToCart();
        cartPage.clickOnProceedToCheckout();
        cartPage.verifyTotalPrice(price);
        cartPage.clickOnProceedToCheckoutSummaryPage();
        cartPage.clickOnProceedToCheckoutAddress();
        cartPage.acceptTerms();
        cartPage.clickOnProceedToCheckoutShipping();
        cartPage.choosePayByCheckOption();
        cartPage.confirmOrder();
        cartPage.verifySuccessfulOrder(confirmationMessage);

        
    }


}
