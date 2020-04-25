package common;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageFactoryManager {

    public static HomePage getHomePage(WebDriver driver) {

        return new HomePage(driver);
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public static TrangChuPage getTrangchuPage(WebDriver driver) {
        return new TrangChuPage(driver);
    }
    public static PhieuThuPage getPhieuThuPage(WebDriver driver) {
        return new PhieuThuPage(driver);
    }
    public static BaoNoPage getBaoNoPage(WebDriver driver) {
        return new BaoNoPage(driver);
    }
}
