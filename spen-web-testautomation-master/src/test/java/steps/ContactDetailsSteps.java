package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.AddressPage;
import pages.BasePage;
import pages.ContactDetailsPage;

import java.util.List;
import java.util.Map;


public class ContactDetailsSteps {

    ContactDetailsPage contactDetailsPage;
    AddressPage addressPage;
    BasePage basePage;

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        Assert.assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @Step
    @And("I enter the applicant details:")
    public void iEnterTheApplicantDetails(DataTable dataTable) {
        checkProgressBarNavigation("Contacts");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        contactDetailsPage.selectTitle(data.get(0).get("title"));
        contactDetailsPage.enterFirstName(data.get(0).get("first_name"));
        contactDetailsPage.enterLastName(data.get(0).get("last_name"));
        contactDetailsPage.enterBusinessName(data.get(0).get("business_name"));
        contactDetailsPage.enterMobileNumber(data.get(0).get("mobile"));
        contactDetailsPage.enterLandlineNumber(data.get(0).get("landline"));
        contactDetailsPage.enterEmail(data.get(0).get("email"));
    }

    @Step
    @And("I select Yes to site address same as applicant address")
    public void iSelectYesToSiteAddressSameAsApplicantAddress() {
        contactDetailsPage.clickSameAddressAsSiteYes();
        basePage.clickNext();
    }

    @Step
    @And("I enter the applicant address postcode {string}")
    public void iEnterTheApplicantAddressPostcode(String postcode) {
//        addressPage.enterPostcode(postcode);

        // Enter address manually as address search sometimes fails to return results
        addressPage.enterAddressManually("123", "Test Street", "Test Town", postcode);
    }

    @Step
    @And("I select No to site address same as applicant address")
    public void iSelectNoToSiteAddressSameAsApplicantAddress() {
        contactDetailsPage.clickSameAddressAsSiteNo();
    }
}
