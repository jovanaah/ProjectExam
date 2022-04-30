package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    public HomePage(WebDriver driver) {
        super(driver);
    }


    String url="http://automationpractice.com/index.php";
    By bestSellersLink = By.xpath("//a[@class='blockbestsellers']");
    By popularPageNumberOfProducts = By.xpath("//ul[@class='product_list grid row homefeatured tab-pane active']//div[@class='product-container']");
    By bestSellersPageNumberOfProducts = By.xpath("//ul[@class='product_list grid row blockbestsellers tab-pane active']//div[@class='product-image-container']");
    By signInButton=By.xpath("//a[@title='Log in to your customer account']");
    By signOutButton=By.xpath("//a[@title='Log me out']");
    By tShirtsButton=By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[@title='T-shirts']");
    By addToCartButton=By.xpath("//*[@id='add_to_cart']/button/span");
    By product=By.xpath("//*[@id='center_column']/ul/li/div/div[2]/h5/a");

    public HomePage goToWebsite(){
        driver.get(url);
        return this;
    }

    public HomePage verifyNumberOfProductsOnPopularPage(int numberOfPopularProducts) {
        int actualNumberOFProducts = countItems(popularPageNumberOfProducts);
        assertIntegerEquals(numberOfPopularProducts, actualNumberOFProducts);
        System.out.println("Actual number on popular page:"+actualNumberOFProducts+", expected number on popular page:"+numberOfPopularProducts);
        return this;
    }

    public HomePage clickOnBestSeller() {
        click(bestSellersLink);
        return this;

    }

    public HomePage verifyNumberOfProductsOnBestSellerPage(int numberOfBestSellerProducts) {
        int actualNumberOFProducts = countItems(bestSellersPageNumberOfProducts);
        assertIntegerEquals(numberOfBestSellerProducts, actualNumberOFProducts);
        System.out.println("Actual number on best seller page:"+actualNumberOFProducts+", expected number on best seller page:"+numberOfBestSellerProducts);
        return this;
    }

    public HomePage clickOnSignInButton() {
        click(signInButton);
        return this;
    }

    public HomePage clickOnSignOutButton() {
        click(signOutButton);
        return this;
    }

    public HomePage clickOnTShirts() {
        click(tShirtsButton);
        return this;
    }

    public HomePage clickOnAddToCart() {
        assertElementVisible(addToCartButton);
        click(addToCartButton);
        return this;
    }

    public HomePage clickOnProduct() {
        click(product);
        return this;
    }

  
    
}
