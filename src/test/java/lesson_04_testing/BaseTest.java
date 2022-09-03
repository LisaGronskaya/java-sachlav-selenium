package lesson_04_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.util.List;
import java.util.Set;

public abstract class BaseTest {

    protected WebDriver driver = new WebDriver() {
        @Override
        public void get(String s) {

        }

        @Override
        public String getCurrentUrl() {
            return null;
        }

        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public List<WebElement> findElements(By by) {
            return null;
        }

        @Override
        public WebElement findElement(By by) {
            return null;
        }

        @Override
        public String getPageSource() {
            return null;
        }

        @Override
        public void close() {

        }

        @Override
        public void quit() {

        }

        @Override
        public Set<String> getWindowHandles() {
            return null;
        }

        @Override
        public String getWindowHandle() {
            return null;
        }

        @Override
        public TargetLocator switchTo() {
            return null;
        }

        @Override
        public Navigation navigate() {
            return null;
        }

        @Override
        public Options manage() {
            return null;
        }
    };

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
