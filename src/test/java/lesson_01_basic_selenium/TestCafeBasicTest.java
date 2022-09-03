package lesson_01_basic_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCafeBasicTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://devexpress.github.io/testcafe/example/");

//        driver.findElement(By.id("developer-name"));
//        driver.findElement(By.cssSelector("[id=\"developer-name\"]"));
        String myName = "Lisa Gronskaya";
        driver.findElement(By.id("developer-name")).sendKeys(myName);

        driver.findElement(By.name("re-using")).click();
        driver.findElement(By.name("tried-test-cafe")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id=\"comments\"]")).sendKeys("Something to write here");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id=\"comments\"]")).clear();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[data-testid=\"submit-button\"]")).click();

        Thread.sleep(1000);
        String title = driver.findElement(By.cssSelector("[data-testid=\"thank-you-header\"]")).getText();
        if(title.contains(myName)) {
            System.out.println("Title is correct");
        }

        else {
            System.out.println("Title is WRONG");
        }

        String thankYouUrl = "https://devexpress.github.io/testcafe/example/thank-you.html";
        String url = driver.getCurrentUrl();

        if(url.equals(thankYouUrl)) {
            System.out.println("Url is correct");
        }

        else {
            System.out.println("Url is WRONG");
        }

        Thread.sleep(1000);
        driver.quit();

    }
}