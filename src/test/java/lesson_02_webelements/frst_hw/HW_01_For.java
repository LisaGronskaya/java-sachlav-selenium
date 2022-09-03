package lesson_02_webelements.frst_hw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW_01_For {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebElement searchField = driver.findElement(By.cssSelector("[id=\"twotabsearchtextbox\"]"));
        searchField.sendKeys("Tent");
        searchField.sendKeys(Keys.ENTER);

//        List<WebElement> products = driver.findElements(By.cssSelector("[class=\"a-size-medium a-color-base a-text-normal\"]"));
//        products.forEach(product -> System.out.println("page" + product.getText()));
//        driver.findElement(By.cssSelector(".s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")).click();
//
////        WebElement numberOfPage = driver.findElement(By.cssSelector("[class=\"s-pagination-item s-pagination-selected\"] input"));
//        //        driver.findElement(By.cssSelector("[class=\"a-section a-text-center s-pagination-container\"]"));
//

        List<WebElement> tents = null;
        for (int i = 1 ; i <= 10; i++) {
            Thread.sleep(5000);
            tents = driver.findElements(By.cssSelector("h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-2>a>span"));
            System.out.println("Page " + i);
            tents.forEach(tent -> System.out.println(tent.getText()));
            driver.findElement(By.cssSelector(".s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")).click();

        }
        driver.close();
    }
}
//в лист все элементы названия продукта, в этом же листе. искат через файнд элементС
//..резалтс тайтл, дождись, а потом ищи