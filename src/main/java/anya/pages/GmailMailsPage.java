package anya.pages;

import anya.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailMailsPage extends BasePage {
    @FindBy(css = "[role='main'] .UI tr")
    public List<WebElement> list;

    @FindBy(className="vh")
    public WebElement emailIsSentMessage;

    public GmailMailsPage(WebDriver driver){
        super(driver);
    }

    public void send(String to, String subj) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(to + Keys.ENTER);
        $(By.name("subjectbox")).sendKeys(subj);
        $(byText("Send")).click();
    }

    public void searchBySubject(String subject){
        $(By.name("q")).clear();
        $(By.name("q")).sendKeys("subject:" + subject + Keys.ENTER);
    }

    public void refresh(){
        $(By.xpath(".//*[@title=\"Refresh\"]")).click();
    }
}