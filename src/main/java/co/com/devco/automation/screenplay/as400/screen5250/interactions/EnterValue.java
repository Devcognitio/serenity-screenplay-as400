package co.com.devco.automation.screenplay.as400.screen5250.interactions;

import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.PutString.putString;
import static co.com.devco.automation.screenplay.as400.screen5250.controllers.PutString.putStringByLabel;

@SuppressWarnings("java:S1068")
public class EnterValue implements Interaction {

    private Coordinate coordinate;
    private String name;
    private String text;
    private Target target;
    private String message;

    public EnterValue(String text, Target target) {
        this.text = text;
        this.target = target;
        this.name = this.target.getName();
        this.coordinate = this.target.getCoordinate();
        this.message = target.getTag().isEmpty()?this.target.getCoordinate().toString():"tag name "+this.target.getTag();
    }

    @Override
    @Step("{0} enter the value #text into field #name with #message")
    public <T extends Actor> void performAs(T actor) {

        if (coordinate == null) {
            putStringByLabel(text, target.getTag());
        } else {
            putString(this.text, this.coordinate.getRow(), this.getColumn());
        }
        TakeProofEvidence.inScreen5052InTheCase(CaseScreenshot.FOR_EACH_ACTION);
    }

    private int getColumn() {
        return target.getTag().isEmpty() ? this.coordinate.getInitialColumn() : this.coordinate.getFinalColumn();
    }
}
