/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import pages.PaceFormPage;
import pages.PortalPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PortalPageSteps {

    PortalPage portalPage;
    PaceFormPage paceFormPage;

    @Step
    @Given("the user is on the SPEN app page")
    public void launchSpenApp() {
        portalPage.open();
    }

    @And("I click on my email address at the top of the page")
    public void iClickOnMyEmailAddressAtTheTopOfThePage() {
        portalPage.clickUserMenuDropdown();
    }

    @And("I click {string} link")
    public void iClickLink(String option) {
        switch(option) {
            case "My Profile":
            case "Change Password":
            case "Log Out":
            case "Register now":
                portalPage.clickOnPortalLink(option);
                break;
            default:
                System.out.println("Incorrect link name provided!");
        }
    }

    @When("I enter my current password {string} and my new password {string}")
    public void iEnterMyCurrentPasswordAndMyNewPassword(String current_password, String new_password) {
        portalPage.enterCurrentPassword(current_password);
        portalPage.enterPassword(new_password);
        portalPage.enterConfirmPassword(new_password);
    }

    @Step
    @And("I click {string} button")
    public void iClickButton(String option) {
        switch(option) {
            case "Reset Password":
            case "Cancel":
                portalPage.clickButton(option);
                break;
            case "Edit":
                portalPage.clickOnPortalButton(option);
                break;
            case "Save":
                portalPage.clickSaveButton();
                break;
            case "General Enquiries":
            case "Power Cuts & Emergencies":
            case "Power Cuts In Your Area":
            case "Getting Connected":
            case "Customer Support":
            case "Contact Us":
                portalPage.clickOnPortalHomeButton(option);
                break;
            default:
                System.out.println("Incorrect button name provided!");
        }
    }

    @Then("I am taken to my User Profile details page")
    public void iAmTakenToMyUserProfileDetailsPage() {
        String expectedUrl = "ccp.spenergynetworks.co.uk/profile";
        String currentUrl = Serenity.getDriver().getCurrentUrl();
        assertTrue("Url shown is incorrect! Expected: " + expectedUrl + " Actual: " + currentUrl,
                currentUrl.contains(expectedUrl));
        String pageHeader = "USER PROFILE";
        assertEquals("Page header is not displayed! Expected: " + pageHeader,
                pageHeader, portalPage.getPageHeaderText());
    }

    @Then("I am shown a message that my password has been updated")
    public void iAmShownAMessageThatMyPasswordHasBeenUpdated() {
        assertTrue("Change password alert icon is not displayed!", portalPage.isChangePasswordAlertIconDisplayed());

        String alertMsg = "Password Successfully Updated";
        assertEquals("Change password alert message is not displayed! Expected: " + alertMsg,
                alertMsg, portalPage.getChangePasswordAlertMsgText());
    }

    @When("I change my landline number to {string}")
    public void iChangeMyLandlineNumberTo(String number) {
        portalPage.enterLandlineNumber(number);
    }

    @When("I change my last name to {string}")
    public void iChangeMyLastNameTo(String text) {
        portalPage.enterLastName(text);
        Serenity.setSessionVariable("last_name").to(text);
    }

    @Then("The page is refreshed and my profile details have been updated")
    public void thePageIsRefreshedAndMyProfileDetailsHaveBeenUpdated() {
        String surname = Serenity.sessionVariableCalled("last_name");

        // click User menu dropdown and select My Profile
        portalPage.clickUserMenuDropdown();
        portalPage.clickOnPortalLink("My Profile");
        assertEquals("Incorrect surname displayed! Expected: " + surname,
                surname, portalPage.getLastNameText());
    }

    @Then("I am taken to my Home page and my password is not changed")
    public void iAmTakenToMyHomePageAndMyPasswordIsNotChanged() {
        String expectedUrl = "ccp.spenergynetworks.co.uk/";
        String actualUrl = Serenity.getDriver().getCurrentUrl();
        assertTrue("Wrong page displayed! Expected: " +expectedUrl,
                actualUrl.contains(expectedUrl));
    }

    @And("I enter customer details:")
    public void iEnterCustomerDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        portalPage.selectTitle(data.get(0).get("title"));
        portalPage.enterFirstName(data.get(0).get("first_name"));
        portalPage.enterLastName(data.get(0).get("last_name"));
        portalPage.enterEmail(data.get(0).get("email"));
        portalPage.enterEmailConfirmation(data.get(0).get("email"));
        portalPage.enterLandlineNumber(data.get(0).get("landline"));
        portalPage.enterMobileNumber(data.get(0).get("mobile"));
        portalPage.enterCompanyName(data.get(0).get("company_name"));
        portalPage.enterPassword(data.get(0).get("password"));
        portalPage.enterPasswordConfirmation(data.get(0).get("password"));
        iClickButton("Save");
    }

    @Then("I am logged out of the application")
    public void iAmLoggedOutOfTheApplication() {
        String expectedUrl = "ccp.spenergynetworks.co.uk";
        String actualUrl = Serenity.getDriver().getCurrentUrl();
        assertTrue("Wrong page displayed! Expected: " +expectedUrl+ " , but got " +actualUrl,
                actualUrl.contains(expectedUrl));
    }

    @Then("I am taken to the {string} page")
    public void iAmTakenToThePage(String pageName) {
        String actualUrl = Serenity.getDriver().getCurrentUrl();
        String actualHeader = portalPage.getPageHeaderText();

        switch(pageName) {
            case "Getting Connected":
//                expectedUrl = "https://www.spenergynetworks.co.uk/pages/which_type_of_connection.aspx";
                assertTrue("Wrong page displayed! Expected: " +pageName+ " but got " +actualUrl,
                        actualUrl.contains("/which_type_of_connection.aspx"));
//                assertEquals("Wrong page header displayed! Expected: " +pageName,
//                        pageName, actualHeader);
                break;
            case "Customer Support":
//                expectedUrl = "https://www.spenergynetworks.co.uk/pages/customer_support.aspx";
                assertTrue("Wrong page displayed! Expected: " +pageName+ " but got " +actualUrl,
                        actualUrl.contains("/customer_support.aspx"));
//                assertEquals("Wrong page header displayed! Expected: " +pageName,
//                        pageName, actualHeader);
                break;
            default:
                System.out.println("Incorrect button name provided!");
        }

        // assert page header
        assertEquals("Wrong page header displayed! Expected: " +pageName,
                pageName, actualHeader);
    }

    @When("I click {string} under the Transmission Connections section")
    public void iClickUnderTheTransmissionConnectionsSection(String option) {
        switch(option) {
            case "New Pre Application":
            case "My Projects":
            case "More Info":
                portalPage.clickOnPortalButton(option);
                break;
            default:
                System.out.println("Incorrect option name provided!");
        }
    }

    @Then("I am taken to the PACE form page")
    public void iAmTakenToThePACEFormPage() {
        String expectedHeader = "PRE-APPLICATION CUSTOMER ENGAGEMENT (PACE)";
        String actualHeader = portalPage.getPageHeaderText();
        assertEquals("Wrong page header displayed! Expected: " +expectedHeader,
                expectedHeader, actualHeader);
    }

    @And("My company name, email and mobile number are pre-populated as: {string}, {string} and {string}")
    public void myCompanyNameEmailAndMobileNumberArePrePopulatedAsAnd(String company, String email, String mobile) {
        assertEquals("Incorrect company name displayed! Expected: " +company+ " but got " + paceFormPage.getCompanyNameText(),
                company, paceFormPage.getCompanyNameText());
        assertEquals("Incorrect email displayed! Expected: " +email+ " but got " + paceFormPage.getEmailText(),
                email, paceFormPage.getEmailText());
        assertEquals("Incorrect mobile number displayed! Expected: " +mobile+ " but got " + paceFormPage.getMobileText(),
                mobile, paceFormPage.getMobileText());
    }

    @When("I complete the PACE form")
    public void iCompleteThePACEForm() {
        paceFormPage.clickDistributionConnectionRadio();
        paceFormPage.enterDistributionPointOfContact("Test Contact");
        paceFormPage.enterProjectNameAndAddress("Test Project, Glasgow");
        paceFormPage.enterProjectLocation("KA11 4DQ");
//        paceFormPage.selectProjectLocationFromList();
        paceFormPage.clickConfirmSiteButton("Click here to confirm site position");
        paceFormPage.enterProjectCapacity("100");
        paceFormPage.enterDemandRequirements("225");
        paceFormPage.selectConsentsStatusFromDropdown("Pending");
        paceFormPage.enterAspiredConnectionDate("02/04/2025");
        paceFormPage.enterTechnology("Wind turbine");
        paceFormPage.enterEnvironmentIssues("Tornadoes");
        paceFormPage.enterPointOfConnectionVoltage("78");
        paceFormPage.clickOverheadLineRadio();
        paceFormPage.clickCustomerConsentNoRadio();
        paceFormPage.enterFurtherInfo("Auto testing - Pace form");
    }

    @Then("The form is submitted")
    public void theFormIsSubmitted() {

    }


}
