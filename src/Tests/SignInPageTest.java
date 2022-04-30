package Tests;

import org.junit.Test;

import Pages.BasePage;
import Pages.HomePage;
import Pages.SignInPage;

public class SignInPageTest extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;
    BasePage basePage;

    String firstName = "Jovana";
    String lastName = "Cvijovic";
    String password = "Testing@1234";
    String address = "Address";
    String city = "Belgrade";
    String zipCode = "11000";
    String mobilePhone = "+38166666666";
    String addressAlias = "addressAlias";
    String successfullRegistration = "MY ACCOUNT";

    

    @Test
    public void createAccount(){
    homePage = new HomePage(driver);
    signInPage=new SignInPage(driver);
    basePage=new BasePage(driver);
    homePage.goToWebsite();
    homePage.clickOnSignInButton();
    String emailAddress=basePage.generateRandomId()+"@email.com";
    signInPage.inputEmail(emailAddress);
    signInPage.clickOnCreateAccountButton();
    signInPage.fillOutRegistrationForm(firstName, lastName, emailAddress, password, address, city, zipCode, mobilePhone, addressAlias);
    signInPage.verifyCompletedRegistration(successfullRegistration);
    }
    
}
