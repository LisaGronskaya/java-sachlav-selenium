package lesson_02_webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanVusApps {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://prd.canvusapps.com/signup");

        driver.findElement(By.id("user_name")).sendKeys("Lisa Gronskaya");
        driver.findElement(By.cssSelector("[id=\"user_email\"]")).sendKeys("gronskaja-liza@inbox.ru");
        driver.findElement(By.cssSelector("#user_password")).sendKeys("qwerty12345");

        String valueAttribute = driver.findElement(By.cssSelector(".submit.btn.btn-primary")).getAttribute("value");
        if (valueAttribute.equals("Sign up")) {
            driver.findElement(By.cssSelector(".submit.btn.btn-primary")).click();
        }

        String errorText = driver.findElement(By.cssSelector("[class=\"alert alert-error alert-block error\"]")).getText();
        if (errorText.contains("We couldn't set up that account, sorry. Please try again, or contact an admin (link is above).")) {
            System.out.println("Message is correct");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}