package Tests;

import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignInPage;

public class LoginTest extends BaseTest{
    public HomePage homePage;
    public SignInPage signInPage;
    public LoginPage loginPage;

    String unexistingUserName = "blabla@email.com";
    String wrongErrorExpectedtext = "Authentication failed.";
    String errorMessageMissingUsername = "An email address required.";
    String errorMessageMissingPassword = "Password is required.";
    String password="Qwer123$";
    String successfulLogin="MY ACCOUNT";
    String username="jovanacvijovic@gmail.com";
    String signOutMessage="CREATE AN ACCOUNT";



@Test
public void verifySuccessfulSignIn() {

    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver); 
    signInPage=new SignInPage(driver);
    homePage.goToWebsite();
    homePage.clickOnSignInButton();
    loginPage.signIn(username, password);
    signInPage.verifySuccessfulSignIn(successfulLogin);
}

@Test
public void verifyWrongUsernameUnsuccessfulSignIn() {

    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver); 
    signInPage=new SignInPage(driver);
    homePage.goToWebsite();
    homePage.clickOnSignInButton();
    loginPage.signIn(unexistingUserName , password);
    signInPage.verifyUnsuccessfulSignIn(wrongErrorExpectedtext);
}

@Test
public void verifySigninWithoutUsername() {
  
    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);
    signInPage=new SignInPage(driver);
    homePage.goToWebsite();
    homePage.clickOnSignInButton();
    loginPage.signIn("",  password );
    signInPage.verifyUnsuccessfulSignIn(errorMessageMissingUsername);
}

@Test
public void verifySignInWithoutPassword() {

    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);
    signInPage=new SignInPage(driver);
    homePage.goToWebsite();
    homePage.clickOnSignInButton();
    loginPage.signIn(username, "");
    signInPage.verifyUnsuccessfulSignIn(errorMessageMissingPassword);
}

@Test
public void verifySucessfullSignOut() {
    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);
    signInPage=new SignInPage(driver);
    homePage.goToWebsite();
    homePage.clickOnSignInButton();
    loginPage.signIn(username, password);
    signInPage.clickOnSignOutButton();
    loginPage.verifySuccessfulSignOut(signOutMessage);
   }


}
