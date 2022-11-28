package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.*;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.ExtendedTemporaryFolder;
import net.thucydides.core.util.MockEnvironmentVariables;
import org.junit.*;
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
    ConsoleStepListener consoleStepListener;
    BaseStepListener baseStepListener;
    ConsoleLoggingListener consoleLoggingListener;
    private StepFactory factory;

    @Rule
    public ExtendedTemporaryFolder temp = new ExtendedTemporaryFolder();

    @Before
    public void initMocks() throws IOException {
        MockitoAnnotations.openMocks(this);
        environmentVariables = new MockEnvironmentVariables();
        environmentVariables.setProperty("thucydides.logging","VERBOSE");

        factory = StepFactory.getFactory().usingPages(new Pages(driver));

        consoleStepListener = new ConsoleStepListener();
        consoleLoggingListener = new ConsoleLoggingListener(environmentVariables);
        baseStepListener = new BaseStepListener(temp.newFolder());
        StepEventBus.getEventBus().reset();
        StepEventBus.getEventBus().registerListener(listener);
        StepEventBus.getEventBus().registerListener(consoleStepListener);
        StepEventBus.getEventBus().registerListener(consoleLoggingListener);
        StepEventBus.getEventBus().registerListener(baseStepListener);
    }

    @Test
    public void enterTextOnTheScreenByCoordinates() {
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        PutString.putString("tests", 24, 1);
        Assert.assertEquals("tests", GetString.getString(24, 1, 5));
        Close.session();
    }

    @Test
    public void enterTextOnScreenByLabel() {
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        SendKey.sendKeyWithoutWait("TSO");
        SendKey.sendKey(KeysScreen.ENTER);
        PutString.putStringByLabel("test", "ENTER USERID");
        Assert.assertEquals("test", GetString.getString(1, 26, 4));
        Close.session();
    }

    @Test(expected = IllegalArgumentException.class)
    public void enterTextOnScreenByLabelDontValid() throws Exception {
        OpenSession.openSession3270(Session.withHost("192.86.32.250").andPort(623).conectingToSSL(false));
        PutString.putStringByLabel("tests", "test");
        Close.session();
    }

}