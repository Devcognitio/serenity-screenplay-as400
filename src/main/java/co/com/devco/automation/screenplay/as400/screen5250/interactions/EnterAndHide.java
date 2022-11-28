package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterAndHide {

    private final String theText;
    private String mask;

    private EnterAndHide(String text) {
        this.theText = text;
        this.mask = "any text";
    }

    public static EnterAndHide theValue(String text) {
        return new EnterAndHide(text);
    }

    public EnterAndHide as(String mask) {
        this.mask = mask;
        return this;
    }

    public EnterAndHideIntoTarget into(Target target) {
        return instrumented (EnterAndHideIntoTarget.class,theText, mask, target);
    }

}
