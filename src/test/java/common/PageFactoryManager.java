package common;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
/*cho hết các page cần khởi tạo vào đây, vì nó là biến static nên class nào cũng có thể truy cập được trực tiếp bằng
 tên của class
 */
public class PageFactoryManager {
    private static HomePage homePage;
    private static LoginPage loginPage;

    public static HomePage getHomePage(WebDriver driver){
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }
    public static LoginPage getLoginPage(WebDriver driver){
        if (loginPage == null){
           loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}
