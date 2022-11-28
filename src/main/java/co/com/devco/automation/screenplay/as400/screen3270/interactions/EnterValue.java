package co.com.devco.automation.screenplay.as400.screen3270.interactions;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.PutString;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

@SuppressWarnings("java:S1068")
public class EnterValue implements Performable {

    private Coordinate coordinate;
    private String text;
    private Target target;
    private String name;
    private String message;

    public EnterValue(String text, Target target) {
        this.text = text;
        this.target = target;
        this.name = this.target.getName();
        this.coordinate = this.target.getCoordinate();
        this.message = target.getTag().isEmpty() ? this.target.getCoordinate().toString() : "tag name " + this.target.getTag();
    }

    @Override
    @Step("{0} enter the value #text into field #name with #message")
    public <T extends Actor> void performAs(T actor) {

            if (coordinate == null) {
                PutString.putStringByLabel(text, target.getTag());
            } else {
                PutString.putString(this.text, this.coordinate.getRow(), this.getColumn());
            }

            TakeProofEvidence.inScreen3270InTheCase(CaseScreenshot.FOR_EACH_ACTION);

    }

    private int getColumn() {
        return target.getTag().isEmpty() ? this.coordinate.getInitialColumn() : this.coordinate.getFinalColumn();
    }
}
