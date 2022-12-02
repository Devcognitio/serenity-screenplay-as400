package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

public class GetStringTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create5250();
    }

    @Test
    public void validateGetString() {
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertEquals("User", GetString.getString(6, 17, 4));
        Close.session();
    }

    @Test
    public void validateExceptionRowGetString() {
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertThrows(IllegalArgumentException.class, () -> GetString.getString(-5, 1, 14));
        Close.session();
    }

    @Test
    public void validateExceptionColumnGetString() {
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertThrows(IllegalArgumentException.class, () ->  GetString.getString(5, -1, 14));
        Close.session();
    }
    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }


}