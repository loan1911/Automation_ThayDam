package pageObjects;

import common.AbstractPage;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    public void fieldCompanyName(String companyValue) {
        waitForElementVisible(driver, LoginPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.COMPANY_NAME_TEXTBOX, companyValue);
    }
    public void clickButtonLogin() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
