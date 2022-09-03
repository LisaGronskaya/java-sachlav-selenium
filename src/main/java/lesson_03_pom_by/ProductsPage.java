package lesson_03_pom_by;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    WebElement title = driver.findElement(By.cssSelector("[class=\"title\"]"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void validateTitle(String text) {
        String titleText = getElementText(title);
        if (titleText.equalsIgnoreCase(text)) {
            System.out.println("Title is correct");
        }
        else {
            System.out.println("Title is incorrect");
        }
    }
}