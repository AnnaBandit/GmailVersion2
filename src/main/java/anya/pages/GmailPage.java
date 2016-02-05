package anya.pages;


import org.openqa.selenium.Keys;

import static anya.core.ConsiseAPI.*;

public class GmailPage{

    public static void ensureGmailIsOpened(){
        if (!"GmailPage".equals(title())){
            open("http://gmail.com");
        }
    }

    public static void login(String userName, String password) {
        $("#Email").sendKeys(userName + Keys.ENTER);
        $("#Passwd").sendKeys(password + Keys.ENTER);
    }

}
