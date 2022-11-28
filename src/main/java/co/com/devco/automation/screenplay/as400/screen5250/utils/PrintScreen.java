package co.com.devco.automation.screenplay.as400.screen5250.utils;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession;
import jline.internal.Log;

public class PrintScreen {

    private static boolean printIndicator = false;
    private static int numberPage = 1;

    private PrintScreen(){}

    public static void setPrintIndicator(boolean inputIndicator) {
        printIndicator = inputIndicator;
    }

    public static void printScreen() {

        if (printIndicator) {
            Log.info(
                    "Page " + (numberPage++) + "\n" +
                            "--------------------------------------------------------------------------------\n" +
                            OpenSession.getClientScreen5250().getScreenText() +
                            "\n--------------------------------------------------------------------------------"
            );
        }

    }

}
