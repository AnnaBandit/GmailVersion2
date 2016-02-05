package anya.pages;


import anya.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GmailPage extends BasePage {

    public GmailPage(WebDriver driver){
        super(driver);
    }

    public void ensureIsOpened(){
        if (!"GmailPage".equals(getDriver().getTitle())){
            getDriver().get("http://gmail.com");
        }
    }

    public void login(String userName, String password) {
        $("#Email").sendKeys(userName + Keys.ENTER);
        $("#Passwd").sendKeys(password + Keys.ENTER);
    }
}
