package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.BasePage;
import pages.ExcavationPage;

public class ExcavationSteps {

    BasePage basePage;
    ExcavationPage excavationPage;

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        Assert.assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @Step
    @And("I select {string} to dig private land")
    public void iSelectToDigPrivateLand(String works) {
        checkProgressBarNavigation("Quote");
        Serenity.setSessionVariable("works").to(works);
        if (works.equalsIgnoreCase("I will")) {
            excavationPage.clickCustomerWillExcavate();
        } else if (works.equalsIgnoreCase("SPEN")) {
            excavationPage.clickSpenWillExcavate();
        } else {
            System.out.println("Incorrect excavation option provided!");
        }
        basePage.clickNext();
    }
}
