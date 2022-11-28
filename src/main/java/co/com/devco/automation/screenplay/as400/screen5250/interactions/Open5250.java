package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.openSessionTn5250;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@SuppressWarnings("java:S1068")
public class Open5250 implements Interaction {

    private Session sessionScreen;
    private String host;
    private int port;

    public Open5250(Session session) {

        this.sessionScreen = session;
        this.host = session.getHost();
        this.port = session.getPort();

    }

    @Step("{0} starts the session with host #host on port #port")
    public <T extends Actor> void performAs(T actor) {

        openSessionTn5250(this.sessionScreen);
        TakeProofEvidence.inScreen5052InTheCase(CaseScreenshot.FOR_EACH_ACTION);

    }

    public static Open5250 session(Session sessionName) {
        return instrumented(Open5250.class, sessionName);
    }
}