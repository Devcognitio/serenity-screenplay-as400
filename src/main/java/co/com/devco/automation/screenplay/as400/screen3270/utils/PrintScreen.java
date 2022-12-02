package co.com.devco.automation.screenplay.as400.screen3270.utils;

import org.jline.utils.Log;

import static co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.getClientScreen3270;

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
                            getClientScreen3270().getScreenText() +
                            "\n--------------------------------------------------------------------------------"
            );
        }

    }

}
