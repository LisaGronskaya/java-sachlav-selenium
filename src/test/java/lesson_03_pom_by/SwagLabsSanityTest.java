package lesson_03_pom_by;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SwagLabsSanityTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        /**
         * Login Page Elements    ***********8*******************
         */

        /**
         * TODO - Decomposition to separated classes
         */

        By usernameInput = By.cssSelector("[id=\"user-name\"]");
        By passwordInput = By.cssSelector("[id=\"password\"]");
        By loginButton = By.cssSelector("[id=\"login-button\"]");

        WebElement usernameElement = driver.findElement(usernameInput);
        usernameElement.sendKeys("standard_user");

        driver.findElement(passwordInput).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
        Thread.sleep(3000);

        /**
         * Products Page Elements    ******************************
         */

        By productsTitle = By.cssSelector("[class=\"title\"]");
        By itemDescription = By.cssSelector("[class=\"inventory_item_description\"]");
        By inventoryItemName = By.cssSelector("[class=\"inventory_item_name\"]");
        By addToCartButton = By.cssSelector("button");
        By shoppingCartBadge = By.cssSelector("[class=\"shopping_cart_badge\"]");

        String productsTitleText = driver.findElement(productsTitle).getText();
        if (productsTitleText.equalsIgnoreCase("Products")) {
            System.out.println("Page Products");
        }
        else {
            System.out.println("Incorrect Page");
        }

        List<WebElement> itemCards = driver.findElements(itemDescription);

        /**
         * TODO - Extract to particular method with params
         */

        for (WebElement card : itemCards) {
            if (card.findElement(inventoryItemName).getText().equals("Sauce Labs Backpack")) {
                card.findElement(addToCartButton).click();
                break;
            }
        }

        for (WebElement card : itemCards) {
            if (card.findElement(inventoryItemName).getText().equals("Test.allTheThings() T-Shirt (Red)")) {
                card.findElement(addToCartButton).click();
                break;
            }
        }

        WebElement cartBadge = driver.findElement(shoppingCartBadge);

        if (cartBadge.getText().equals("2")) {
            System.out.println("Items counter is correct");
        }
        else {
            System.out.println("Items counter is incorrect");
        }

        cartBadge.click();
        Thread.sleep(1000);


        /**
         * Your Cart Page Elements    ******************************
         */

        By yourCartTitle = By.cssSelector("[class=\"title\"]");

        if (driver.findElement(yourCartTitle).getText().equalsIgnoreCase("Your Cart")) {
            System.out.println("Your Cart Page");
        }
        else {
            System.out.println("Wrong Page");
        }


        /**
         * TODO - Change Thread.sleep with Wait
         */
        Thread.sleep(3000);

        driver.quit();
    }
}
