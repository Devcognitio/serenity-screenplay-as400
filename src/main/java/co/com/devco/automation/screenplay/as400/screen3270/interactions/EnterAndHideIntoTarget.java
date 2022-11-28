package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.PutString;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class EnterAndHideIntoTarget implements Interaction {

    private final Coordinate coordinate;
    private Target target;
    private String theText;

    public EnterAndHideIntoTarget(String theText, Target target) {
        this.theText = theText;
        this.target = target;
        this.coordinate = this.target.getCoordinate();
    }

    @Override
    @Step("{0} enter the value #mask into field #name with #coordinate")
    public <T extends Actor> void performAs(T actor) {
        if (target.getTag().isEmpty()) {
            PutString.putString(theText, this.coordinate.getRow(), getColumn());
        } else {
            PutString.putStringByLabel(theText, target.getTag());
        }
    }

    private int getColumn() {
        return target.getTag().isEmpty() ? this.coordinate.getInitialColumn() : this.coordinate.getFinalColumn();
    }
}
