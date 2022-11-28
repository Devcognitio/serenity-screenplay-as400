package co.com.devco.automation.screenplay.as400.screen5250.questions;

import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import co.com.devco.automation.screenplay.as400.utils.CaseScreenshot;
import co.com.devco.automation.screenplay.as400.utils.TakeProofEvidence;

import static co.com.devco.automation.screenplay.as400.screen5250.controllers.GetString.getString;

public class Text {

    private Text(){}

    public static String of(Target target) {

        Coordinate coordinate = target.getCoordinate();
        TakeProofEvidence.inScreen5052InTheCase(CaseScreenshot.FOR_EACH_VALIDATION);
        return getString(coordinate.getRow(), coordinate.getInitialColumn(), coordinate.getLength()).trim();

    }

}
