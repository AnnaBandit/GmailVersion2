package anya.testconfigs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import anya.core.Configuration;

public class BaseTest {
    {
        Configuration.timeout = 7;
    }

    public static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
