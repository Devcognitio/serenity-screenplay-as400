package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Enter {

    private String text;

    public Enter(String text) {
        this.text = text;
    }

    public static Enter theValue(String text) {
        return new Enter(text);
    }

    public EnterValue into(Target target) {
        return instrumented(EnterValue.class,this.text, target);
    }

}

