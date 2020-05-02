/*
- class decompiles để dịch ngược từ file.class sang file.java
- Equal check cho string được còn  == thì không check cho string được
*/

package common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    protected Log log;
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
    // contrucstor cho log. LogFactory có loginfo, log error,...
    protected AbstractTest() {
        log = LogFactory.getLog(getClass());
    }
    // verify true/fail/equal
    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition ) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {

        return checkEquals(actual, expected);
    }
}
