package co.com.devco.automation.screenplay.as400.targets;

import co.com.devco.automation.screenplay.as400.exceptions.TagException;

public abstract class Target {

    protected String targetElementName;

    protected Target(String targetElementName) {
        this.targetElementName = targetElementName;
    }

    @Override
    public String toString() {
        return targetElementName;
    }

    public static TargetBuilder the(String targetElementName) {
        return new TargetBuilder(targetElementName);
    }

    public abstract Target called(String name) throws TagException;

    public abstract String getTag();

    public abstract Coordinate getCoordinate();

    public String getName() {
        return targetElementName;
    }


}
