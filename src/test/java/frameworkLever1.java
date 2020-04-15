import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
//Lever 1 là dropdown step by step - chạy từ trên xuống dưới (chỉ dùng selenium)
public class frameworkLever1 {
    WebDriver driver;
    WebDriverWait waitExplicit;
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
        driver.close();
    }
/* build frameword- tạo dự án với maven
- Tạo với mô hình POM (page Object Model)
Bước 1: Tạo ra các tầng cho framwork
Tầng 1: Testcase - quản lý những module của testcase (phân theo từng chức năng)- Mỗi một module sẽ tạo ra 1 package ở tầng testcase
Mỗi chức năng con của module sẽ tương ứng với các class test. mỗi class test chỉ tối đa 15 testcase
Tầng 2: Actions - tạo ra package common (Utilities) và pageObject:
package common là tất cả các class dùng chung: Ví dụ như Abtracttest là những hàm dùng chung cho tầng testcase. AbtractPage là nhwx class
dùng chung cho package PageObject. Contain là những biến hoặc hằng số dùng chung cho toàn bộ Project
Package PageObject là package chứa tất cả các page của dự án (các page mình sẽ phân theo chức năng của nó chứ không phải theo màn hình)
mình sẽ viết những hàm (function) tương tác với page
Tầng 3: Interface: Sẽ có các module chứa các class tương ứng với các page ở bên pageObject (các locator)
Tầng 4: Resources: Chứa các file bên ngoài hoặc các file setup(driver,...)
*/
    @Test
    public void TC_1Explicit() {
    }

}