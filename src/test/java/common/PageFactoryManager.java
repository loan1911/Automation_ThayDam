package common;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
public class PageFactoryManager {

        private static HomePage homePage;
        private static LoginPage loginPage;

        public static HomePage getHomePage(WebDriver driver){
//            if (homePage == null){
//                homePage = new HomePage(driver);
//            }
//            return homePage;
            return new HomePage(driver);
        }
        public static LoginPage getLoginPage(WebDriver driver){
//            if (loginPage == null){
//                loginPage = new LoginPage(driver);
//            }
//            return loginPage;
            return new LoginPage(driver);
        }
    }

