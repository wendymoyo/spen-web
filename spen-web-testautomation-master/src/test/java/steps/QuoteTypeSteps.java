package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.BasePage;
import pages.QuoteTypePage;

public class QuoteTypeSteps {

    BasePage basePage;
    QuoteTypePage quoteTypePage;

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        Assert.assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @Step
    @And("I select Formal quote type")
    public void iSelectFormalQuoteType() {
        if (Serenity.sessionVariableCalled("appName").toString().equals("Move Meter")) {
            checkProgressBarNavigation("Estimate");
        } else {
            checkProgressBarNavigation("Quote");
        }

        quoteTypePage.clickFormalQuote();
        basePage.clickNext();
    }

    @Step
    @And("I select Informal quote type")
    public void iSelectInformalQuoteType() {
        if (Serenity.sessionVariableCalled("appName").toString().equals("Move Meter")) {
            checkProgressBarNavigation("Estimate");
        } else {
            checkProgressBarNavigation("Quote");
        }

        quoteTypePage.clickInformalQuote();
        basePage.clickNext();
    }
}
