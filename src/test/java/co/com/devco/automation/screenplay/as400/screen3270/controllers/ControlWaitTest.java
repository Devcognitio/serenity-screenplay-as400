package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import org.junit.*;

@SuppressWarnings({"java:S5778","java:S2699"})
public class ControlWaitTest {

    @Test
    public void timeoutInConnectionTheSystem(){
        Assert.assertThrows(AssertionError.class, () -> OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(true)));
        Close.session();
    }

    @Test
    public void waitTheString(){
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        ControlWait.waitStringInScreen("Build an IBM Z Cognitive Enterprise");
        Close.session();
    }

    @Test(timeout = 1500)
    public void waitTheTime(){
        ControlWait.waitTime(1000);
    }

}