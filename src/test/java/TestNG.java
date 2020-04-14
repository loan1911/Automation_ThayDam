import org.junit.After;
import org.mockito.internal.matchers.Null;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG {
    WebDriver driver = null; // viết code xong rồi cài đặt trong testNG (xem video https://www.youtube.com/watch?v=WZfh6v53leA)
    WebDriverWait waitExplicit;


    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver.navigate().to("http://14.225.3.184:8081/#/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        waitExplicit = new WebDriverWait(driver, 15);
    }

    @After
    public void AfterTest() {
        driver.quit();
        driver.close();
    }

    /* 1. Automation testing level (Pyramid)
    --> Có 3 mức: Mức 1 là unit test (do developer - Mock/junit/TestNG); Mức 2 là API - Intergration test
    (Developer/tester- rest Assured/Postman ); Mức 3 là Acceptance test/E2E/functional UI (Selenium/Katalon)
    2. Automation testing framework:
    java: junit/mockito/ testNG
    c#: NUnit/xUnit/MStest
    js: Mocha/Jasmine/chai
    3. automation testing framework type: có 6 loại
    Linear Scripting Framework:
    Modular Testing Framework:
    Data-driven Framework:
    Keyword Driven Testing Framework:
    Hybrid Driven Testing Framework:
    Behavior Driven Development Testing Framework:
    ---> Sử dụng framework TestNG:
    bước 1 cài đặt plugin TestNG
    bước 2: Tạo class với TestNG
    Bước 3: Vào file testing.xml tạo các class cần chạy
    <class name="TestNG"/>
    <class name="SecondTest"/>
mô hình chạy theo anotations:
Run beforesuite
    Run beforetest
        Run beforeclass
            Run beforemethod
                Run testcase1
            Run Aftermethod

            Run beforemethod
                Run testcase2
            Run Aftermethod
        Rung Afterclass
    Run Aftertest
Run Aftersuite
2. Chức năng group là chạy các test có cùng tên
- Thứ tự ưu tiên chạy, nhưng hạn chế không dùng cái này. số lượng test nhiều sẽ không đánh thứ tự như thế này,
 ta sẽ dùng tính năng sắp xếp của TestNC là đặt tên test case theo anphabet và chạy theo anphabet
- enabled: set xem có chạy test case nào hay k chạy test nào (chức năng này là skip và ít dùng)
- Data provider
- Chạy testcase trên các trình duyệt khác nhau: mình sẽ config trong testNG.xml
- Thread count: set bao nhiêu testcase chạy cùng lúc (chạy parallel)
- Invacationcount: set số lần chạy test
- chạy theo testsuite
- run theo package
- anotation DepenOnmethod (khi test 01 pass mới chạy test02- để tiết kiệm thơi gian khi chạy các test liên quan tới nhau)
- Listener: retry lại test khi nó bị false, extendreport,...
     */
    @Test(priority = 1, enabled = false, dataProvider = "Datainfo")
    public void TC01_TestNG() {
        System.out.println("Hanhsuki");

    }
    @DataProvider
    public Object [][] Datainfo(){
        return new Object [][]{
            {"hkk","ghgh"},
            {"jhk","fhgh"}};
        };
    }
