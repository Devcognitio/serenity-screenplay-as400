package co.com.devco.automation.screenplay.as400.exceptions;

public class TagException extends IllegalStateException {

    private static final String MESSAGE_FORMAT = "The tag \"%s\" is not a valid tag";

    public TagException(String tag, CoordinateException e) {
        super(String.format(MESSAGE_FORMAT, tag), e);
    }
}
