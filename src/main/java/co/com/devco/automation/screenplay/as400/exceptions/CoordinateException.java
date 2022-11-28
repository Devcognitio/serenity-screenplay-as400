package co.com.devco.automation.screenplay.as400.exceptions;

import co.com.devco.automation.screenplay.as400.targets.Coordinate;

public class CoordinateException extends IllegalStateException {

    private static final String MESSAGE_FORMAT = "The coordinate entered is not valid. Values (row=%s,  initialColumn=%s, finalColumn=%S, length=%s)";

    public CoordinateException(Coordinate coordinate) {
        super(String.format(MESSAGE_FORMAT, coordinate.getRow(), coordinate.getInitialColumn(),
                coordinate.getFinalColumn(), coordinate.getLength()));
    }
}
