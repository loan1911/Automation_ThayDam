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

public class HandleTexboxTexArea {
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
    public void TC_1 ()  {
        driver.findElement(By.xpath("")).sendKeys("fggjgjg\n gfgfg ");// Để xuống dòng khi nhập text ta dùng "\n"
/*khi tạo 1 thông tin nào đó, có những trường không được sửa, thì dữ liệu của nó sẽ nằm ở value. ta có thể dùng getAttribute"value")
- còn nếu như được edit thì mình gettext (dữ liệu sẽ nằm ở giữa thẻ đóng và thẻ mở)
- Nếu như thuộc tính disable mà remove đi mà sever vẫn nhận là sai (vì chưa check ở sever)
- Nếu text trong xpath đã có dấu " ' "thì ta phải đổi thành dấu  " " " nếu không sẽ bị sai xpath
Chúng ta có thể khởi tạo 1 element bằng cách sau;
By customerNameTextBox  = By.xpath("truyền Xpath vào");
- Áp dụng các kỹ thuật để tránh bị lỗi dữ liệu khi thay đổi UI, hoặc chỉnh sửa ít
- Sever trả về kieur date là yyyy/MM/dd : nên khi nhâp ngày ta sẽ nhập là định dạng như server hoặc viết hàm để convert lại

*/
    }
    }