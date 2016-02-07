package anya;

import anya.pages.Gmail;
import anya.pages.Mails;
import anya.pages.Menu;
import anya.testData.Authentication;
import anya.testconfigs.BaseTest;
import org.junit.Test;

import static anya.core.ConsiseAPI.assertThat;
import static anya.core.CustomConditions.*;
import static anya.core.Helpers.generateUniquePhrase;
import static anya.pages.Mails.*;


public class GmailTest extends BaseTest {
    public String subject = generateUniquePhrase("Subject");

    @Test
    public void testLoginSendMailAndSearchLetter() {
        Gmail.ensureIsOpened();
        Gmail.login(Authentication.userName, Authentication.password);

        Mails.send(Authentication.userName, subject);
        assertThat(visible(Mails.emailIsSentMessage));
        Mails.refresh();
        assertThat(listNthElementHasText(Mails.list, 0, subject));

        Menu.openSent();
        assertThat(listNthElementHasText(Mails.list, 0, subject));
        Mails.searchBySubject(subject);
        assertThat(textsOf(Mails.list, subject), 10);
    }
}