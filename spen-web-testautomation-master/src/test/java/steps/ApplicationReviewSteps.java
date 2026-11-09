/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import pages.ApplicationReviewPage;
import pages.BasePage;

import static org.junit.Assert.*;

public class ApplicationReviewSteps {

    ApplicationReviewPage applicationReviewPage;
    BasePage basePage;

    @And("I review my {string} quote application details and continue")
    public void iReviewMyQuoteApplicationDetailsAndContinue(String quoteType) {
        String appName = Serenity.sessionVariableCalled("appName");
        assertTrue("Contacts header is not displayed!",
                applicationReviewPage.isHeaderDisplayed("Contacts"));
        assertTrue("Applicant Details Edit link is not displayed!",
                applicationReviewPage.isApplicantDetailsEditLinkDisplayed());
        assertTrue("Site Address Edit link is not displayed!",
                applicationReviewPage.isSiteAddressEditLinkDisplayed());

        if (!appName.equalsIgnoreCase("Move Meter")) {
            String quote = applicationReviewPage.getQuoteType();
            assertTrue("Quotation Type is not displayed!",
                    applicationReviewPage.getQuoteType().contains(quoteType));
        }

        // Disconnection app Edit links
        if (appName.equalsIgnoreCase("Disconnection")) {
            assertTrue("Disconnection Details header is not displayed!",
                    applicationReviewPage.isSectionHeaderDisplayed("Disconnection details"));
            assertTrue("Disconnections Edit link is not displayed!",
                    applicationReviewPage.isDisconnectionsEditLinkDisplayed());
        }

        // Unmetered Connection app Edit links
        if (appName.equalsIgnoreCase("Unmetered Connection")) {
            assertTrue("Unmetered Connection Details header is not displayed!",
                    applicationReviewPage.isSectionHeaderDisplayed("Unmetered connection details"));
            assertTrue("Unmetered Connection Details Edit link is not displayed!",
                    applicationReviewPage.isUnmeteredConnectionDetailsEditLinkDisplayed());
        } else {
            assertTrue("Excavation Edit link is not displayed!",
                    applicationReviewPage.isExcavationEditLinkDisplayed());
        }

        // Move Meter app Edit links
        if (appName.equalsIgnoreCase("Move Meter")) {
            // TO DO: Need to add a flag to check if it's estimated cost first
//            assertTrue("Estimated Cost header is not displayed!",
//                applicationReviewPage.isSectionHeaderDisplayed("Estimated Cost"));
            assertTrue("Move Meter Point Details header is not displayed!",
                    applicationReviewPage.isSectionHeaderDisplayed("Move Meter Point Details"));
            assertTrue("Move Distance Edit link is not displayed!",
                    applicationReviewPage.isMoveDistanceEditLinkDisplayed());
            assertTrue("Phase Required Edit link is not displayed!",
                    applicationReviewPage.isPhaseRequiredEditLinkDisplayed());
            assertTrue("Meter Type Edit link is not displayed!",
                    applicationReviewPage.isMeterTypeEditLinkDisplayed());
        }

        assertTrue("Additional Info Edit link is not displayed!",
                applicationReviewPage.isAdditionalInfoEditLinkDisplayed());
        if (quoteType.equalsIgnoreCase("Formal")) {
            assertTrue("Formal Quote Validity header is not displayed!",
                    applicationReviewPage.isFormalQuoteValidityHeaderDisplayed());
        }
        assertTrue("Land Consensus header is not displayed!",
                applicationReviewPage.isLandConsensusHeaderDisplayed());

        basePage.clickNext();
    }

    @And("I review my {string} quote application details")
    public void iReviewMyQuoteApplicationDetails(String quoteType) {
        String appName = Serenity.sessionVariableCalled("appName");
        String works = Serenity.sessionVariableCalled("works");
        if (appName.equalsIgnoreCase("Unmetered Connection")) {
            assertTrue("Unmetered Connection Details header is not displayed!",
                    applicationReviewPage.isSectionHeaderDisplayed("Unmetered connection details"));
            assertTrue("Unmetered Connection Details Edit link is not displayed!",
                    applicationReviewPage.isUnmeteredConnectionDetailsEditLinkDisplayed());
        } else {
            assertTrue("Excavation Edit link is not displayed!",
                    applicationReviewPage.isExcavationEditLinkDisplayed());
        }
        if (!appName.equalsIgnoreCase("Move Meter")) {
            assertTrue("Quotation Type is not displayed!",
                    applicationReviewPage.getQuoteType().contains(quoteType));
        }

        if (works.equalsIgnoreCase("I will")) {
            assertTrue("Incorrect Excavation displayed! Expected: Customer will excavate",
                    applicationReviewPage.getExcavationText().contains("Customer will excavate"));
        } else {
            assertTrue("Incorrect Excavation displayed! Expected: SPEN will excavate",
                    applicationReviewPage.getExcavationText().contains("SPEN will excavate"));

        }
    }

    @And("I click Edit button for {string}")
    public void iClickEditButtonFor(String section) {
        applicationReviewPage.clickEditDetailsLinkForSection(section);
    }

    @And("I click Back button to Quote type page")
    public void iClickBackButtonToQuoteTypePage() {
        while (!basePage.getPageHeaderText().contains("What type of quote are you applying for?")){
            basePage.clickBack();
        }
    }

    @And("I continue to Application Review page")
    public void iContinueToApplicationReviewPage() {
        while (!basePage.getPageHeaderText().contains("Please review your application then submit it")){
            basePage.clickNext();
        }
    }

}
