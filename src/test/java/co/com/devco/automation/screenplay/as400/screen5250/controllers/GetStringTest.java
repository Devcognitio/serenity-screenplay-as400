package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import org.junit.*;

public class GetStringTest {

    @Test
    public void validateGetString() {
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        Assert.assertEquals("Your user name", GetString.getString(5, 1, 14));
        Close.session();
    }

    @Test
    public void validateExceptionRowGetString() {
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        Assert.assertThrows(IllegalArgumentException.class, () -> GetString.getString(-5, 1, 14));
        Close.session();
    }

    @Test
    public void validateExceptionColumnGetString() {
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        Assert.assertThrows(IllegalArgumentException.class, () ->  GetString.getString(5, -1, 14));
        Close.session();
    }

}