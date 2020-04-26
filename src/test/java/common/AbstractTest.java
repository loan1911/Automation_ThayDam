/*Đây chính là facetory Pattern: gom các loại vào 1 class để quản lý
*/

package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    private WebDriver driver;
    protected WebDriver openMultiBrowser(String browserName) {
        if (browserName.contains("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("chromeheadless")) {
            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1366x768");
            driver = new ChromeDriver(options);
        }
        driver.navigate().to(Constants.TEST_URL);
        driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

}
