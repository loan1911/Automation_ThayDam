import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class JavascriptExecutor {
    WebDriver driver;
    WebDriverWait waitExplicit;
    org.openqa.selenium.JavascriptExecutor javascriptExecutor;
    @Before
    public void BeforeTest() {
        javascriptExecutor = (org.openqa.selenium.JavascriptExecutor) driver; // ép kiểu
        Actions actions = new Actions(driver); // Khởi tạo
        waitExplicit = new WebDriverWait(driver, 30); // tạo thư viện để chờ cho các item trong dropdown xuất hiên
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hanh\\IdeaProjects\\AutomationThayDam\\.idea\\drivers\\chromedriver.exe"); //set đường dẫn đến webDriver
        driver = new ChromeDriver(); // Khởi tạo trình duyệt
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().window().maximize();
    }

    @After
    public void AfterTest() {
        driver.quit();
        driver.close();
    }
/* Trong selenium mỗi một tab windows sẽ có 1 id để định danh (nó là 1 GUID).
*/

    @Test
    public void TC_1(String title) {
/* Dùng consol để reject js khi f12
- Khi có date time picker ta xóa type = date đi để trở về dang text để handle
Sử lý được khi chạy test lúc pass lúc không tên IE
+ Các vấn để cần handle với js mà selenium không xử lý được
- search với big data - IE
- click/switch page với IE
- Scroll
- Remove Attribute
- hightlight element khi demo
- get value on page
* Tại sao nhiều web trên IE chạy chậm hoặc không ổn định được nhưng vẫn dùng vì vẫn có các công ty vẫn đang dùng
- Thư viên cần import của js là javascriptExecutor (nó cũng là 1 thư viện của selenium)

*/
    }

}