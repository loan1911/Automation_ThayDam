package pageObjects;

import common.AbstractPage;
import interfaces.LoginPageUI;
import interfaces.TrangChuPageUI;
import org.openqa.selenium.WebDriver;

public class TrangChuPage  extends AbstractPage {
        private WebDriver driver;
        public TrangChuPage(WebDriver driver) {
            this.driver = driver;
        }
    public void clickIconMenu() {
        waitForElementVisible(driver, TrangChuPageUI.ICON_MENU);
        clickToElement(driver, TrangChuPageUI.ICON_MENU);
    }

    }
