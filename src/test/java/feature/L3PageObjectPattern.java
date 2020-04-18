package feature;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class L3PageObjectPattern {
    private WebDriver driver;
    WebDriverWait waitExplicit;
    HomePage homePage;
    @Before
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        waitExplicit = new WebDriverWait(driver, 15);
    }
    @After
    public void AfterTest() {
        driver.quit();
    }
    @Test
    public void TC_01_Login() {
        homePage = new HomePage(driver);
        homePage.fieldUserName("admin");
        homePage.fieldPassword("admin");
        homePage.clickButtonLogin();

    }

}