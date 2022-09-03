package lesson_04_testing;

import org.junit.Test;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestFlow {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test
    public void test_01(Method method) {
        System.out.println(method.getName());
    }

    @Test
    public void test_02(Method method) {
        System.out.println(method.getName());
    }

    @Test
    public void test_03(Method method) {
        System.out.println(method.getName());
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}