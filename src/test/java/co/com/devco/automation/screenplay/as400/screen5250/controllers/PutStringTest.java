package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen5250.utils.*;
import co.com.devco.automation.screenplay.as400.utils.*;
import net.thucydides.core.environment.*;
import net.thucydides.core.logging.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.*;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.*;
import org.junit.rules.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class PutStringTest {

    @Mock
    WebDriver driver;

    @Mock
    StepListener listener;

    EnvironmentVariables environmentVariables;
    BaseStepListener baseStepListener;
    ConsoleLoggingListener consoleLoggingListener;
    private StepFactory factory;
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    private final String LOCALHOST = "localhost";

    @Before
    public void initMocks() throws IOException {
        MockitoAnnotations.openMocks(this);
        environmentVariables = new MockEnvironmentVariables();
        environmentVariables.setProperty("thucydides.logging","VERBOSE");

        factory = StepFactory.getFactory().usingPages(new Pages(driver));

        consoleLoggingListener = new ConsoleLoggingListener(environmentVariables);
        baseStepListener = new BaseStepListener(temp.newFolder());
        StepEventBus.getEventBus().reset();
        StepEventBus.getEventBus().registerListener(listener);
        StepEventBus.getEventBus().registerListener(consoleLoggingListener);
        StepEventBus.getEventBus().registerListener(baseStepListener);

        Service.create5250();

    }



    @Test
    public void enterTextOnTheScreenByCoordinates() {
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        PutString.putString("tests", 6, 53);
        Assert.assertEquals("TESTS", GetString.getString(6, 53, 5));
        Close.session();
    }

    @Test
    public void enterTextOnScreenByLabel() {
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        PutString.putStringByLabel("tests", "User");
        Assert.assertEquals("TESTS", GetString.getString(6, 53, 5));
        Close.session();
    }

    @Test(expected = IllegalArgumentException.class)
    public void enterTextOnScreenByLabelDontValid() {
        OpenSession.openSessionTn5250(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        PutString.putStringByLabel("tests", "Usuario:");
        Close.session();
    }

    @After
    public void clearListener() throws InterruptedException {
        StepEventBus.getEventBus().dropAllListeners();
        Service.close();
    }


}