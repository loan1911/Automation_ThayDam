/* Các page có nhiều element dẫn đến mình sẽ phải viết quá nhiều hàm. nên ta sẽ sử dụng
dynamic element như dynamic page (dùng %s cho các xpath của các element có các đặc điểm
giống nhau).

*/
package feature;

import common.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.WebdriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class POM12DynamicPageElement extends AbstractTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    TrangChuPage trangChuPage;
    WebDriverWait waitExplicit;
    PhieuThuPage phieuThuPage;
    BaoNoPage baoNoPage;
    String userValue = "admin";
    String pass = "admin";
    @Before
    public void BeforeTest() {
//        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitExplicit = new WebDriverWait(driver, 15);
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().window().maximize();
    }
    @After() // @AfterClass(alwaysRun=true) cái này của testNG
    public void AfterTest() {
//        driver.close(); -- Thay bằng hàm closeBrowser()
//        driver.quit();
        closeBrowserAndDriver(driver);
    }
    @Test
    public void TC_01_Login() throws InterruptedException {
        log.info("login- Step01:Open browser"); // log lỗi
        homePage.fieldUserName(userValue);
        homePage.fieldPassword(pass);
        loginPage = homePage.clickButtonLogin();
        loginPage.clickComboboxCompany();
        trangChuPage = loginPage.clickButtonLogin();
        trangChuPage.clickIconMenu();
//Dùng thay thế verify cho Assert để nếu có test fail vẫn chạy tất cả test case
//        Assert.assertTrue(trangChuPage.AssertUserName("Đồng Thị Đồng Đức"));
        verifyTrue(trangChuPage.AssertUserName("Đồng Thị Đồng Đức"));
        baoNoPage = (BaoNoPage) trangChuPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Báo Nợ");
        phieuThuPage = (PhieuThuPage) baoNoPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Phiếu thu");
    }

}