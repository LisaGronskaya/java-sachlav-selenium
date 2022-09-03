package lesson_04_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    WebElement title;

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
