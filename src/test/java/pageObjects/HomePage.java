package pageObjects;

import common.AbstractPage;
import common.PageFactoryManager;
import interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void fieldUserName(String userValue) {
        waitForElementVisible(driver,HomePageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.USER_NAME_TEXTBOX, userValue);
    }

    public void fieldPassword(String passValue) {
        waitForElementVisible(driver,HomePageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.PASSWORD_TEXTBOX, passValue);
    }

    public LoginPage clickButtonLogin() {
        waitForElementVisible(driver,HomePageUI.BUTTON_LOGIN);
        clickToElement(driver, HomePageUI.BUTTON_LOGIN);
//        return new LoginPage(driver);
        return PageFactoryManager.getLoginPage(driver);

    }
}
