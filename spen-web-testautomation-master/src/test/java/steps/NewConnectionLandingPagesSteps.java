/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import pages.BasePage;
import pages.NewConnectionLandingPage;

import static org.junit.Assert.*;

public class NewConnectionLandingPagesSteps {

    NewConnectionLandingPage newConnectionLandingPage;
    BasePage basePage;

    @Step
    @Then("I am taken to the Independent Connection Providers page")
    public void iAmTakenToTheIndependentConnectionProvidersPage() {
        String expectedUrl = "ccp.spenergynetworks.co.uk/landing-page/ICP";
        String actualUrl = Serenity.getDriver().getCurrentUrl();
        System.out.println("Current page url: " + actualUrl);
        assertTrue("Wrong page displayed! Expected: " +expectedUrl,
                actualUrl.contains(expectedUrl));

        assertTrue("ICP Landing page alert is not displayed", newConnectionLandingPage.isIcpAlertDisplayed());
        assertTrue("Admin North email is not displayed", newConnectionLandingPage.isAdminNorthEmailLinkDisplayed());
        assertTrue("Admin South email is not displayed", newConnectionLandingPage.isAdminSouthEmailLinkDisplayed());

        String expectedHeader = "Preparing to get connected";
        assertTrue("Wrong page header displayed. Expected " + expectedHeader, basePage.checkPageHeaderIsDisplayed(expectedHeader));

        assertTrue("Land Rights link is not displayed", newConnectionLandingPage.isLandRightsLinkDisplayed());
        assertTrue("Other Connection Providers link is not displayed", newConnectionLandingPage.isOtherConnectionProvidersLinkDisplayed());
    }

}
