package co.com.devco.automation.screenplay.as400.model;

public class Session {

    private String host;
    private int port;
    private boolean flagSSL;

    public Session(String host, int port,boolean flagSSL) {
        this.host = host;
        this.port = port;
        this.flagSSL = flagSSL;
    }

    public static SessionBuilder withHost(String host) {
        return new SessionBuilder(host);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean isFlagSSL() {
        return flagSSL;
    }
}
