package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@SuppressWarnings("java:S1068")
public class Open3270 implements Interaction {

    private Session sessionScreen;
    private String host;
    private int port;

    public Open3270(Session session) {
        this.sessionScreen = session;
        this.host = session.getHost();
        this.port = session.getPort();
    }

    @Step("{0} starts the session with host #host on port #port")
    public <T extends Actor> void performAs(T actor) {
        OpenSession.openSession3270(this.sessionScreen);
        TakeProofEvidence.inScreen3270InTheCase(CaseScreenshot.FOR_EACH_ACTION);
    }

    public static Open3270 session(Session sessionName) {
        return instrumented(Open3270.class,sessionName);
    }
}