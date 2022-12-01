/*package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen5250.utils.Close;
import net.thucydides.core.logging.ConsoleLoggingListener;
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

    @After
    public void clearListener() {
        StepEventBus.getEventBus().dropAllListeners();
    }

    @Test
    public void enterTextOnTheScreenByCoordinates() {
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        PutString.putString("tests", 5, 25);
        Assert.assertEquals("TESTS", GetString.getString(5, 25, 5));
        Close.session();
    }

    @Test
    public void enterTextOnScreenByLabel() {
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        PutString.putStringByLabel("tests", "Your user name:");
        Assert.assertEquals("TESTS", GetString.getString(5, 25, 5));
        Close.session();
    }

    @Test(expected = IllegalArgumentException.class)
    public void enterTextOnScreenByLabelDontValid() throws IOException {
        OpenSession.openSessionTn5250(Session.withHost("pub400.com").andPort(992).conectingToSSL(true));
        PutString.putStringByLabel("tests", "Usuario:");
        Close.session();
    }

}*/