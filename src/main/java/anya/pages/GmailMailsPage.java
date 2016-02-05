package anya.pages;

import anya.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GmailMailsPage extends BasePage {
    public By list = byCss("[role='main'] .UI tr");
    public By emailIsSentMessage = By.className("vh");

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