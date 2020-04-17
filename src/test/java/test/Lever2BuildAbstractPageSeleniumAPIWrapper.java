/*Wapper thành những hàm common dùng cho tầng PageObject (các hà API selenium được lặp rất nhiều lần nên ta sẽ wapper nó lại)
- Intelij Tip (hotkey): để code nhanh hơn
- Convention gồm những cái rule (quy tắc):
+ Quy tắc đặt tên function/variable (lowercase- viết thường chữ đầu tiền các chữ sau sẽ viết hoa chữ đầu)
+ Tên class (tầng testcase): order theo anpha + số thứ tự + chức năng cần test: Account_01_Registerlogin
+ Tên class (Tầng interface/pageObject): theo tên chức năng (LoginPageObject)
+ Tên Testcase: đại diện là 1 function: Order theo thứ tự + Tên testcase: TC01_loginSystem
+ Khi hoàn thành chức năng thì nên release code. (Bỏ sout, bỏ comment không cân thiết đi (sau này sẽ dùng log))
+ Cách viết common function: Tên phải dễ hiểu, paramater truyền vào phải có (Webdriver driver), Kiểu trả về của hàm
*/
package test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.common.AbstractObject;

import java.util.concurrent.TimeUnit;

public class Lever2BuildAbstractPageSeleniumAPIWrapper {
    WebDriver driver;
    WebDriverWait waitExplicit;
    AbstractObject abstractObject;
    @Before
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        abstractObject = new AbstractObject();
        driver = new ChromeDriver();
//        driver.navigate().to("http://14.225.3.184:8081/#/");
        abstractObject.openAnyUrl(driver, "http://14.225.3.184:8081/#/"); //Sử dụng hàm chung bên AbstractObject
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        waitExplicit = new WebDriverWait(driver, 15);
    }
    @After
    public void afterTest() {
        driver.quit();
        driver.close();
    }
    @Test
    public void abstractPageApply() {
//        Assert.assertTrue(driver.findElement(By.xpath("truyền Xpath vào")).isDisplayed());
        Assert.assertTrue(abstractObject.isControlDisplayed(driver, "truyền Xpath vào"));

    }

}
