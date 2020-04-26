/* String format là định dạng chuỗi
- %s là đại diện cho 2 chuỗi nào đó, đây là 1 tham số và được truyền từ bên ngoài
*/
package feature;

import common.PageFactoryManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class L7DynamicAndRestParamater {
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
        homePage.fieldUserName("admin");
        homePage.fieldPassword("admin");
        loginPage = homePage.clickButtonLogin();
        loginPage.clickComboboxCompany();
        trangChuPage = loginPage.clickButtonLogin();
        trangChuPage.clickIconMenu();
        baoNoPage = (BaoNoPage) trangChuPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Báo Nợ");
        phieuThuPage = (PhieuThuPage) baoNoPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Phiếu thu");

    }
//    @Test
//    public void TC_02_WebDriverLifeCycle(){ // mở MultiPage
//        baoNoPage = trangChuPage.openOnBaoNoPage(driver); // chuyển page
//        phieuThuPage = baoNoPage.openOnPhieuThuPage(driver);
//    }
//    @Test
//    public void TC_03_Dynamic(){ // chỉ có 1 hàm để mở multiPage
//        baoNoPage = (BaoNoPage) trangChuPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Báo Nợ" );
//        phieuThuPage = (PhieuThuPage) baoNoPage.openMultiPage(driver, "TIỀN MẶT VÀ NGÂN HÀNG", "Phiếu thu");
//}
//    @Test
//    public void TC_03_Dynamics(){ // dùng khi có quá nhiều page
//        trangChuPage.openMultiPages(driver, "TIỀN MẶT VÀ NGÂN HÀNG","Báo Nợ" );
//        baoNoPage = PageFactoryManager.getBaoNoPage(driver);
//        baoNoPage.openMultiPages(driver, "TIỀN MẶT VÀ NGÂN HÀNG", "Phiếu thu");
//        phieuThuPage = PageFactoryManager.getPhieuThuPage(driver);
//    }


}