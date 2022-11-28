package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;

import static co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.*;

public class PutString {

    private PutString(){}

    public static void putString(String text, int row, int column) {
        getClientScreen3270().setFieldTextByCoord(row, column, text);
        PrintScreen.printScreen();
    }

    public static void putStringByLabel(String text, String label) {

        try {
            getClientScreen3270().setFieldTextByLabel(label, text);
        }catch(Exception e) {
            TakeProofEvidence.inScreen3270InTheCase(CaseScreenshot.TAKE_SCREENSHOT);
            throw new IllegalArgumentException("the tag '"+label+"' is not found inside the screen or it's not valid");
        }

        PrintScreen.printScreen();
    }

}
