import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/* ctrl +space để gợi ý cho version trong file POM, nên chọn phiên bản mới nhất
- nhưng version anpha là chưa đang test chưa dùng
- Trong file có tiếng việt thì phải lưu với TUF-8 nếu không sẽ bị lôi font
*/

public class XpathCSS {
    WebDriver driver;
    @Before
    public void BeforeTest (){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hanh\\IdeaProjects\\AutomationThayDam\\.idea\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().window().maximize();
    }
    @After
    public void AfterTest(){
        driver.quit();
        driver.close();
    }
    /* Trong selenium có 8 loại locator
    - Phương thức findElement(By.) để tìm kiếm vị trí của locator
     */
    @Test
    public void Xpath() throws InterruptedException {
/* Cấu tạo của 1 element có 3 phần chính: tagName (thẻ HTML), attributeNam (id, class, type, name, email, title, value,...)
và attributeValue (là giá trị của các attributeName)
- Các loại Element: label, textbox, combobox, checkbox, radiobutton, button, linktext, selectbox, AreaText,Date Time Picke,
Menu, SubMenu, Slider, Image, Tooltip, Table, Icon, Video, TimeLine,...
- Nếu dùng findElement chỉ nhận kiểu giá trị là String
  driver.findElement(By.id());
  driver.findElement(By.name());
  driver.findElement(By.class());
  driver.findElement(By.cssSelector());
  driver.findElement(By.linkText());
  driver.findElement(By.partialLinkText());
  driver.findElement(By.tagName());
  driver.findElement(By.xpath());
 */
        driver.findElement(By.id("userame")).sendKeys("Công ty ABC"); // sendkeys là để nhập giá trị cho element.
        driver.findElement(By.id("userame")).clear(); // clear là xóa giá trị đã nhập
        driver.findElement(By.id("userame")).click(); // click chuột vào element
        driver.findElement(By.tagName("a")).getSize(); // Lấy ra số lượng của các thẻ a
        Thread.sleep(100); // sleep là để dững bao nhiêu giây, cái này phải có exception
    }
}
/* Để duplicated được các dòng code ta sẽ setup key như sau (trên eclip)
- Vào window --> Reference --> seach từ khóa Keys --> seach duplicate line (có thể bết được phím tắt hoặc sửa lại phím tắt đó)
==> Nếu sử dụng Xpath nó sẽ handle được 7 loại locator (tốc độ chậm), và Css có thể handle được 6 locator (tốc độ nhanh hơn Xpath)
*/
/* Cấu tạo của 1 Xpath Format: //tagName[@attribute=Value] --- //input[@id=1234].
- Cấu tạo 1 Xpath Type:
+ Absolute Xpath (Xpath tuyệt đối): là xpath đi từ thẻ HTML cho đến vị trí mình cần lấy
+ Relative Xpath (Xpath tương đối): Ta cần custom lại để xpath không bị sai khi thay đổi UI, nên lấy thuộc tính duy nhất
gần với locator
chú ý không nên dùng href vì sẽ bị thay đổi domain khi đổi môi trường chạy test
- các kỹ thuật lấy xpath
+ Lấy attribute nào có thể định danh dc đối tượng là duy nhất.
+ Dựa vào thẻ cha để định danh thẻ con mà không cần đến attribute nào của thẻ để định danh thẻ là duy nhất
//Xpathcha//Xpathcon (tìm thằng cha là duy nhất đê định danh thằng con là duy nhất )
+ Lấy Xpath bằng contains: //tagName[contains(@attribute,Value)] - chạy chậm vì lấy giá trị tương đối, phạm vi quét rộng hơn
+ Ta có thể thêm index vào hoạt code: //tagName[contains(@attribute,Value)][1]
+ Kỹ thuật contains[text()]: //tagName[contains(text(),'chuỗi cần tìm')]
+ Kỹ thuật text()=: //tagName[text()='chuỗi cần tìm')]
+ Kỹ thuật Start- with: //tagName[starts-with(text(),'chứa chuỗi cần tìm')] -- Bắt đầu bằng đoạn text
+ Kỹ thuật AND và OR: Kết hợp nhiều yêu cầu khác nhau: điều kiện 1 and điều kiện 2. Cả 2 điều phải đúng (2 điều kiện cùng 1 //thẻ)
+ Kỹ thuật Xpath AXES: Các từ khóa trong ký thuật này gồm có
-> ancestor (tổ tiên, tính từ ông chở đi)
->parent (cha)
-> preceding (Bác)
-> following (chú)
-> child (con)
-> preceding-sibling (anh của node hiện tại)
-> following-sibling (em của node hiện tại)
-> descendant (con cháu của lớp hiện tại)
Xpath/key phả hệ::tên thẻ cần lấy
+ Framework sẽ giúp sử lý được các element chỉ cần 1 xpath có thể click vào tất cả các element (dynamic- locator)
/* Không dùng tool hỗ trợ để bắt Xpath: Nhấn ctrl + F trên tab Element
- Để verify ( kiểm chứng) ta sang tab console: xpath ($x("truyền xpath"), Css $$("css") Jquery $("jquery")
- Chuyển 1 tip từ xpath sang Css: Nếu 1 element có định danh là duy nhất thì:
ID: #id
Class: .class (các chuỗi trong class sẽ bị ngăn cách bởi dấu " " nếu muốn lấy hết thì ta thay dấu cách bằng dấu "."
parent node: Thẻ chá > thẻ con
Xpath --> css, Bỏ // và @ trong xpath đi
Lưu ý: css không được dùng text, và nó chỉ đi được 1 note
 */
