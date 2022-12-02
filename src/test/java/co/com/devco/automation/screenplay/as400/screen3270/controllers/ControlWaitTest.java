package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

@SuppressWarnings({"java:S5778","java:S2699"})
public class ControlWaitTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create3270();
    }
    @Test
    public void timeoutInConnectionTheSystem(){
        Assert.assertThrows(AssertionError.class, () -> OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(623).conectingToSSL(true)));
        Close.session();
    }

    @Test
    public void waitTheString(){
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        ControlWait.waitStringInScreen("ENTER USERID");
        Close.session();
    }
    @Test(timeout = 1500)
    public void waitTheTime(){
        ControlWait.waitTime(1000);
    }

    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }

}