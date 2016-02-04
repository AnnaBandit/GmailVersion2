package anya.pages;

import anya.core.BasePage;
import org.openqa.selenium.WebDriver;

import static anya.core.SeleniumHelpers.$;
import static anya.core.SeleniumHelpers.byCss;

public class GmailMenuPage extends BasePage {

    public GmailMenuPage(WebDriver driver){
        super(driver);
    }

    public void openInbox(){
        $(byCss("a[aria-label^='Inbox']"), driver).click();
    }

    public void openSent(){
        $(byCss("a[title='Sent Mail']"), driver).click();
    }
}
