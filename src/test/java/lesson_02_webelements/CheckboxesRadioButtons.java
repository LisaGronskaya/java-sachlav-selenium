package lesson_02_webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxesRadioButtons {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://devexpress.github.io/testcafe/example/");

        WebElement remoteTestingCheckbox = driver.findElement(By.cssSelector("[id=\"remote-testing\"]"));

        System.out.println("remoteTestingCheckbox.isDisplayed() = " + remoteTestingCheckbox.isDisplayed());
        System.out.println("remoteTestingCheckbox.isSelected() = " + remoteTestingCheckbox.isSelected());

        remoteTestingCheckbox.click();

        System.out.println("remoteTestingCheckbox.isSelected() = " + remoteTestingCheckbox.isSelected());

        List<WebElement> osButtons = driver.findElements(By.cssSelector("[name=\"os\"]"));
        osButtons.forEach(button -> System.out.println(button.isSelected()));

        for (WebElement osButton : osButtons) {
            if (osButton.getAttribute("value").equals("MacOS")) {
                osButton.click();
            }
        }

        osButtons.forEach(button -> System.out.println(button.isSelected()));

        Thread.sleep(3000);

        driver.quit();
    }
}