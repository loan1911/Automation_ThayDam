/* 1 class chỉ nên bố trí 5-10 test tùy thuộc vào độ dài của testcase
c1: Data test đưa vào phần before, quản lý tập trung
C2: Có thể tuyền data vào file xml để chạy (nhưng không nên làm cách này). sau đó dùng parameter để lấy ra.
C3: Tạo ra 1 testclass để chứa data của các testcase. mối class sẽ có 1 class data tương ứng
c4: Tạo 1 file json, cài plugin json editer. add dependences thư viện json vào
*/
package feature;

import common.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class ManageTestDataRetryTestFailed extends AbstractTest {
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
        verifyFalse(trangChuPage.AssertUserName("Đồng Thị Đồng Đức"));
        baoNoPage = (BaoNoPage) trangChuPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Báo Nợ");
        phieuThuPage = (PhieuThuPage) baoNoPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Phiếu thu");
    }

}