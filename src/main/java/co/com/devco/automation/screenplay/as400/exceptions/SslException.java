package co.com.devco.automation.screenplay.as400.exceptions;

public class SslException extends RuntimeException{

    private static final String MESSAGE_FORMAT = "Problem with ssl certificate";

    public SslException(String error) {
        super(MESSAGE_FORMAT + ": " + error);
    }

}
