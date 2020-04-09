import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class UserInteractions {
    WebDriver driver; // khai báo một biến để dùng được các API của WebDriver
    WebDriverWait waitExplicit;
    JavascriptExecutor javascriptExecutor;
    Actions acctions; //Bộ thư viện hỗ trợ cho các thao thác của bàn phím và chuột

    @Before
    public void BeforeTest() {
        javascriptExecutor = (JavascriptExecutor) driver; // ép kiểu
        Actions actions = new Actions(driver); // Khởi tạo
        waitExplicit = new WebDriverWait(driver, 30); // tạo thư viện để chờ cho các item trong dropdown xuất hiên
        // lấy đường dẫn tuyệt đối sang máy khác sẽ lỗi nên ta sẽ lấy đường dẫn tương đói từ tên project trở đi
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hanh\\IdeaProjects\\AutomationThayDam\\.idea\\drivers\\chromedriver.exe"); //set đường dẫn đến webDriver
//        System.setProperty("webdriver.chrome.driver", ".\\idea\\drivers\\chromedriver.exe"); //set đường dẫn đến webDriver
//        driver = new ChromeDriver(); // Khởi tạo trình duyệt
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().window().maximize();
    }

    @After
    public void AfterTest() {
        driver.quit();
        driver.close();
    }

    @Test
    public void TC_1() {
/* Các thao tác của chuột
- Click chuột trái -->click();
- Scroll (cái này thuộc về trình duyệt của js, selenium không hỗ trợ)
- double click --> DoubleClick();
- Hover --> MoveToElement();
- Click and hold (Giữ chuột và di) --> ClickAndHold
- Drag and Drop (kéo thả) --> DragAndDrop(); // truyền tọa độ vào
- right click --> contextclick();
* Các thao tác với bàn phím
- key up (trả phím)
- key down (nhấn phím)
- sendkey (cho cả trình duyệt (f11) và element)
--> Các thao tác đều có API cho cả brower hoặc element
--> Để lấy được tọa độ element ta sử dụng addon: (Dimentions) https://chrome.google.com/webstore/detail/dimensions/baocaagndhipibgklemoalmkljaimfdj
Các extention để test reponsive (mouse position) để xác định tọa độ con trỏ chuột đang đứng
- Hàm build: khi muốn gom nhiều action để chạy cùng lúc
- Hàm release: Nhả chuột trái (Dùng cho trường hợp trả chuột khi kéo thả
- Hàm perform: để run action
--> Trên cùng 1 thời điểm trên 1 hệ điều hành chỉ cho phép nhận 1 sự kiện chuột hoặc bàn phím (khi đang chạy không được dùng chuột)
- Nguyên tắc khi test end to end (test function) tập trung vào chức năng trước mới test giao diện
- Nguyên tắc khi test UI là quan sát thay đổi khi thao tác với element để viết test
- Để lấy ra được 1 element trong list t dùng hàm get(0)
*/
        List<WebElement> numberItem = driver.findElements(By.xpath("hhh"));
acctions.moveToElement(driver.findElement(By.xpath(""))).perform();
acctions.clickAndHold(numberItem.get(0)).moveToElement(numberItem.get(3));
// clickAndHold theo random, phải nhấn phím ctrl trước khi click chuột chọn ta sẽ dùng từ khóa keydown
        acctions.keyDown(Keys.CONTROL).build().perform();
                acctions.click(numberItem.get(2));
                acctions.click(numberItem.get(5));
                acctions.keyUp(numberItem.get(5), Keys.CONTROL).release().perform();



    }

}