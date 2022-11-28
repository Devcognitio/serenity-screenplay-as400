package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.screen5250.utils.KeysScreen;

import java.awt.*;
import java.util.Optional;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait.waitSystem;
import static co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession.getClientScreen5250;
import static co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen.printScreen;

public class SendKey {

    private SendKey(){}

    public static void sendKey(KeysScreen key) {
        getClientScreen5250().sendKeyEvent(key.getNameKey(), 0);
        waitSystem();
        printScreen();
    }

    public static void sendKeyWithoutWait(String textInput) {
        Optional<Point> optionalPointcursor = getClientScreen5250().getCursorPosition();
        Point cursor = optionalPointcursor.orElse(new Point(1,1));
        getClientScreen5250().setFieldTextByCoord(
                cursor.y,
                cursor.x,
                textInput
        );
        printScreen();
    }

}
