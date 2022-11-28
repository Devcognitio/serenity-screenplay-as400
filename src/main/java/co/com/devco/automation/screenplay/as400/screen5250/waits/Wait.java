package co.com.devco.automation.screenplay.as400.screen5250.waits;

import net.serenitybdd.screenplay.Interaction;

public class Wait {

    private Wait(){}

    public static Interaction system() {
        return new WaitSystem();
    }

    public static Interaction string(String text) {
        return new WaitString(text);
    }

    public static Interaction time(Long timeoutMillis) {
        return new WaitTime(timeoutMillis);
    }

}
