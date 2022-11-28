package co.com.devco.automation.screenplay.as400.screen5250.waits;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait.waitSystem;

public class WaitSystem implements Interaction {

    @Override
    @Step("{0} wait for the system")
    public <T extends Actor> void performAs(T actor) {
        waitSystem();
    }
}
