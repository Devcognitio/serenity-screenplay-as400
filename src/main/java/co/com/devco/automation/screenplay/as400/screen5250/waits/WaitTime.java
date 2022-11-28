package co.com.devco.automation.screenplay.as400.screen5250.waits;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait.waitTime;

public class WaitTime implements Interaction {

    private Long timeoutMillis;

    public WaitTime(Long timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    @Step("{0} wait the text @test in the screen")
    public <T extends Actor> void performAs(T actor) {
        waitTime(timeoutMillis);
    }

}
