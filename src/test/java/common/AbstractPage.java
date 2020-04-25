package common;

import interfaces.AbstractPageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BaoNoPage;
import pageObjects.PhieuThuPage;

import java.util.List;
import java.util.Set;

public class AbstractPage {
    WebElement element;
    List<WebElement> elements;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait waitExplicit; // dùng cho element
    Actions action;
    By by;
    Long shortTimeout = Long.valueOf(5);
    Long longTimeout = Long.valueOf(30);

    // các hàm với WebBrower
    public void openAnyUrl(WebDriver driver, String URL) { // luôn luôn truyền tham số Webdriver
        driver.get(URL);
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPreviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void forwardToNextPage(WebDriver driver) {

        driver.navigate().forward();
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getTextInAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendkeyTextToAlert(WebDriver driver) {
        driver.switchTo().alert().sendKeys("Hanh");
    }

    // các hàm với WebElement
    public void clickToElement(WebDriver driver, String locator) { // tham số mặc định với element là 2 tham số
        hightLightElement(driver,locator);
        element = driver.findElement(By.xpath(locator)); // khai báo WebElement
        element.click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String value) {
        hightLightElement(driver,locator);
        element = driver.findElement(By.xpath(locator));
        element.sendKeys(value);
    }

    public void selectItemInDropown(WebDriver driver, String locator, String value) {
        element = driver.findElement(By.xpath(locator));
        Select select = new Select(element); // Khởi tạo thư viện của dropdown loại default
        select.selectByVisibleText(value);
    }

    public String getSelectedItemDropdown(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public void selectItemCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath, String expectedValueItem) throws InterruptedException {
        waitExplicit = new WebDriverWait(driver, longTimeout);
        javascriptExecutor = (JavascriptExecutor) driver;
        WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
        javascriptExecutor.executeScript("arguments[0].click();", parentDropdown); // click vào dropdown
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath))); // chờ cho tất cả các element xuất hiện
        List<WebElement> allItem = driver.findElements(By.xpath(allItemXpath));
        for (WebElement childElement : allItem) {
            if (childElement.getText().contains(expectedValueItem)) {
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                Thread.sleep(1000);
            }
            if (childElement.isDisplayed()) {
                childElement.click(); // nếu nhìn thấy element thì click bằng selenium
            } else {
                javascriptExecutor.executeScript("argument[0].click();", childElement); // click bằng js
            }
            Thread.sleep(1000);
            break;
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        element = driver.findElement(By.xpath(locator));
        return element.getAttribute(attributeName);
    }

    public String getTextValue(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public int countElementNumber(WebDriver driver, String locator) {
        elements = driver.findElements(By.xpath(locator));
        return elements.size();
    }

    public void checkToCheckbox(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) { //Kiểm tra xem 1 element nào đó được chọn hay không
        element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isEnabled();
    }

    public void switchToChildWindownByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                break;
            }
        }
    }

    public void switchToChildWindowsByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(expectedTitle)) {
                break;
            }
        }
    }

    public boolean closeAllWithOutParentWindows(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(parentID);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
        if (driver.getWindowHandles().size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void switchToIframe(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        driver.switchTo().frame(element);
    }

    public void backToTopWindows(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void dragAnDrop(WebDriver driver, String locatorStart, String locatorEnd) {
        WebElement elementStart = driver.findElement(By.xpath(locatorStart));
        WebElement elementEnd = driver.findElement(By.xpath(locatorEnd));
        action = new Actions(driver);
        action.dragAndDrop(elementStart, elementEnd).perform();
    }

    public void keyPress(WebDriver driver, String locator, Keys key) {
        element = driver.findElement(By.xpath(locator));
        action = new Actions(driver);
        action.keyUp(element, key);
    }
    public void waitForElementPresence(WebDriver driver, String locator){
        waitExplicit = new WebDriverWait(driver, 30);
        by = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitForElementVisible(WebDriver driver, String locator){
        waitExplicit = new WebDriverWait(driver, longTimeout);
        by = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementClickable(WebDriver driver, String locator){
        waitExplicit = new WebDriverWait(driver, longTimeout);
        by = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitForElementInvisible(WebDriver driver, String locator){
        waitExplicit = new WebDriverWait(driver, longTimeout);
        by = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void waitForAlertPresence(WebDriver driver){
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.alertIsPresent());
    }
// Viết các hàm để mở ra các page đó
    public PhieuThuPage openOnPhieuThuPage(WebDriver driver){
        waitForElementVisible(driver, AbstractPageUI.TIEN_MAT_NGAN_HANG);
        if(isControlDisplayed(driver, AbstractPageUI.PHIEU_THU)){
            clickToElement(driver, AbstractPageUI.PHIEU_THU);
        }else {
            clickToElement(driver, AbstractPageUI.TIEN_MAT_NGAN_HANG);
            waitForElementVisible(driver, AbstractPageUI.PHIEU_THU);
            clickToElement(driver, AbstractPageUI.PHIEU_THU);
        }
        return PageFactoryManager.getPhieuThuPage(driver);
    }
    public BaoNoPage openOnBaoNoPage(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUI.TIEN_MAT_NGAN_HANG);
        if (isControlDisplayed(driver, AbstractPageUI.BAO_NO)) {
            clickToElement(driver, AbstractPageUI.BAO_NO);
        } else {
            clickToElement(driver, AbstractPageUI.TIEN_MAT_NGAN_HANG);
            waitForElementVisible(driver, AbstractPageUI.BAO_NO);
            clickToElement(driver, AbstractPageUI.BAO_NO);
        }
        return PageFactoryManager.getBaoNoPage(driver);
    }
// hight light Element dùng cho hàm wait, check displayed, click, sendkey, để cho khách hàng biết mình chuẩn bị thao tác với element nào
public void hightLightElement(WebDriver driver, String locator) {
    javascriptExecutor = (JavascriptExecutor) driver;
    element = driver.findElement(By.xpath(locator));
    String originalStyle = element.getAttribute("style");
    javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element,
            "style", "border:3px solid red;border - style:dashed;");
    try {
        Thread.sleep(800);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element,
            "style", originalStyle);
}
}
