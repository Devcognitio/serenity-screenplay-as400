package co.com.devco.automation.screenplay.as400.screen3270.waits;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class WaitSystem implements Interaction {

    @Override
    @Step("{0} wait for the system")
    public <T extends Actor> void performAs(T actor) {
        ControlWait.waitSystem();
    }
}
