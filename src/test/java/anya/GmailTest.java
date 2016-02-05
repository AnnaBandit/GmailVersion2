package anya;

import anya.testData.Authentication;
import anya.testconfigs.BaseTest;
import org.junit.Test;

import static anya.core.CustomConditions.listNthElementHasText;
import static anya.core.CustomConditions.textsOf;
import static anya.core.Helpers.generateUniquePhrase;
import static anya.pages.GmailMailsPage.*;
import static anya.pages.GmailMenuPage.openSent;
import static anya.pages.GmailPage.ensureGmailIsOpened;
import static anya.pages.GmailPage.login;


public class GmailTest extends BaseTest {
    public String subject = generateUniquePhrase("Subject");

    @Test
    public void testLoginSendMailAndSearchLetter() {
        ensureGmailIsOpened();
        login(Authentication.userName, Authentication.password);

        send(Authentication.userName, subject);
        assertThat(visible(emailIsSentMessage));
        refresh();
        assertThat(listNthElementHasText(list, 0, subject));

        openSent();
        assertThat(listNthElementHasText(list, 0, subject));
        searchBySubject(subject);
        assertThat(textsOf(list, subject), 10);
    }
}