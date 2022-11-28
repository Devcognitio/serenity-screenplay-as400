package co.com.devco.automation.screenplay.as400.targets;

public class TargetBuilder {

    private String targetElementName;

    public TargetBuilder(String targetElementName) {
        this.targetElementName = targetElementName;
    }

    public Target locatedByTag(String tag) {
        return new MyExtraTarget(targetElementName, tag);
    }

    public Target locatedByCoordinate(Coordinate coordinateSelector) {
        return new MyExtraTarget(targetElementName, coordinateSelector);
    }
}
