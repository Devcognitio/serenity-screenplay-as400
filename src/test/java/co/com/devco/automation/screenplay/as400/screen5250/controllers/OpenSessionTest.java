package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

public class OpenSessionTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create5250();
    }

    @Test
    public void successfulConnectionToA5250Terminal(){
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertNotNull(OpenSession.getClientScreen5250());
        Assert.assertNotEquals("", OpenSession.getClientScreen5250().getScreenText());
        Close.session();
    }

    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }


}