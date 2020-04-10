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

public class WindowsTab {
    WebDriver driver;
    WebDriverWait waitExplicit;
    JavascriptExecutor javascriptExecutor;
    @Before
    public void BeforeTest() {
        javascriptExecutor = (JavascriptExecutor) driver; // ép kiểu
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
/* các case của windows:
case 1: khi có 2 tab thì thằng đầu là parent Windows, thằng mở ra là child windows
-compare (đối chiếu thằng cha và thằng con): get id thằng cha, sau đó bật ra thằng con, lấy id của cả cha và con, sau đó
switch qua thằng con (driver.switchTo().windows(GUID);
case 2: có thể cave được >= 2 tab
- get ra guid sau đó get ra title của từng tab : đối chiếu với title mong muốn thì chuyển quá
- Set khác vơi list và array là set không cho lưu các giá trị trùng nhau

*/
Set<String> allWindows = driver.getWindowHandles(); // get ra tất cả các ID của các tab windows
        for (String windows : allWindows){
            driver.switchTo().window(windows);
            String currentWindows = driver.getTitle();
            if(currentWindows.equals(title));
            break;
        }
    }

}