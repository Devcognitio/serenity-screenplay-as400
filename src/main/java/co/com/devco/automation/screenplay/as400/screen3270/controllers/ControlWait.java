package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import net.thucydides.core.environment.SystemEnvironmentVariables;

import static co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.*;

public class ControlWait {

    private static long initialTime;

    private ControlWait(){}

    public static void waitSystem() {
        initialTime = System.currentTimeMillis();
        String lastScreen = OpenSession.getClientScreen3270().getScreenText();
        while (!OpenSession.getClientScreen3270().getScreenText().isEmpty() && lastScreen.equals(OpenSession.getClientScreen3270().getScreenText())) {
            lastScreen = OpenSession.getClientScreen3270().getScreenText();

            if (System.currentTimeMillis() - initialTime > SystemEnvironmentVariables.createEnvironmentVariables().getPropertyAsInteger("connection.timeout", 10000)) {
                throw new AssertionError("connection error with host");
            }
        }
        waitTime(500);
    }

    public static void waitStringInScreen(String text) {
        initialTime = System.currentTimeMillis();
        while (!getClientScreen3270().getScreenText().toUpperCase().contains(text.toUpperCase())) {
            if (System.currentTimeMillis() - initialTime > SystemEnvironmentVariables.createEnvironmentVariables().getPropertyAsInteger("connection.timeout", 10000))
                throw new AssertionError("element dont see in the screen");
        }
    }

    public static void waitTime(long timeoutMillis) {
        initialTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - initialTime <= timeoutMillis){
            System.currentTimeMillis();
        }
    }


}
