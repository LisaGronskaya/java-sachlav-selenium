package lesson_02_webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanVanAppsForgotPassword {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://prd.canvusapps.com/password_resets/new");

        String h3Text = driver.findElement(By.cssSelector("h3")).getText();
        if (h3Text.equals("Forgot Your Password")) {

            driver.findElement(By.id("email")).sendKeys("ak@gmail.com");
            driver.findElement(By.id("email")).sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            String url = driver.getCurrentUrl();
            if (url.equals("https://prd.canvusapps.com/login")) {
//                String message = driver.findElement(By.cssSelector("[class=\"alert alert-notice alert-block notice\"]")).getText();
                if (driver.findElement(By.cssSelector("[class=\"alert alert-notice alert-block notice\"]")).getText().equals("Email sent with password reset instructions.")) {
                    System.out.println("Message is correct");
                }

            }

        }

        Thread.sleep(3000);
        driver.quit();
    }
}