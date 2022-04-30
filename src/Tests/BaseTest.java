package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jcvijovi\\PROJECT CODE\\Projekat\\Projekat\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google Chrome (Local)\\chrome.exe");
        
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }
     
}
