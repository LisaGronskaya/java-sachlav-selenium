package lesson_02_webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class EbayProducts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        WebElement searchField = driver.findElement(By.cssSelector("[class=\"space-top\"] input"));
        searchField.clear();
        searchField.sendKeys("macbook");
        searchField.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        List<WebElement> products = driver.findElements(By.cssSelector("h3.lvtitle>a"));
        products.forEach(product -> System.out.println(product.getText()));

        products.get(2).click();

        Thread.sleep(1000);

        driver.quit();
    }
}
