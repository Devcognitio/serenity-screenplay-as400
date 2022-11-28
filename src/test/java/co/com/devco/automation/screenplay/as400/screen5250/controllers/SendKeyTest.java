package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import org.junit.*;

public class SendKeyTest {

    @Test
    public void envioDeTeclasComoString(){
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        SendKey.sendKeyWithoutWait("tests");
        Assert.assertEquals("TESTS", GetString.getString(5, 25, 5));
        Close.session();
    }

    @Test
    public void envioDeTeclasPreEstrablecidas(){
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        SendKey.sendKey(KeysScreen.ENTER);
        Assert.assertEquals("CPF1296", GetString.getString(24, 1, 7));
        Close.session();
    }

}