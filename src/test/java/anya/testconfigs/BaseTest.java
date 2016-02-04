package anya.testconfigs;

import anya.core.ConsiseAPI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import anya.core.Configuration;

public class BaseTest extends ConsiseAPI{
    {
        Configuration.timeout = 10;
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

    @Override
    public WebDriver getDriver(){
        return driver;
    }

}
