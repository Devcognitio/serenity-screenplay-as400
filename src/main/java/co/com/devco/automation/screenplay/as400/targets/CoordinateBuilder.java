package co.com.devco.automation.screenplay.as400.targets;

public class CoordinateBuilder {

    private int row;
    private int initialColumn;
    private int finalColumn;
    private int length;

    public CoordinateBuilder(int row) {
        this.row = row;
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

    public CoordinateBuilder withInitialColumn(int initialColumn) {
        this.initialColumn = initialColumn;
        return this;
    }

    public CoordinateBuilder withFinalColumn(int finalColumn) {
        this.finalColumn = finalColumn;
        return this;
    }

    public Coordinate andLenght(int lenght) {
        this.length = lenght;
        calculateFinalColumnIfItIsEmpty(lenght);
        return new Coordinate(this);
    }

    private void calculateFinalColumnIfItIsEmpty(int lenght) {
        if (finalColumn == 0) {
            this.finalColumn = initialColumn + lenght - 1;
        }
    }

}
