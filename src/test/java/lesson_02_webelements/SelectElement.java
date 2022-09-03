package lesson_02_webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElement {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.automation.co.il/tutorials/selenium/demo1/indexID.html");

        //About part
        driver.findElement(By.cssSelector("[id=\"firstname\"]")).sendKeys("Alex");
        driver.findElement(By.cssSelector("[id=\"lastname\"]")).sendKeys("Komanov");
        driver.findElement(By.cssSelector("[id=\"email\"]")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("[id=\"next\"]")).click();

        Thread.sleep(2000);

        //Account part
        driver.findElement(By.cssSelector("[id=\"Beginner\"]")).click();
        driver.findElement(By.cssSelector("[id=\"next\"]")).click();
        Thread.sleep(2000);

        //Address part
        typeText(driver.findElement(By.cssSelector("[id=\"streetname\"]")), "Street name");
        typeText(driver.findElement(By.cssSelector("[id=\"streetnumber\"]")), "15");
        typeText(driver.findElement(By.cssSelector("[id=\"city\"]")), "Karmiel");


        //Select handling
        WebElement selectElement = driver.findElement(By.cssSelector("[id=\"country\"]"));
        Select select = new Select(selectElement);

        select.selectByIndex(4);
        Thread.sleep(3000);
        select.selectByValue("Albania");
        Thread.sleep(3000);
        select.selectByVisibleText("Israel");
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();

        Thread.sleep(2000);
        driver.quit();
    }

    public static void typeText(WebElement element, String text) {
        element.clear();
        element.click();
        element.sendKeys(text);
    }
}