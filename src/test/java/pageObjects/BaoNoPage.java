package pageObjects;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BaoNoPage extends AbstractPage {
    private WebDriver driver;
    public BaoNoPage(WebDriver driver) {
        this.driver = driver;
    }
}