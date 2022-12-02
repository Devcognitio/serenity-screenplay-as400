package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
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

import java.io.IOException;

public class PutStringTest {

    @Mock
    WebDriver driver;

    @Mock
    StepListener listener;

    EnvironmentVariables environmentVariables;
    BaseStepListener baseStepListener;
    ConsoleLoggingListener consoleLoggingListener;
    private StepFactory factory;
    private final String LOCALHOST = "localhost";

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();


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
        Service.create3270();
    }

    @Test
    public void enterTextOnTheScreenByCoordinates() {
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        PutString.putString("tests", 1, 27);
        Assert.assertEquals("tests", GetString.getString(1, 27, 5));
        Close.session();
    }

    @Test
    public void enterTextOnScreenByLabel() {
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        PutString.putStringByLabel("test", "ENTER USERID");
        Assert.assertEquals("test", GetString.getString(1, 27, 4));
        Close.session();
    }

    @Test(expected = IllegalArgumentException.class)
    public void enterTextOnScreenByLabelDontValid() throws Exception {
        OpenSession.openSession3270(Session.withHost(LOCALHOST).andPort(Service.getPort()).conectingToSSL(false));
        PutString.putStringByLabel("tests", "test");
        Close.session();
    }

    @After
    public void finalMocks() throws InterruptedException {
        Service.close();
    }

}