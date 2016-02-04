package anya.pages;

import anya.core.BasePage;
import org.openqa.selenium.WebDriver;

import static anya.core.SeleniumHelpers.$;

public class GmailMenuPage extends BasePage {

    public GmailMenuPage(WebDriver driver){
        super(driver);
    }

    public void openInbox(){
        $("a[aria-label^='Inbox']", driver).click();
    }

    public void openSent(){
        $("a[title='Sent Mail']", driver).click();
    }
}
