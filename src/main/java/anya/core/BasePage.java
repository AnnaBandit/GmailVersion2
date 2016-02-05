package anya.core;

import org.openqa.selenium.WebDriver;

public class BasePage extends ConsiseAPI{
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

}
