/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import pages.BasePage;
import pages.ContactDetailsPage;
import pages.PreviousApplicationPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PreviousApplicationSteps {

    PreviousApplicationPage previousApplicationPage;
    BasePage basePage;
    ContactDetailsPage contactDetailsPage;

    @Step
    @And("I select {string} to previous application question")
    public void iSelectToPreviousApplicationQuestion(String answer) {
        assertTrue("Previous app page header is not displayed!", previousApplicationPage.isPreviousAppPageHeaderDisplayed());
        assertTrue("User menu logo is not displayed!", previousApplicationPage.isUserMenuDisplayed());
        assertTrue("Page footer is not displayed!", basePage.isFooterNavigationDisplayed());
//        assertEquals("Page footer links count is wrong! Expected: 6 ", 6, (int) basePage.getFooterLinksCount());
//        assertEquals("Page footer social icons count is wrong! Expected: 3 ", 3, (int) basePage.getFooterSocialIconsCount());

        String expectedAppName = Serenity.sessionVariableCalled("appName") + " Application";
        String actualAppName = previousApplicationPage.getPageHeaderText();
        assertEquals("Application name is incorrect! Expected: " + expectedAppName + " Actual: " + actualAppName, expectedAppName, actualAppName);

        if (answer.equalsIgnoreCase("No")) {
            previousApplicationPage.clickPrevAppNoButton();
        } else if (answer.equalsIgnoreCase("Yes")) {
            previousApplicationPage.clickPrevAppYesButton();
        }
    }

    @And("I select {string} update option")
    public void iSelectUpdateOption(String option) {
        String expectedAppName = Serenity.sessionVariableCalled("appName") + " Application";
        String actualAppName = previousApplicationPage.getPageHeaderText();
        assertEquals("Application name is incorrect! Expected: " + expectedAppName + " Actual: " + actualAppName,
                expectedAppName, actualAppName);

        switch(option) {
            case "The design has changed":
                previousApplicationPage.clickDesignChangeRadioButton();
                break;
            case "The applicant, payment or site contact has changed":
                previousApplicationPage.clickContactsChangedRadioButton();
                break;
            case "I need an updated quote as my existing quote has expired":
                previousApplicationPage.clickQuoteExpiredRadioButton();
                break;
            case "Other":
                previousApplicationPage.clickOtherRadioButton();
                previousApplicationPage.enterOtherDetails("Previous app - Other Automation test");
                break;
            default:
                System.out.println("Incorrect update option provided!");
        }
        basePage.clickNext();
    }

    @Then("I am shown the {string} application Submit New Application page")
    public void iAmShownTheApplicationSubmitNewApplicationPage(String appName) {
        String currentUrl = previousApplicationPage.getDriver().getCurrentUrl();
        assertTrue("Page url is incorrect!", currentUrl.contains("requote/new-application"));

        String expectedAppName = appName + " Application";
        String actualAppName = previousApplicationPage.getPageHeaderText();
        assertEquals("Application name is incorrect! Expected: " + expectedAppName + " Actual: " + actualAppName,
                expectedAppName, actualAppName);

        assertTrue("Alert is not displayed", previousApplicationPage.isDesignChangeAlertDisplayed());

        String alertMsg = "Sorry, if your design has changed, you'll need to submit a new application.";
        assertEquals("Alert message is not displayed!", alertMsg, previousApplicationPage.getDesignChangeAlertText());

        assertTrue("SPEN contact details are not displayed!", previousApplicationPage.isSpenContactDetailsAlertDisplayed());
        assertTrue("The 'Submit new application' button is not displayed!", previousApplicationPage.isSubmitNewAppButtonDisplayed());
        assertTrue("The 'Back' button is not displayed!", basePage.isBackButtonDisplayed());
        assertEquals("Scotland phone number displayed is incorrect. Expected: 0800 389 1785", "0800 389 1785", previousApplicationPage.getScotlandPhoneNumber());
        assertEquals("England & Wales phone number displayed is incorrect. Expected: 0800 389 1783", "0800 389 1783", previousApplicationPage.getEnglandWalesPhoneNumber());
    }

    @Step
    @And("I enter the quote reference and contact details:")
    public void iEnterTheQuoteReferenceAndContactDetails(DataTable dataTable) {
        String expectedAppName = Serenity.sessionVariableCalled("appName") + " Application";
        String actualAppName = previousApplicationPage.getPageHeaderText();
        assertEquals("Application name is incorrect! Expected: " + expectedAppName + " Actual: " + actualAppName,
                expectedAppName, actualAppName);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        previousApplicationPage.enterQuoteRef(data.get(0).get("quote_ref"));
        contactDetailsPage.selectTitle(data.get(0).get("title"));
        contactDetailsPage.enterFirstName(data.get(0).get("first_name"));
        contactDetailsPage.enterLastName(data.get(0).get("last_name"));
        contactDetailsPage.enterMobileNumber(data.get(0).get("mobile"));
        contactDetailsPage.enterLandlineNumber(data.get(0).get("landline"));
        contactDetailsPage.enterEmail(data.get(0).get("email"));
    }

    @And("I click the Submit request button")
    public void iClickTheSubmitRequestButton() {
//        previousApplicationPage.clickSubmitRequestButton();
    }

    @Then("I am shown the {string} application Update Request confirmation page")
    public void iAmShownTheApplicationUpdateRequestConfirmationPage(String appName) {
//        String currentUrl = previousApplicationPage.getDriver().getCurrentUrl();
//        assertTrue("Page url is incorrect!", currentUrl.contains("/requote/confirm"));
//
//        String expectedAppName = appName + " Application";
//        String actualAppName = previousApplicationPage.getPageHeaderText();
//        assertEquals("Application name is incorrect! Expected: " + expectedAppName + " Actual: " + actualAppName,
//                expectedAppName, actualAppName);
//
//        assertTrue("Alert is not displayed", previousApplicationPage.isUpdateRequestAlertDisplayed());
//
//        String alertMsg = "Thanks for submitting your application update request";
//        assertEquals("Update request alert message is not displayed! Expected: " + alertMsg, alertMsg, previousApplicationPage.getUpdateRequestAlertText());
//
//        String info = "One of our team will be in touch within 2 working days to discuss your application further.";
//        assertTrue("Update request info is not displayed! Expected: " + info, previousApplicationPage.getUpdateRequestInfoText().contains(info));
//
//        assertTrue("The 'Done' button is not displayed!", previousApplicationPage.isDoneButtonDisplayed());
//        assertEquals("Scotland phone number displayed is incorrect. Expected: 0800 389 1785",
//                "0800 389 1785", previousApplicationPage.getScotlandPhoneNumber());
//        assertEquals("England & Wales phone number displayed is incorrect. Expected: 0800 389 1783",
//                "0800 389 1783", previousApplicationPage.getEnglandWalesPhoneNumber());
    }

}
