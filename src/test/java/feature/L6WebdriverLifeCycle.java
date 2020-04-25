/* Các chức năng của menu luôn cố định khi mình click vào bất kỳ page .
- Các testcase phải theo luông chức năng. phải có sự kết nối giữa các test không được chuyển page linh tinh
- Khi các một hành động chuyển qua page mới thì phải return về page đó
- Khi tạo ra một page mới cần làm 3 việc sau:
+ Tạo page objectclass
+ Tạo pageUI class
+ Tạo pageFactoryManager
--> Khi mà chuyển từ 1 page qua các page khác mỗi màn ta lại phải viết 1 hàm trả về hàm đó để chuyển page dẫn đến viết quá nhiều hàm
--> Ta se dùng framework để mỗi framework chỉ dùng 1 hàm để gọi
- Các chức năng ở menu sẽ được cố định và có thể di chuyển qua nhau ta sẽ design ra một page khác không thể design chung vào pageobject
--> dùng cho cho toàn bộ pageObject mình sẽ viết trong abstractPage


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

public class L6WebdriverLifeCycle {
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
    }
//    @Test
//    public void TC_02_WebDriverLifeCycle(){
//        baoNoPage = trangChuPage.openOnBaoNoPage(driver); // chuyển page
//    }
//    public void TC_03_HightlightElement(){
//
//    }

}