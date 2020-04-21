/*contain là check tương đối, equals là check tuyệt đối, equalsIgnoreCase là không phân biệt hoa thường
- Nếu chạy nhều class (đa luồng sẽ không dùng được PageFactoryManager vì nó sẽ lấy GUID dùng cho trình duyệt khác dẫn đến bị
lỗi. (do GUID không bị hủy trong suốt quá trình chạy do nó là biến static), do đó ta phải return new luôn ở bên PageFactoryManager
- Nếu có nhiều class test ta sẽ cho phần chạy multi sang bên abstractTest, các class test sẽ kế thừa class AbtractTest
- Để map được driver giữa abstractTest và class test ta sẽ return driver ở abstractTest và get ra ở class test
*/

package feature;

import common.AbtractTest;
import common.PageFactoryManager;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class L5MultipleBrowserandParallelTesting extends AbtractTest {
    WebDriver driver = null;
    HomePage homePage;
    LoginPage loginPage;
    @Parameters("browserName")
    @BeforeTest
    public void BeforeTest(String browserName) {
        driver= openMultiBrowser(browserName);
        homePage = PageFactoryManager.getHomePage(driver);
    }
    @AfterTest
    public void AfterTest() {
        driver.close();
    }
    @Test
    public void TC_01_Login() {
        homePage.fieldUserName("admin");
        homePage.fieldPassword("admin");
        loginPage = homePage.clickButtonLogin();
        loginPage.fieldCompanyName("Chi nhánh 1");
        loginPage.clickButtonLogin();
    }

}