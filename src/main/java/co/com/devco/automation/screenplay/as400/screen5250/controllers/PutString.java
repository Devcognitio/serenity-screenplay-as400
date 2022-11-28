package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.utils.*;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.*;
import static co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen.*;

public class PutString {

    private PutString(){}

    public static void putString(String text, int row, int column) {
        getClientScreen5250().setFieldTextByCoord(row, column, text);
        printScreen();
    }

    public static void putStringByLabel(String text, String label) {
        try {
            getClientScreen5250().setFieldTextByLabel(label, text);
        }catch(Exception e) {
            printScreen();
            TakeProofEvidence.inScreen5052InTheCase(CaseScreenshot.TAKE_SCREENSHOT);
            throw new IllegalArgumentException("the tag '"+label+"' is not found inside the screen or it's not valid");
        }

        printScreen();
    }

}
