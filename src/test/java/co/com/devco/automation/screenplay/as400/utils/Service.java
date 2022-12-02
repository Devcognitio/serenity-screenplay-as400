package co.com.devco.automation.screenplay.as400.utils;

import us.abstracta.wiresham.*;

import java.io.*;
import java.net.*;

public class Service {

    private static int port;
    private static VirtualTcpService instance;

    public static void create5250() {
        try {
            port = getAvailablePort();
            instance = new VirtualTcpService();
            instance.setFlow(Flow.fromYml(new File(System.getProperty("user.dir") + "/src/test/resources/login5250.yml")));
            instance.setPortArgument(port);
            instance.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void create3270() {
        try {
            port = getAvailablePort();
            instance = new VirtualTcpService();
            instance.setFlow(Flow.fromYml(new File(System.getProperty("user.dir") + "/src/test/resources/login3270.yml")));
            instance.setPortArgument(port);
            instance.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() throws InterruptedException {
        instance.stop(20000);
    }

    public static int getPort(){
        return port;
    }

    private static int getAvailablePort() throws IOException {
        ServerSocket exploitedSocket = new ServerSocket(0);
        port = exploitedSocket.getLocalPort();
        exploitedSocket.close();
        return port;
    }


}
