package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;



public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
       wait = new WebDriverWait(driver, 30);
    
    }

    public void waitForElementToBeVisible(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void writeText(By elementBy, String text){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);

    }

    public void click(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }

    public String readText(By elementBy){
        waitForElementToBeVisible(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertTextEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public void assertElementVisible(By elementBy){
        boolean isVisible = driver.findElement(elementBy).isDisplayed();
        Assert.assertTrue(isVisible);
    }


    public int countItems(By elementBy){
        waitForElementToBeVisible(elementBy);
        driver.findElements(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void assertIntegerEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);

    }

    public void selectByText(By elementBy, String tekst) {
        WebElement identifier = driver.findElement(elementBy);
        Select select = new Select(identifier);
        select.selectByVisibleText(tekst); 
    }  

    public String generateRandomId() {
		String id=RandomString.make();
		return id;
	}

    public void input(By elementBy, String text){
      driver.findElement(elementBy).sendKeys(text);
    }
}
