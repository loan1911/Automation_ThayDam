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


public class HandleDefaultDropDownCustomDropDown {
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
/* Có 2 loại dropdown list: loại default và loại đã được custom
single page application là công nghệ sư lý luôn trên client mà không cần đến server (angular/vueJS, react,..), những công nghệ này
thường sử dụng Ajax là cho phép xử lý và hiển thị kết quả trực tiếp trên cliend luôn.
- Cách phân biệt dropdown thường và dropdown đã được custom: dropdown thường sẽ gồm thẻ select và các thẻ option bên trong
+ Với default dropdownlist selenium đã có API để handle
- WebElement là thư viện khai báo và thao tác với element
- Select(webdriver) là thư viện để handle dropdown, khởi tạo thư viện với tham số truyền vào là 1 webElement
*/
        WebElement dropdown = driver.findElement(By.xpath(""));
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.getAllSelectedOptions(); // trả về tất cả các item đã chọn.
        dropdownSelect.getFirstSelectedOption().getText();// Trả ra giá trị đã được chọn
        dropdownSelect.getOptions().size(); // trả ra số lượng của các option trong dropdown
        dropdownSelect.isMultiple(); // trả về kiểu boolean, kiểm tra xem có hỗ trợ multi select không
        dropdownSelect.selectByVisibleText(""); // truyền vào text của dropdown, theo giá trị của item, nên dùng cái này
        dropdownSelect.selectByIndex(1); // lấy giá trị trong drop theo index
        dropdownSelect.deselectByValue(""); // lấy giá trị trong drop theo value
    }

    /* custom dropdown cần viêt hàm để chọn dropdown
    - Điểm chung của các loại custom là điều có thẻ cha bên ngoài để mình click vào dropdown
    */
    public void customDropDown(String ParentXpath, String allItemXpath, String valueItem) { // parent là biến đển click vào dropdown
// allitemxpath là xpath chứa tất cả các giá trị trong dropdown
        WebElement dropdown = driver.findElement(By.xpath(""));
        dropdown.click();
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath))); // chờ trong 30 cho tất cả các item xuất hiện
        List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getText().equals(valueItem)){
// Scroll dropdown
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",allItems.get(i));
                allItems.get(i).click();
                break;
            }
        }
// Cách viết vòng lặp for -each
        for (WebElement childElement: allItems){
            if(childElement.getText().equals(valueItem)){
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",childElement);
                childElement.click();
                break;
            }
        }

    }

}