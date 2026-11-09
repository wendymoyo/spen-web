/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.BasePage;
import pages.ContactDetailsPage;
import pages.SiteContactDetailsPage;

import java.util.List;
import java.util.Map;

public class SiteContactDetailsSteps {

    SiteContactDetailsPage siteContactDetailsPage;
    BasePage basePage;
    ContactDetailsPage contactDetailsPage;

    @Step
    @And("I select Yes to site contact")
    public void iSelectYesToSiteContact() {
        siteContactDetailsPage.clickSiteContactYes();
        basePage.clickNext();
    }

    @Step
    @And("I select No to site contact")
    public void iSelectNoToSiteContact() {
        siteContactDetailsPage.clickSiteContactNo();
        basePage.clickNext();
    }

    @Step
    @And("I enter site contact details:")
    public void iEnterSiteContactDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        contactDetailsPage.selectTitle(data.get(0).get("title"));
        contactDetailsPage.enterFirstName(data.get(0).get("first_name"));
        contactDetailsPage.enterLastName(data.get(0).get("last_name"));
        siteContactDetailsPage.enterPosition(data.get(0).get("position"));
        contactDetailsPage.enterMobileNumber(data.get(0).get("mobile"));
        contactDetailsPage.enterLandlineNumber(data.get(0).get("landline"));
        contactDetailsPage.enterEmail(data.get(0).get("email"));
        basePage.clickNext();
    }
}
