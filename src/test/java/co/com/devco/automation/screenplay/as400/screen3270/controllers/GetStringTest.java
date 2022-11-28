package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import org.junit.*;

public class GetStringTest {

    @Test
    public void validateGetString() {
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        Assert.assertEquals("Enter TSO", GetString.getString(21, 7, 9));
        Close.session();
    }

    @Test
    public void validateExceptionRowGetString() {
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        Assert.assertThrows(IllegalArgumentException.class, () -> GetString.getString(-5, 1, 14));
        Close.session();
    }

    @Test
    public void validateExceptionColumnGetString() {
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        Assert.assertThrows(IllegalArgumentException.class, () ->  GetString.getString(5, -1, 14));
        Close.session();
    }

}