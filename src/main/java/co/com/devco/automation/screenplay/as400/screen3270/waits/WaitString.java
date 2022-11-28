package co.com.devco.automation.screenplay.as400.screen3270.waits;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.ControlWait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class WaitString implements Interaction {

    private String text;

    public WaitString(String text) {
        this.text = text;
    }

    @Override
    @Step("{0} wait the text @test in the screen")
    public <T extends Actor> void performAs(T actor) {
        ControlWait.waitStringInScreen(text);
    }

}
