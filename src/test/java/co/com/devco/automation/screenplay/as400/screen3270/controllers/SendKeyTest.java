package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

public class SendKeyTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create3270();
    }
    @Test
    public void envioDeTeclasComoString(){
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        SendKey.sendKeyWithoutWait("test");
        Assert.assertEquals("test", GetString.getString(1, 27, 4));
        Close.session();
    }

    @Test
    public void envioDeTeclasPreEstrablecidas(){
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        SendKey.sendKeyWithoutWait("testusr");
        SendKey.sendKey(KeysScreen.ENTER);
        Assert.assertEquals("TSO/E LOGON", GetString.getString(1, 33, 11));
        Close.session();
    }

    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }

}