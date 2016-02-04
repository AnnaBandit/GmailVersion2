package anya.pages;

import anya.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static anya.core.SeleniumHelpers.$;
import static anya.core.SeleniumHelpers.byText;

public class GmailMailsPage extends BasePage {
    @FindBy(css = "[role='main'] .UI tr")
    public List<WebElement> list;

    @FindBy(className="vh")
    public WebElement emailIsSentMessage;

    public GmailMailsPage(WebDriver driver){
        super(driver);
    }

    public void send(String to, String subj) {
        $(byText("COMPOSE"), driver).click();
        $(By.name("to"), driver).sendKeys(to + Keys.ENTER);
        $(By.name("subjectbox"), driver).sendKeys(subj);
        $(byText("Send"), driver).click();
    }

    public void searchBySubject(String subject){
        $(By.name("q"), driver).clear();
        $(By.name("q"), driver).sendKeys("subject:" + subject + Keys.ENTER);
    }

    public void refresh(){
        $(By.xpath(".//*[@title=\"Refresh\"]"), driver).click();
    }
}