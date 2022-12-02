package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

public class OpenSessionTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create3270();
    }

    @Test
    public void successfulConnectionToA3270Terminal(){
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertNotNull(OpenSession.getClientScreen3270());
        Assert.assertNotEquals("", OpenSession.getClientScreen3270().getScreenText());
        Close.session();
    }

    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }

}