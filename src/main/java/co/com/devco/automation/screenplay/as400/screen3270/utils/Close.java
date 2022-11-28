package co.com.devco.automation.screenplay.as400.screen3270.utils;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.*;
import jline.internal.Log;

import java.util.concurrent.*;

public class Close {

    private Close(){}

    public static void session()  {
        try {
            OpenSession.getClientScreen3270().disconnect();
        } catch (InterruptedException e) {
            Log.error(e);
            Thread.currentThread().interrupt();
        }
        new CountDownLatch(2).countDown();
    }

}
