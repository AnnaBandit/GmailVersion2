package anya.pages;


import anya.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static anya.core.SeleniumHelpers.$;

public class GmailPage extends BasePage {

    public GmailPage(WebDriver driver){
        super(driver);
    }

    public void ensureIsOpened(){
        if (!"GmailPage".equals(driver.getTitle())){
            driver.get("http://gmail.com");
        }
    }

    public void login(String userName, String password) {
        $("#Email", driver).sendKeys(userName + Keys.ENTER);
        $("#Passwd", driver).sendKeys(password + Keys.ENTER);
    }
}
