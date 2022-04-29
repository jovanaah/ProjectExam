package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
      
    }

   
    By emailAddressInput = By.id("email");
    By passwordInput = By.id("passwd");
    By signInButton = By.xpath("//*[@id='SubmitLogin']/span");
    By createAccountTitle=By.xpath("//h3[@class='page-subheading' and text()='Create an account']");
    

    public LoginPage signIn(String username, String password) {
        writeText(emailAddressInput, username);
        writeText(passwordInput, password);
        click(signInButton);
        return this;
    }


    public LoginPage verifySuccessfulSignOut(String signOutMessage) {
        String actualTitle = readText(createAccountTitle);
        assertTextEquals(signOutMessage, actualTitle);
        return this;
    }
    
}
