package lesson_02_webelements.frst_hw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW_01_While {
    //    @Test
//    public void test_01() {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        driver.findElement(By.cssSelector("[id=\"twotabsearchtextbox\"]")).sendKeys("tents");
        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> tents = driver.findElements(By.cssSelector("[class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        System.out.println(tents);

        driver.close();
    }
}

//найти элементы, запихать в эрейлист
//найти элемент переключающий страницы
//найти элемент номер страницы
//цикл: пока номер страницы < 11, выводить на печать содержимое эрей листа?

// <a href="/s?k=tent&amp;page=2&amp;crid=1PELLPPQEHPNF&amp;qid=1659504368&amp;
// sprefix=tent%2Caps%2C421&amp;ref=sr_pg_1" aria-label="Go to next page, page 2" class="s-pagination-item s-pagination-next s-pagination-button s-pagination-separator">Next<svg xmlns="http://www.w3.org/2000/svg" width="8" height="12" viewBox="0 0 8 12" focusable="false" aria-hidden="true"><path d="M2.126.35a1.28 1.28 0 00-1.761 0 1.165 1.165 0 000 1.695L4.478 6 .365 9.955a1.165 1.165 0 000 1.694 1.28 1.28 0 001.76 0L8 6 2.126.35z"></path></svg></a>