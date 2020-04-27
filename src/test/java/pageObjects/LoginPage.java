/* check unDisplay: Dùng isDisplay: có trong dom nhưng không visible sẽ trả về fail
- Nếu không có trong dom thì ta phải dùng findElements và size =0
*/

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
