package co.com.devco.automation.screenplay.as400.targets;

import co.com.devco.automation.screenplay.as400.exceptions.CoordinateException;

public class Coordinate {

    private int row;
    private int initialColumn;
    private int finalColumn;
    private int length;

    public Coordinate(CoordinateBuilder builder) {
        this.row = builder.getRow();
        this.initialColumn = builder.getInitialColumn();
        this.finalColumn = builder.getFinalColumn();
        this.length = builder.getLength();
        validateStatus();
    }

    private void validateStatus() {
        if(row <= 0 || initialColumn <= 0 || finalColumn <= 0 || length <= 0 ) {
            throw new CoordinateException(this);
        }
    }

    public int getRow() {
        return row;
    }

    public int getInitialColumn() {
        return initialColumn;
    }

    public int getFinalColumn() {
        return finalColumn;
    }

    public int getLength() {
        return length;
    }

    public static CoordinateBuilder withRow(int row){
        return new CoordinateBuilder(row);
    }

    @Override
    public String toString() {
        return "Coordinate(" +
                "row=" + row +
                ", initialColumn=" + initialColumn +
                ", finalColumn=" + finalColumn +
                ", length=" + length +
                ")";
    }
}
