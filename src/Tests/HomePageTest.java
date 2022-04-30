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

}
