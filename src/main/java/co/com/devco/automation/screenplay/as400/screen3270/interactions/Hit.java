package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.SendKey;
import co.com.devco.automation.screenplay.as400.screen3270.utils.KeysScreen;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@SuppressWarnings("java:S1068")
public class Hit implements Interaction {

    private KeysScreen key;
    private String text = "";
    private String message;


    public Hit(KeysScreen key) {
        this.key = key;
        this.message = " the key "+this.key.getNameKey();
    }

    public Hit(String text) {
        this.text = text;
        this.message = " types the text "+text;
    }

    @Override
    @Step("{0} #message")
    public <T extends Actor> void performAs(T actor) {

        if (text.isEmpty()) {
            SendKey.sendKey(key);
        } else {
            SendKey.sendKeyWithoutWait(text);
        }

        TakeProofEvidence.inScreen3270InTheCase(CaseScreenshot.FOR_EACH_ACTION);

    }

    public static Hit the(KeysScreen key) {
        return instrumented(Hit.class,key);
    }

    public static Hit the(String text) {
        return instrumented(Hit.class,text);
    }

}

