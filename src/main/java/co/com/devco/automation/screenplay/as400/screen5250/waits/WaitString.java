package co.com.devco.automation.screenplay.as400.screen5250.waits;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait.waitStringInScreen;

public class WaitString implements Interaction {

    private String text;

    public WaitString(String text) {
        this.text = text;
    }

    @Override
    @Step("{0} wait the text @test in the screen")
    public <T extends Actor> void performAs(T actor) {
        waitStringInScreen(text);
    }

}
