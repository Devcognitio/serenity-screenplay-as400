package co.com.devco.automation.screenplay.as400.screen5250.utils;

import co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession;

import java.util.concurrent.*;

public class Close {

    private Close(){}

    public static void session() {
        OpenSession.getClientScreen5250().disconnect();
        new CountDownLatch(1).countDown();
    }

}
