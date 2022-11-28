package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import net.thucydides.core.util.SystemEnvironmentVariables;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.getClientScreen5250;


public class ControlWait {

    private static long initialTime;

    private ControlWait() {
    }

    public static void waitSystem() {
        initialTime = System.currentTimeMillis();
        String lastScreen = getClientScreen5250().getScreenText();
        while (!getClientScreen5250().getScreenText().isEmpty() && lastScreen.equals(getClientScreen5250().getScreenText())) {
            lastScreen = getClientScreen5250().getScreenText();
            if (System.currentTimeMillis() - initialTime > SystemEnvironmentVariables.createEnvironmentVariables().getPropertyAsInteger("connection.timeout", 50000))
                throw new AssertionError("connection error with host");
        }
        waitTime(500);
    }

    public static void waitStringInScreen(String text) {
        initialTime = System.currentTimeMillis();
        while (!getClientScreen5250().getScreenText().toUpperCase().contains(text.toUpperCase())) {
            if (System.currentTimeMillis() - initialTime > SystemEnvironmentVariables.createEnvironmentVariables().getPropertyAsInteger("connection.timeout", 10000)) {
                throw new AssertionError("element dont see in the screen");
            }
        }
    }

    public static void waitTime(long timeoutMillis) {
        initialTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - initialTime <= timeoutMillis) {
            System.currentTimeMillis();
        }
    }

}
