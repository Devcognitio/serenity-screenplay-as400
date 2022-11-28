package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.screen5250.utils.KeysScreen;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.SendKey.sendKey;
import static co.com.devco.automation.screenplay.as400.screen5250.controllers.SendKey.sendKeyWithoutWait;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@SuppressWarnings("java:S1068")
public class Hit implements Interaction {

    private KeysScreen key;
    private String keyName;
    private String text = "";

    public Hit(KeysScreen key) {
        this.key = key;
        this.keyName = " Hit the key "+key;
    }

    public Hit(String text) {
        this.text = text;
        this.keyName = " types the text "+text;
    }

    @Override
    @Step("{0} #keyName")
    public <T extends Actor> void performAs(T actor) {

            if (text.isEmpty()) {
                sendKey(key);
            } else {
                sendKeyWithoutWait(text);
            }

            TakeProofEvidence.inScreen5052InTheCase(CaseScreenshot.FOR_EACH_ACTION);

    }

    public static Hit the(KeysScreen key) {
        return instrumented(Hit.class,key);
    }

    public static Hit the(String text) {
        return instrumented(Hit.class,text);
    }


}

