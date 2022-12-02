package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

public class SendKeyTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create5250();
    }

    @Test
    public void envioDeTeclasComoString(){
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        SendKey.sendKeyWithoutWait("tests");
        Assert.assertEquals("TESTS", GetString.getString(6, 53, 5));
        Close.session();
    }

    @Test
    public void envioDeTeclasPreEstrablecidas(){
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        PutString.putStringByLabel("TESTUSR", "User");
        PutString.putStringByLabel("TESTPSW", "Password");
        SendKey.sendKey(KeysScreen.ENTER);
        Assert.assertEquals("Select one of the following:", GetString.getString(3, 2, 28));
        Close.session();
    }

    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }
}