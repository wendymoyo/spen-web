/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;
import pages.ChangeConnectionLandingPage;

import static org.junit.Assert.*;

public class ChangeConnectionLandingPagesSteps {

    ChangeConnectionLandingPage changeConnectionLandingPage;

    @Step
    @Then("I am taken to the At Your Property page")
    public void iAmTakenToTheAtYourPropertyPage() {
        String pageUrl = changeConnectionLandingPage.getDriver().getCurrentUrl();
        System.out.println("Current page url: " + pageUrl);
        String expectedUrl = "spenergynetworks.co.uk/pages/at_your_property.aspx";
        assertTrue("Incorrect url displayed! Expected: " + expectedUrl, pageUrl.contains(expectedUrl));
    }

    @Then("I am taken to the Distributed Generation page")
    public void iAmTakenToTheDistributedGenerationPage() {
        String pageUrl = changeConnectionLandingPage.getDriver().getCurrentUrl();
        System.out.println("Current page url: " + pageUrl);
        String expectedUrl = "https://www.spenergynetworks.co.uk/pages/distributed_generation.aspx";
        assertEquals("Incorrect url displayed! Expected: " + expectedUrl, expectedUrl, pageUrl);
    }

    @And("I am shown my Move Meter fixed price estimate quote")
    public void iAmShownMyMoveMeterFixedPriceEstimateQuote() {
        assertTrue("Estimated quote is not displayed!", changeConnectionLandingPage.isEstimatedCostDisplayed());
        assertFalse("Terms and conditions checkbox is displayed!", changeConnectionLandingPage.isTermsAndConditionsCheckboxDisplayed());
    }

    @And("I am shown my Move Meter estimated quote")
    public void iAmShownMyMoveMeterEstimatedQuote() {
        assertTrue("Estimated quote is not displayed!", changeConnectionLandingPage.isEstimatedCostDisplayed());
    }

    @And("I request for an email of my estimated quote {string}")
    public void iRequestForAnEmailOfMyEstimatedQuote(String email) {
        changeConnectionLandingPage.emailEstimatedQuote(email);
    }

    @And("I accept the Move Meter terms and conditions")
    public void iAcceptTheMoveMeterTermsAndConditions() {
        changeConnectionLandingPage.clickTermsAndConditionsCheckbox();
    }

    @And("I am not shown an estimated quote")
    public void iAmNotShownAnEstimatedQuote() {
        assertFalse("Estimated quote is displayed!", changeConnectionLandingPage.isEstimatedCostDisplayed());
        assertFalse("Terms and conditions checkbox is displayed!", changeConnectionLandingPage.isTermsAndConditionsCheckboxDisplayed());
    }
}
