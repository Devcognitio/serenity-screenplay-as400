package co.com.devco.automation.screenplay.as400.screen5250.controllers;

public class GetString {

    private GetString(){}

    public static String getString(int row, int column, int lengtText) {
        String text;
        row = row - 1;
        column = column - 1;

        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("the value of the coordinates cannot be less than 1");
        }

        try {
            text = OpenSession.getClientScreen5250().getScreenText().substring(((81 * row) + column), ((81 * row) + column) + lengtText);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("invalid row or column value");
        }

        return text;
    }

}
