/* 1 class test sẽ bao gồm:  pre- data --> testcase --> verify --> clean data
- Trong 1 test nếu 1 đoạn assert lỗi nó sẽ đánh fail test case, sai với tiêu chí regression test.
- Mục tiếu của regression test (Test hồi quy) là: khi có sự thay đổi, mình sẽ test regression test để ktra chức năng cũ và chức năng
mới vẫn hoạt động đúng
- Tại sao lại cần test regression test: Đảm bảo tất cả các chức năng được chạy qua
- Verify sẽ chạy qua tất cả test case, chỉ đánh trượt test case bị fail.
--> cách custom từ assert sang verify: Tạo ra 3 hàm ở abstract test (check pass/check fail và equal)
*/
package feature;

import common.AbstractTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class AssertVerifyLogReportHTML extends AbstractTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    TrangChuPage trangChuPage;
    WebDriverWait waitExplicit;
    PhieuThuPage phieuThuPage;
    BaoNoPage baoNoPage;
    @Before
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitExplicit = new WebDriverWait(driver, 15);
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().window().maximize();
    }
    @After
    public void AfterTest() {
        driver.close();
        driver.quit();
    }
    @Test
    public void TC_01_Login() throws InterruptedException {
        log.info("login- Step01:Open browser"); // log lỗi
        homePage.fieldUserName("admin");
        homePage.fieldPassword("admin");
        loginPage = homePage.clickButtonLogin();
        loginPage.clickComboboxCompany();
        trangChuPage = loginPage.clickButtonLogin();
        trangChuPage.clickIconMenu();
//Dùng thay thế verify cho Assert để nếu có test fail vẫn chạy tất cả test case
//        Assert.assertTrue(trangChuPage.AssertUserName("Đồng Thị Đồng Đức"));
        verifyFalse(trangChuPage.AssertUserName("Đồng Thị Đồng Đức"));
        baoNoPage = (BaoNoPage) trangChuPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Báo Nợ");
        phieuThuPage = (PhieuThuPage) baoNoPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Phiếu thu");
    }

}