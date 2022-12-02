package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import org.junit.*;

import java.io.*;

@SuppressWarnings({"java:S5778","java:S2699"})
public class ControlWaitTest {

    private final String LOCALHOST = "localhost";
    @Before
    public void initMocks() throws IOException {
        Service.create5250();
    }

    @Test
    public void timeoutInConnectionTheSystem(){
        Assert.assertThrows(AssertionError.class, () -> OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(23).conectingToSSL(false)));
        Close.session();
    }

    @Test
    public void waitTheString(){
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        ControlWait.waitStringInScreen("User");
        Close.session();
    }

    @Test
    public void failWaitTheString(){
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        Assert.assertThrows(AssertionError.class, () -> ControlWait.waitStringInScreen("Libreria devco"));
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