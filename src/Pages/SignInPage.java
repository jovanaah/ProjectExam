package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    By emailInputField=By.xpath("//input[@id='email_create']");
    By createAccountButton=By.xpath("//button[@id='SubmitCreate']");
    By firstNameInput = By.xpath("//*[@id='customer_firstname']");
    By lastNameInput = By.xpath("//*[@id='customer_lastname']");
    By emailInput = By.xpath("//*[@id='email']");
    By passwordInput = By.xpath("//*[@id='passwd']");
    By firstNameAddressInput = By.xpath("//*[@id='firstname']");
    By lastNameAddressInput = By.xpath("//*[@id='lastname']");
    By addressAddressInput = By.xpath("//*[@id='address1']");
    By cityAddressInput = By.xpath("//*[@id='city']");
    By stateAddressDropDown = By.xpath("//*[@id='id_state']");
    By zipPostalCodeInput= By.xpath("//*[@id='postcode']");
    By countryDropDown = By.xpath("//*[@id='id_country']");
    By mobilePhoneInput = By.xpath("//*[@id='phone_mobile']");
    By aliasAddressInput = By.xpath("//*[@id='alias']");
    By registerButton = By.xpath("//button[@id='submitAccount']");
    By registrationCompletedText = By.xpath("//h1[@class='page-heading']");
    By myWishlist=By.xpath("//a[@title='My wishlists']");
    By signInCompleted = By.xpath("//h1[@class='page-heading']");
    By wrongUserMessage = By.xpath("//div[@class='alert alert-danger']/ol/li");
    By signOutButton=By.xpath("//a[@title='Log me out']");


    public SignInPage inputEmail(String emailAddress) {
        writeText(emailInputField, emailAddress);
        return this;
    }

    public SignInPage clickOnCreateAccountButton() {
        click(createAccountButton);
        return this;
    }

    public SignInPage fillOutRegistrationForm(String firstName, String lastName, String emailAddress, String password,
            String address, String city, String zipCode, String mobilePhone, String addressAlias) {
                writeText(firstNameInput, firstName);
                writeText(lastNameInput, lastName);
                writeText(emailInput, emailAddress);
                writeText(passwordInput, password);
                writeText(firstNameAddressInput, firstName);
                writeText(lastNameAddressInput, lastName);
                writeText(addressAddressInput, address);
                writeText(cityAddressInput, city);
                writeText(zipPostalCodeInput, zipCode);
                writeText(mobilePhoneInput, mobilePhone);
                writeText(aliasAddressInput, addressAlias);
                selectByText(stateAddressDropDown, "California");
                click(registerButton);
                return this;
    }

    public SignInPage verifyCompletedRegistration(String successfullRegistration) {
        String actualTitle = readText(registrationCompletedText);
        assertTextEquals(successfullRegistration, actualTitle);
        return this;
    }

    public SignInPage verifySuccessfulSignIn(String successfulLogin) {
        waitForElementToBeVisible(myWishlist);
        String actualTitle = readText(signInCompleted);
        assertTextEquals(successfulLogin, actualTitle);
        return this;
    }

    public SignInPage clickOnSignOutButton() {
        click(signOutButton);
        return this;
    }

    public SignInPage verifyUnsuccessfulSignIn(String expectedText) {
        String actualTitle = readText(wrongUserMessage);
        assertTextEquals(expectedText, actualTitle);
        return this;
    }
    
}
