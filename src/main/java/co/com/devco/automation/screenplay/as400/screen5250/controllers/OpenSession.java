package co.com.devco.automation.screenplay.as400.screen5250.controllers;

import co.com.devco.automation.screenplay.as400.model.*;
import net.infordata.em.*;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.ControlWait.*;
import static co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen.*;
import static co.com.devco.automation.screenplay.as400.utils.SSLContextFactory.*;

public class OpenSession {

    private static TerminalClient client;

    private OpenSession(){}

    public static void openSessionTn5250(Session session) {

            client = new TerminalClient();
            client.setTerminalType("IBM-3179-2");
            client.setConnectionTimeoutMillis(0);
            if(session.isFlagSSL()) {
                    client.setSocketFactory(buildSSLContext().getSocketFactory());
            }
            client.connect(session.getHost(), session.getPort());
            waitSystem();
            printScreen();

    }

    public static TerminalClient getClientScreen5250() {
        return client;
    }

}
