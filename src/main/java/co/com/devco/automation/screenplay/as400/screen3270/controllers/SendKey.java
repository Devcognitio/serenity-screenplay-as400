package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.screen3270.utils.*;

import java.awt.*;
import java.util.Optional;

import static co.com.devco.automation.screenplay.as400.screen3270.controllers.ControlWait.*;
import static co.com.devco.automation.screenplay.as400.screen3270.controllers.OpenSession.*;

public class SendKey {

    private SendKey(){}

    public static void sendKey(KeysScreen key) {
        getClientScreen3270().sendAID(key.getKey(), key.getNameKey());
        waitSystem();
        PrintScreen.printScreen();
    }

    public static void sendKeyWithoutWait(String textInput) {
        Optional<Point> optionalPointcursor = getClientScreen3270().getCursorPosition();
        Point cursor = optionalPointcursor.orElse(new Point(1,1));
        getClientScreen3270().setFieldTextByCoord(
                cursor.y,
                cursor.x,
                textInput
        );
        PrintScreen.printScreen();
    }

}
