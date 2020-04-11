import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {
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
/* Selenium support 3 loại wait: Implicit, Explicit, Fluent. Java có thêm 1 loại là Thread.sleep (chạy trên IE hay dùng sleep)
dùng được cho selenium luôn.
1. Thread.sleep (static wait/Dead wait): fix cứng đơn vị tính là miliseconds:
Ưu điểm: Dùng khi đang implement testscript (dùng để debug/detect- phát hiện)
Dùng cho IE khi chuyển page hoặc seach
Nhược điểm: (Từ khóa Flakey test- là những test bị fail bất thường- không ổn đinh)
- Nếu thời gian chờ element được visiable mà lớn hơn thời gian của sleep thì case sẽ bị faile
- Nếu thời gian tìm nhỏ hơn thời gian sleep thì nó sẽ không chạy sang step tiếp theo
2. Implicit (ngầm định): Được gọi là ngầm định vì nó wait cho hàm findElement/findElements
 (Có thể set nhiều lần, nhưng nó sẽ lấy timeout của thằng cuối cùng cho các step sau)
--> Sự khác nhau của findElement và FindElements:
- Với findElement: nếu không tìm thấy element nào thì sẽ chờ hết timeout và sau đó đánh false testcase/ Throw exception
là no such, ....
nếu tìm thấy 1 element thì thao tác với element, còn nếu tìm thấy nhiều element thì sẽ thao tác với element đầu tiên
- Với findElements: Nếu chờ hết time out và không tìm thấy Element nào thì nó không đánh fail test và sẽ trả về một list
 rỗng và chạy tiếp test tiếp theo, nếu tìm thấy từ 1 elemet trở lên thì nó sẽ thao tác với các elements
 --> Sự khác nhau giữa visible và precense: (DOM là
 + Những element có trong DOM sẽ chạy nhanh, nếu không có trong DOM thì nó phải chờ timeout nên nó chạy chậm
 + presence: là 1 element presense có trong DOM và không thể tương tác được
 + Visible: là 1 element có trong DOm và người dùng thao tác được
 + inVisible: Có trong DOM và không hiển thị. hoặc không co trong DOM
 - Visible có trong DOM (những element được render ra sau khi làm 1 thao tác gì đó nên trước đó nó sẽ không có trong dom):pass
 - Visible không có trong DOM: fail
 - inVisible (vô hình) không có trong DOM: pasa
 - inVisible có trong DOM: fail
 - Presence không có trong DOM: pass
 - Presence có trong DOM: pass

Sự khác nhau của implicit và Explicit:
Dùng 2 loại wait này có bị conflic không: 2 loại này không bị conflic
3. Explicit (rõ ràng): là wait cho element và có các thuộc tinh của nó: ví dụ như wait cho element (presence (sự hiện diện),
visible, invisible) URL, alert, title (nó sẽ có các hàm rõ ràng
4. Fluent (theo chu kì): Thời gian đếm ngược (cứ 1 khoảng thời gian nào đố sẽ xem có kết quả chưa) nếu đã có kết quả thì dừng timeout
và hiển thị kêt quả.
--> single page Application - SPA: Request và respon trên 1 page: giảm việc load lại trang tốn thời gian và tài nguyên
- Ajax: load data mà không cần load lại page (thẻ dùng cái này thường có chữ ra phía trước)

*/

    @Test
    public void TC_1Explicit() {
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input"))); // bị fail nếu như thẻ bị ẩn
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("input"))); // dùng presence thì nó sẽ click được những element không nhìn thấy
    }

}