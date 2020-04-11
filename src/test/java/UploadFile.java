import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class UploadFile {
    WebDriver driver;
    String rootFolder = System.getProperty("user.dir"); // Get ra path của foder đang đứng
    String fileName01 = "file1.png"; // khai báo tên file
    String fileName02 = "IMG_1404.JPG";
    String filePath01 = rootFolder + "\\Data" + fileName01; // lấy đường dẫn file
    String filePath02 = rootFolder + "\\Data" + fileName02;
    String [] file = {filePath01, filePath02};

    @Before
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println(rootFolder);
    }
    @After
    public void AfterTest() {
        driver.quit();
        driver.close();
    }

    @Test
/* Các cách để upload file:
- upload (open file dialog) là do hệ điều hành (windown- desktopapp) quản lý, các upload file sẽ có HTML là thẻ Input với type ='2'
- Selenium chỉ làm việc với web app, để handle được file thì ta sẽ dùng hàm sendkey để truyền path của file vào.
- TH upload file không có thẻ input ta sẽ dùng thư viện từ bên thứ 3 như sau:
+ Third party tool: có thể chạy cho cả web và desktop app và mobile app. nhưng lại chỉ làm việc (build) trên windows
+ Thư viện của java (thư viện robot): Giả lập lại hành động là copy, patse: Click vào upload file để hiển thị open file dialog
sau đó ctrl + v path vào, và giả lập enter
+ Sikuli: có thể chạy cho cả web và desktop app và mobile app. nhưng lại chỉ làm việc (build) trên windows,
và nó sẽ tao tác với element theo hình ảnh. do thao tác với ảnh nên chạy trên các máy khác nhau độ phân giải khác nhau sẽ bị lỗi
nên thư viện này ít được dùng
*/
// upload file bằng hàm sendkeys (có thể upload multi file) - Tạo 1 file để chứa các file hoặc ảnh cần upload (file Data)
    public void TC_1UpLoadFile() {
     /*   WebElement uploadfile = driver.findElement(By.xpath(" "));  lưu ý khi load 1 ảnh nào đó có khả năng DOM nó sẽ bị thay đổi
        vì selenium khi tìm thấy element rồi nó sẽ lưu lại trong catch để dùng lại, dẫn đến co thể làm lỗi test. Để giải quyết vấn đề này
        ta sẽ cho các element và 1 cái mảng và dùng vòng for để upload lại khi dùng*/
        for (String files: file){
            WebElement uploadfile = driver.findElement(By.xpath(" "));
            uploadfile.sendKeys(files);
            uploadfile.sendKeys(filePath01 + "\n" + filePath02 + "\n"); // upload nhiều file cùng lúc
            uploadfile.sendKeys(filePath01); // upload từng file
            uploadfile.sendKeys(filePath02);
        }
    }
    // dùng upload file của auto java
    @Test
    public void uploadAutoIT () {
        //download autoitscript
    }


}