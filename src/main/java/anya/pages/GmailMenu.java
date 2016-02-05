package anya.pages;

import static anya.core.ConsiseAPI.$;

public class GmailMenu {

    public static void openInbox(){
        $("a[aria-label^='Inbox']").click();
    }

    public static void openSent(){
        $("a[title='Sent Mail']").click();
    }
}
