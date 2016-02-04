package anya;

import anya.testconfigs.BaseTest;
import org.junit.Test;
import anya.core.Configuration;
import anya.pages.GmailMailsPage;
import anya.pages.GmailMenuPage;
import anya.pages.GmailPage;
import anya.testData.Authentication;

import static anya.core.CustomConditions.textsOf;
import static anya.core.SeleniumHelpers.assertThat;
import static anya.core.CustomConditions.listNthElementHasText;
import static anya.core.Helpers.generateUniquePhrase;
import static anya.core.SeleniumHelpers.$;


public class GmailTest extends BaseTest {
    {
        Configuration.timeout = 4;
    }

    public String subject = generateUniquePhrase("Subject");

    GmailPage gmail = new GmailPage(driver);
    GmailMailsPage mails = new GmailMailsPage(driver);
    GmailMenuPage menu = new GmailMenuPage(driver);

    @Test
    public void testLoginSendMailAndSearchLetter() {
        gmail.ensureIsOpened();
        gmail.login(Authentication.userName, Authentication.password);

        mails.send(Authentication.userName, subject);
        $(mails.emailIsSentMessage, driver);
        mails.refresh();
        assertThat(listNthElementHasText(mails.list, 0, subject), driver);

        menu.openSent();
        assertThat(listNthElementHasText(mails.list, 0, subject), driver);
        mails.searchBySubject(subject);
        assertThat(textsOf(mails.list, subject), driver, 10);
    }
}