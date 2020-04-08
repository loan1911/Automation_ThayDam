import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
/* ctrl +space để gợi ý cho version trong file POM, nên chọn phiên bản mới nhất
- nhưng version anpha là chưa đang test chưa dùng
- Trong file có tiếng việt thì phải lưu với TUF-8 nếu không sẽ bị lôi font
- Trong Xpath có thẻ ghi tagname hoặc không, nếu không ghi tagname thì sẽ thay bằng kí tự "*" đại diện cho tất cả các tagname
*/

public class XpathCSS {
    WebDriver driver; // khai báo một biến để dùng được các API của WebDriver
    @Before
    public void BeforeTest (){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hanh\\IdeaProjects\\AutomationThayDam\\.idea\\drivers\\chromedriver.exe"); //set đường dẫn đến webDriver
        driver = new ChromeDriver(); // Khởi tạo trình duyệt
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().window().maximize();
    }
    @After
    public void AfterTest(){
        driver.quit();
        driver.close();
    }


    @Test
    public void Xpath()  {
        /* WebDriver - Những API dùng với trình duyệt
- Tất cả các API có đuôi là webDriver thông qua biến driver.
*/
        driver.get("url"); // mở 1 trình duyệt lên - Kiểu dữ liệu trả về là không cần trả về
        driver.getCurrentUrl(); // Trả về URL hiện tại (khi có kiểu trả về thì khai báo biến để lưu các dữ liệu)
        driver.getPageSource(); // lấy ra HTML của page hiện tại
        driver.getTitle(); //lấy ra title của page hiện tại
        driver.getWindowHandle();
        driver.getWindowHandles();
        driver.close(); // đóng trình duyệt (đóng tab đang đứng)
        driver.quit(); // đóng trình duyệt (đóng tất cả các tab trên trình duyệt)
        driver.manage(); // những api có optiom phía sau là những hàm đi theo sau api manage. (quản lý)
//        driver.manage().timeouts().implicitlyWait("1000",TimeUnit.MICROSECONDS) -- timeout cho element và thường có exception
        driver.manage().timeouts().pageLoadTimeout(10000,SECONDS); // timeout để oad page
        driver.manage().timeouts().setScriptTimeout(10000,SECONDS); // inject đoạn code jS/jquery vào brower
        driver.navigate().back(); // Back về page trước đó
        driver.navigate().forward(); // chuyển tiếp sang page tiếp theo
        driver.navigate().refresh(); // f5 page
        driver.navigate().to("URL"); // Mở 1 trình duyệt (tracking để save history)
        driver.switchTo().alert(); // để handle cho element
        driver.switchTo().frame("i"); // để handle frame và iframe
// WebElement: có 2 cách tương tác trực tiếp thông qua findElement/findElements (sử dụng các locator nhưng chỉ dùng được 1 step),
        driver.findElement(By.xpath("dhfdjh")).click();
// Tương tác gián tiếp (dùng được nhiều step) - Khởi tạo 1 webelement,
        WebElement emailTexbox = driver.findElement(By.xpath("dgdgjg"));
        emailTexbox.sendKeys(); // nhập text
        emailTexbox.clear(); // Xóa dữ liệu cũ trước khi thao tác (luôn đi cùng sendkeys)
        emailTexbox.click(); // click vào emlement
        emailTexbox.getAttribute(""); // Lấy attribute của những gợi ý ẩn không có text trong element
        emailTexbox.getCssValue(""); // get ra giá trị của Css (các thuộc tính của css, ví dụ như màu backgroud - cái này ở stype)
        emailTexbox.getLocation(); // Lấy ra vị trí tọa độ của element
        emailTexbox.getSize(); // lấy ra chiều rộng và chiều cao của element
        emailTexbox.getTagName(); // lấy ra tên thẻ HTML
        emailTexbox.getText(); //Get ra text nằm trong element
        emailTexbox.isDisplayed(); // kiểm tra element có hiển thị không trả về kiểu giá trị boolean, khi element hiện thì chạy tiếp luôn
        emailTexbox.isEnabled(); // Kiểm tra xem element có thao tác được hay không
        emailTexbox.isSelected(); // Kiểm tra xem element đã được chọn hay chưa (dùng cho radiobutton và checkbox)
        emailTexbox.submit(); // Truyền 1 hành động vào form (login form, ... Nó giống như phím enter)

    }
    public int randomNumber(){ // hàm random
        Random random = new Random();
        int number = random.nextInt(5697);
        return number;

    }
    }