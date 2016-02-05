package anya.testconfigs;

import anya.core.Configuration;
import anya.core.ConsiseAPI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends ConsiseAPI{
    {
        Configuration.timeout = 10;
    }

    public static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        setDriver(new FirefoxDriver());
    }

    @AfterClass
    public static void tearDown(){
        getDriver().quit();
    }

}
