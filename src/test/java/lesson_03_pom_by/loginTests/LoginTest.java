package lesson_03_pom_by.loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson_03_pom_by.BasePage;
import lesson_03_pom_by.LoginPage;
import lesson_03_pom_by.ProductsPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void test_01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp("standard_user", "secret_sauce");

        BasePage basePage = new BasePage(driver);
        basePage.initAndNavigate("https://www.saucedemo.com/");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.validateTitle("Products");

        driver.quit();
    }
}