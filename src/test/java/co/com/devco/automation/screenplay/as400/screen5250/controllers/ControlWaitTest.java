package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import org.junit.*;

@SuppressWarnings({"java:S5778","java:S2699"})
public class ControlWaitTest {

    @Test
    public void timeoutInConnectionTheSystem(){
        Assert.assertThrows(AssertionError.class, () -> OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(23).conectingToSSL(true)));
        Close.session();
    }

    @Test
    public void waitTheString(){
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        ControlWait.waitStringInScreen("Your user name");
        Close.session();
    }

    @Test
    public void failWaitTheString(){
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        Assert.assertThrows(AssertionError.class, () -> ControlWait.waitStringInScreen("Libreria devco"));
        Close.session();
    }

    @Test(timeout = 1500)
    public void waitTheTime(){
        ControlWait.waitTime(1000);
    }


}