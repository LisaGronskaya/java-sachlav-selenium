package lesson_03_pom_by;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private WebElement usernameInput = driver.findElement(By.cssSelector("[id=\"user-name\"]"));
    private WebElement passwordInput = driver.findElement(By.cssSelector("[id=\"password\"]"));
    private WebElement loginButton = driver.findElement(By.cssSelector("[id=\"login-button\"]"));


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToApp(String username, String password){
        fillText(usernameInput, username);
        fillText(passwordInput, password);
        clickElement(loginButton);
    }

}