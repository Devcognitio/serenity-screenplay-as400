package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import org.junit.*;

public class OpenSessionTest {

    @Test
    public void successfulConnectionToA3270Terminal(){
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        Assert.assertNotNull(OpenSession.getClientScreen3270());
        Assert.assertNotEquals("", OpenSession.getClientScreen3270().getScreenText());
        Close.session();
    }

}