import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class popupIfram {
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
/* Ghi chú: với các web thương mai popup quảng cáo khi mở lần đầu có thể xuất hiện hoặc không xuất hiện
Sự khác nhau của frame và iframe
- iframe là nhúng đường link khác domain
- frame là nhúng đường link cùng domain (Để kiểm tra xem có iframe hay frame không ta dùng firebug hoặc firepath gõ //iframe hoặc //frame
- frame/iframe là 1 trang con nhúng vào trang cha vẫn có 1 thẻ HTML (DOM) như 1 trang bình thường
- có 1 1 thư viện để handle là driver.switchTo().Frame()
- Nếu muốn khi một testcase nào đó lỗi bỏ qua và sang step tiếp theo ta
- selenium define cứ nửa giây tìm element 1 lần. khi có hàm wait ta sẽ chịu ảnh hưởng của hàm wait nếu wait = 30 giây
thì nó sẽ tìm element 60 lần, khi hông tìm dduocj thì fail, còn tìm dược thì qua step mới (cơ chế của waitExplicit)
+ Sự khác nhau giữa findElement và findElements
- Với findElement: nếu k tìm thấy element thì đánh fail test case và bắn ra lỗi. Nếu tìm ra được 1 element thì tiếp tục thao tác
với element. Nếu tìm thấy nhiêu hơn 1 element thì nó sẽ luôn lấy xpath của thằng đầu tiên để thao tác.
- Với findElements: Nếu không tìm thấy element nào thì trả về 1 list rỗng và
 không đánh fail testcase (check k hiển thị ta chỉ cần findelements và check size bằng rỗng). Nếu tìm ra được 1 element và nhiều hơn
 1 element thì cũng tạo ra 1 list chứa các element.
 --> khi vào test fail để đổi giá trị timout bé đi ta se dùng cách sau:
 - driver.manage().timeouts().implicitlyWait(30, SECONDS); Nhận giá trị set cuối cùng nên ta có thể st timeout cho môi case
--> trước khi chuyển qua iframe khác ta cần về top windown
- Kiểm tra hình ảnh có được tài lên đúng không: Ta dùng javascrip để check
- flipbanner (có 1 ảnh trên và 1 icon dưới nên ta sẽ lấy ảnh ở trên nếu lấy icon sẽ không tìm thấy)
 */

    @Test
    public void TC_1() {
WebElement ppiframe = driver.findElement(By.xpath(""));
driver.switchTo().frame(ppiframe); // chuyển qua iframe thì mới thao tác với nó đươc
driver.switchTo().defaultContent(); // chuyển vể top windown (parent)



    }

}