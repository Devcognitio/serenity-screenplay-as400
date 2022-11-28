package co.com.devco.automation.screenplay.as400.screen3270.questions;

import co.com.devco.automation.screenplay.as400.screen3270.controllers.GetString;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;

public class Text {

    private Text() {}

    public static String of(Target target) {
        Coordinate coordinate = target.getCoordinate();
        TakeProofEvidence.inScreen3270InTheCase(CaseScreenshot.FOR_EACH_VALIDATION);
        return GetString.getString(coordinate.getRow(), coordinate.getInitialColumn(), coordinate.getLength()).trim();
    }

}
