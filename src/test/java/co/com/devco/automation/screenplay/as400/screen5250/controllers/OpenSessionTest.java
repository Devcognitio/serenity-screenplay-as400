package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import org.junit.Assert;
import org.junit.Test;

public class OpenSessionTest {

    @Test
    public void successfulConnectionToA5250Terminal(){
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        Assert.assertNotNull(OpenSession.getClientScreen5250());
        Assert.assertNotEquals("", OpenSession.getClientScreen5250().getScreenText());
        Close.session();
    }

}