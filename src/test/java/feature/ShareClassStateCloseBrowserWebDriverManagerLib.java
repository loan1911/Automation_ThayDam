/* Mỗi một class ta phải chạy login 1 lần, dẫn đến tạo ra user nhiều lần
--> gom việc tạo user cho 1 class sau đó gọi ra dùng chung cho các class khác.có biến
 public static để lấy thông tin login. phải triger để cho nó chạy class đăng ký tài
 khoản đầu đầu tiên để lấy thông tin tài khoản dùng cho các class khác. ta sẽ cho chạy class
 đăng ký tài khoản chạy đầu tiên trong phần setup ở file testing.xml của testNG.
--> 1 browser khi bị crash sẽ sinh ra thêm 1 chrome driver. nếu chạy nhiều lần sẽ sinh ra
nhiều browser trong task manager.
- Hàm driver.quit()/close(). Nó chỉ tắt browser không tắt driver.
--> Giải pháp là dùng command line xóa luôn tất cả các chương trình, hoặc restart lại sever
sau 1 thời gian cố định.
-- kill 1 process trong task manager (mỗi 1 process sẽ có 1 ID (Trong phần detail sẽ có PID)
--> Tắt giữa chừng thì phần after sẽ không chạy, nên ta sẽ sử dụng 1 annotation alwaysRun= true
-- Browser Driver manager là để khi browser được nâng cấp thì chrome driver cũng được nâng
cấp theo. thay vì xóa đi và update bắng tay ta sẽ dùng bộ thư viện webdrivermanager lib
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

public class ShareClassStateCloseBrowserWebDriverManagerLib extends AbstractTest {
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