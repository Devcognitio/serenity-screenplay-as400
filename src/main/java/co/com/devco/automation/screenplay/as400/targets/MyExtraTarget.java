package co.com.devco.automation.screenplay.as400.targets;

import java.util.Optional;

public class MyExtraTarget extends Target {

    private Coordinate coordinate;
    private Optional<String> tag;

    public MyExtraTarget(String targetElementName, String tag) {
        super(targetElementName);
        this.tag = Optional.of(tag);
    }

    public MyExtraTarget(String targetElementName, Coordinate coordinateSelector) {
        super(targetElementName);
        coordinate = coordinateSelector;
        tag = Optional.empty();
    }

    @Override
    public Target called(String name) {
        return tag.map(s -> new MyExtraTarget(name, s)).orElseGet(() -> new MyExtraTarget(name, coordinate));
    }

    @Override
    public String getTag() {
        return tag.orElse("");
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

}
