package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

public class GetStringTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create3270();
    }
    @Test
    public void validateGetString() {
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertEquals("ENTER USERID", GetString.getString(1, 11, 12));
        Close.session();
    }

    @Test
    public void validateExceptionRowGetString() {
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertThrows(IllegalArgumentException.class, () -> GetString.getString(-5, 1, 14));
        Close.session();
    }

    @Test
    public void validateExceptionColumnGetString() {
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertThrows(IllegalArgumentException.class, () ->  GetString.getString(5, -1, 14));
        Close.session();
    }

    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }

}