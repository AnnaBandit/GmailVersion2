package anya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static anya.core.ConsiseAPI.*;

public class GmailMailsPage{
    public static By list = byCss("[role='main'] .UI tr");
    public static By emailIsSentMessage = By.className("vh");

    public static void send(String to, String subj) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(to + Keys.ENTER);
        $(By.name("subjectbox")).sendKeys(subj);
        $(byText("Send")).click();
    }

    public static void searchBySubject(String subject){
        $(By.name("q")).clear();
        $(By.name("q")).sendKeys("subject:" + subject + Keys.ENTER);
    }

    public static void refresh(){
        $(By.xpath(".//*[@title=\"Refresh\"]")).click();
    }
}