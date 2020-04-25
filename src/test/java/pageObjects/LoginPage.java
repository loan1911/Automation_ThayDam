package pageObjects;

import common.AbstractPage;
import common.PageFactoryManager;
import interfaces.LoginPageUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    public void clickComboboxCompany() {
        waitForElementVisible(driver, LoginPageUI.COMBOBOX_COMPANY);
        sendkeyToElement(driver,LoginPageUI.COMBOBOX_COMPANY, "Chi nhánh 1" );
    }
    public TrangChuPage clickButtonLogin() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageFactoryManager.getTrangchuPage(driver);
    }
}
