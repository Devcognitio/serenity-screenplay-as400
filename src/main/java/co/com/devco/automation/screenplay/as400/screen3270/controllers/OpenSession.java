package co.com.devco.automation.screenplay.as400.screen3270.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import co.com.devco.automation.screenplay.as400.screen3270.utils.*;
import com.bytezone.dm3270.*;
import com.bytezone.dm3270.display.*;

import static co.com.devco.automation.screenplay.as400.utils.SSLContextFactory.*;

public class OpenSession {

    private static TerminalClient client;

    private OpenSession(){}

    public static void openSession3270(Session session) {

        client = new TerminalClient(2, new ScreenDimensions(24, 80));
        client.setConnectionTimeoutMillis(10000);
        if (session.isFlagSSL()) {
                client.setSocketFactory(buildSSLContext().getSocketFactory());
        }
        client.connect(session.getHost(), session.getPort());
        ControlWait.waitSystem();
        PrintScreen.printScreen();

    }

    public static TerminalClient getClientScreen3270() {
        return client;
    }


}