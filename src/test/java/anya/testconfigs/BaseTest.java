package anya.testconfigs;

import anya.core.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import static anya.core.ConsiseAPI.getDriver;
import static anya.core.ConsiseAPI.setDriver;

public class BaseTest {
    {
        Configuration.timeout = 10;
    }

    @BeforeClass
    public static void setUp(){
        setDriver(new FirefoxDriver());
    }

    @AfterClass
    public static void tearDown(){
        getDriver().quit();
    }

}
