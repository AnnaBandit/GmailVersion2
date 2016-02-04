package anya.pages;

import anya.core.BasePage;
import org.openqa.selenium.WebDriver;

public class GmailMenuPage extends BasePage {

    public GmailMenuPage(WebDriver driver){
        super(driver);
    }

    public void openInbox(){
        $("a[aria-label^='Inbox']").click();
    }

    public void openSent(){
        $("a[title='Sent Mail']").click();
    }
}
