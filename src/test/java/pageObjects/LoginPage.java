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
        clickToElement(driver,LoginPageUI.COMBOBOX_COMPANY );
        clickToElement(driver,LoginPageUI.CLICK_COMPANY);
    }
    public TrangChuPage clickButtonLogin() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageFactoryManager.getTrangchuPage(driver);
    }
}
