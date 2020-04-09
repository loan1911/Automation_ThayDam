import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;


public class ButtonRadioCheckboxAlert {
    WebDriver driver; // khai báo một biến để dùng được các API của WebDriver
    WebDriverWait waitExplicit;
    JavascriptExecutor javascriptExecutor;

    @Before
    public void BeforeTest() {
        javascriptExecutor = (JavascriptExecutor) driver; // ép kiểu
        waitExplicit = new WebDriverWait(driver, 30); // tạo thư viện để chờ cho các item trong dropdown xuất hiên
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hanh\\IdeaProjects\\AutomationThayDam\\.idea\\drivers\\chromedriver.exe"); //set đường dẫn đến webDriver
        driver = new ChromeDriver(); // Khởi tạo trình duyệt
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
//        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().window().maximize();
    }

    @After
    public void AfterTest() {
        driver.quit();
        driver.close();
    }

    @Test
    public void TC_1() {
driver.get("http:admin:admin@//14.225.3.184:8081/#/"); // truyền user/pass vào trực tiếp và thêm ký tự @

/* Với Button ta sẽ sử dụng API click, nhưng với IE thì click của selenium sẽ không nhận
- Với checkbox và radiobutton có thể dùng được hàm isSelected để kiểm tra đã chọn hay chưa nhưng chỉ dùng với thẻ input
- Dùng js click nó sẽ nhanh hơn vì nó đã được render khi mở trình duyêt rồi, còn click của selenium nó sẽ load hết giao diện lại như đâu
- dùng js có theerr click khi chuyển trang hoặc element bị che
- Checkbox và radiobutton nó cũng có 2 loại là default và custom. loại deefault sẽ được hight line ô checkbox, còn custom thì hight line text
(Vì vậy khi dùng thẻ input sẽ không bắt được element nên ta không dùng hàm click thông thường của selenium được)
Lưu ý: Với custom checkbox thẻ input không lấy id, vì id tăng dần theo index dẫn đến bị thay đổi, dẫn đến click bị sai
- Với click ta có thể click vào text
- iselected chỉ dùng cho thẻ input không dùng cho text được --> với checkbo ta phải có 2 xpath 1 để click và 1 verify
--> để chỉ dùng 1 xpath ta dùng click của js
- Alert có 3 loại (đều là js alert): loại 1 chỉ cho phép accept, loại 2 là cho accept hoặc cancel, loại 3 là cho phép nhập text và cancel
--> Sự khác nhau giữa Alert và popup là: alert là của trình duyệt (nên ta không bắt được elemet), popup là của app ta có thể custom nó
--> để làm việc với alert ta dùng thư viện riêng của nó
- Để authentication ta có thể truyền thẳng vào URL
*/
javascriptExecutor.executeScript("arguments[0].click();", "Xpath"); // click vào button số 0
//        Alert acceptAlert = driver.switchTo().alert();
//        acceptAlert.accept(); // Đồng ý alert
//        acceptAlert.dismiss(); // cancel alert
//        acceptAlert.sendKeys(""); //nhập text vào alert
//        acceptAlert.getText(); // get text trong alert
//        driver.navigate().refresh(); //f5 trang
    }

}