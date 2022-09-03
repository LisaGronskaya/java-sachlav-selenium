package lesson_01_basic_selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {
    public static void main(String[] args) throws InterruptedException {
        //Initialisation of the required driver
        WebDriverManager.chromedriver().setup();

        //Initialization
        WebDriver driver = new ChromeDriver();

        //Maximize browser window
        driver.manage().window().fullscreen();

        //Open required url address
        driver.get("https://www.google.com/");

        //получить адрес страницы
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //получить исходный код страницы
        System.out.println("driver.getPageSource() = " + driver.getPageSource());

        //получить заголовок страницы
        System.out.println("driver.getTitle() = " + driver.getTitle());

        //переходим по новому адресу
        driver.navigate().to("https://en.wikipedia.org/wiki/Wiki");

        //переходим назад
        driver.navigate().back();

        //переходим вперед
        driver.navigate().forward();

        //обновляем окно
        driver.navigate().refresh();

        Thread.sleep(3000);

        //Close browser
        driver.close();
    }
}
