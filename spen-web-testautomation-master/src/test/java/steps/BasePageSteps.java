/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.*;

import static org.junit.Assert.*;

public class BasePageSteps {

    BasePage basePage;

    @Step
    @And("I enter a valid postcode {string} and click Check Now button")
    public void iEnterAValidPostcodeAndClickCheckNowButton(String postcode) {
        assertTrue("Page footer is not displayed!", basePage.isFooterNavigationDisplayed());
        basePage.enterPostcode(postcode);
        basePage.clickCheckNow();
    }

    @Step
    @And("I click Apply Now")
    public void iClickApplyNow() {
        basePage.clickApplyNow();
    }

    @Step
    @And("I click Continue application")
    public void iClickContinueApplication() {
        basePage.clickContinueApplication();
    }

    @And("I click Apply Now and continue to application form")
    public void iClickApplyNowAndContinueToApplicationForm() {
        iClickApplyNow();
        iClickContinueApplication();
    }

    @Step
    @And("I click Next button")
    public void iClickNextButton() {
        basePage.clickNext();
    }

    @Step
    @And("I click Back button")
    public void iClickBackButton() {
        basePage.clickBack();
    }

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @And("I continue to Move Meter application form")
    public void iContinueToMoveMeterApplicationForm() {
        basePage.clickNext();
    }
}
