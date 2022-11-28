package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import org.junit.*;

public class SendKeyTest {

    @Test
    public void envioDeTeclasComoString(){
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        SendKey.sendKeyWithoutWait("test");
        Assert.assertEquals("test", GetString.getString(24, 1, 4));
        Close.session();
    }

    @Test
    public void envioDeTeclasPreEstrablecidas(){
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        SendKey.sendKeyWithoutWait("TSO");
        SendKey.sendKey(KeysScreen.ENTER);
        Assert.assertEquals("ENTER USERID", GetString.getString(1, 12, 12));
        Close.session();
    }

}