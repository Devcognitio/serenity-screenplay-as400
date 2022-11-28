package co.com.devco.automation.screenplay.as400.model;

public class SessionBuilder implements SslSession {

    private String host;
    private int port;

    public SessionBuilder(String host) {
        this.host = host;
    }

    public SslSession andPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public Session conectingToSSL(boolean flagSSL) {
        return new Session(this.host,this.port,flagSSL);
    }


}
