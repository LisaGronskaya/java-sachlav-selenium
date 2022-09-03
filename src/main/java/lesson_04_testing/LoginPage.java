package lesson_04_testing;

import lesson_03_pom_by.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(css = "[id='password']")
    private WebElement passwordInput;
    @FindBy(css = "[id=\"login-button\"]")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToApp(String username, String password){
        fillText(usernameInput, username);
        fillText(passwordInput, password);
        clickElement(loginButton);
    }

}