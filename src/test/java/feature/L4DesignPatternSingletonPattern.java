/* Nguyên tắc ở tầng test case sẽ không nhìn thấy việc khởi tạo và không khởi tạo quá nhiều lần
--> SingletonPattern giúp khắc phục 2 vấn đề trên (làm việc theo nguyên tắc đóng gói của lập trình hướng đối tượng-
che giấu việc khởi tạo, cho pháp phạm vi truy cập vào một biến hoặc 1 phương thức nào đó)
- mỗi 1 test case ta lại phải khởi tạo 1 lân pageObject, ta sẽ sử dụng singletonpattern để khởi tạo 1 lần, ta sẽ tạo ra 1 class để
quản lý các page (singleton pattern) - chúng ta sẽ apply ký thuật lazy initialization

*/

package feature;

import common.PageFactoryManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class L4DesignPatternSingletonPattern {
    private WebDriver driver;
    WebDriverWait waitExplicit;
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        waitExplicit = new WebDriverWait(driver, 15);
        homePage = PageFactoryManager.getHomePage(driver);

    }
    @After
    public void AfterTest() {
        driver.quit();
    }
//    @Test
//    public void TC_01_Login() {
//        homePage = new HomePage(driver);  mỗi 1 test case ta lại phải khởi tạo 1 lân pageObject, ta sẽ sử dụng singletonpattern để khởi tạo 1 lần
//        homePage.fieldUserName("admin");
//        homePage.fieldPassword("admin");
//        homePage.clickButtonLogin();
//        loginPage = new LoginPage(driver);  cho việc khởi tạo vào luôn hàm clickButtonLogin
//        loginPage.fieldCompanyName("Chi nhánh 1");
//        loginPage.clickButtonLogin();
//    }
    @Test
    public void TC_01_Login() {
        homePage.fieldUserName("admin");
        homePage.fieldPassword("admin");
        loginPage = homePage.clickButtonLogin(); // có sự kết nối giữa các page
        loginPage.fieldCompanyName("Chi nhánh 1");
        loginPage.clickButtonLogin();
    }
}