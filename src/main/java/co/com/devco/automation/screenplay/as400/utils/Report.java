package co.com.devco.automation.screenplay.as400.utils;

import net.thucydides.core.screenshots.*;
import net.thucydides.core.steps.*;

import java.io.*;

public class Report {

    private static int stepNumber = 1;

    private Report(){}

    public static void addScreenshotLastStep(String infoScreenshot) {

        if(StepEventBus.getEventBus().getBaseStepListener() != null) {
            StepEventBus.getEventBus().getBaseStepListener().latestTestOutcome().ifPresent(
                    outcome -> outcome.currentStep().ifPresent(
                            step -> step.addScreenshot(new ScreenshotAndHtmlSource(new File("step" + stepNumber + ".png")))
                    )
            );

            Text.toImage(infoScreenshot, "step" + stepNumber++);
        }
    }


}
