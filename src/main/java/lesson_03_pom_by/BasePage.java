package lesson_03_pom_by;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 60);
    }

    public void initAndNavigate(String url) {
        driver.manage().window().maximize();
        driver.get(url);
//        sleep(3000);
    }

    protected void fillText(WebElement element, String text) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected String getElementText(WebElement element) {
        //waiter
        return element.getText();
    }

    public void sleep(int mils) {
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}