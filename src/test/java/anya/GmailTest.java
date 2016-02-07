package anya;

import anya.testData.Authentication;
import anya.testconfigs.BaseTest;
import org.junit.Test;

import static anya.core.ConsiseAPI.assertThat;
import static anya.core.ConsiseAPI.visible;
import static anya.core.CustomConditions.listNthElementHasText;
import static anya.core.CustomConditions.textsOf;
import static anya.core.Helpers.generateUniquePhrase;
import static anya.pages.Mails.*;
import static anya.pages.Menu.openSent;
import static anya.pages.Gmail.ensureGmailIsOpened;
import static anya.pages.Gmail.login;


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