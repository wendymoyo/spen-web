package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.AddressPage;
import pages.BasePage;
import pages.ContactDetailsPage;
import pages.PaymentContactDetailsPage;

import java.util.List;
import java.util.Map;

public class PaymentContactDetailsSteps {

    PaymentContactDetailsPage paymentContactDetailsPage;
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
    @And("I select Yes to paying for work")
    public void iSelectYesToPayingForWork() {
        checkProgressBarNavigation("Contacts");
        paymentContactDetailsPage.clickPayingForWorkYes();
        basePage.clickNext();
    }

    @Step
    @And("I select No to paying for work")
    public void iSelectNoToPayingForWork() {
        checkProgressBarNavigation("Contacts");
        paymentContactDetailsPage.clickPayingForWorkNo();
        basePage.clickNext();
    }

    @Step
    @And("I enter payment contact details:")
    public void iEnterPaymentContactDetails(DataTable dataTable) {
        checkProgressBarNavigation("Contacts");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        contactDetailsPage.selectTitle(data.get(0).get("title"));
        contactDetailsPage.enterFirstName(data.get(0).get("first_name"));
        contactDetailsPage.enterLastName(data.get(0).get("last_name"));
        contactDetailsPage.enterMobileNumber(data.get(0).get("mobile"));
        contactDetailsPage.enterLandlineNumber(data.get(0).get("landline"));
        contactDetailsPage.enterEmail(data.get(0).get("email"));
//        addressPage.enterPostcode(data.get(0).get("postcode"));
//        addressPage.selectFirstOptionAddressFromList();
        addressPage.enterAddressManually("25", "Test Street", "Test Town", data.get(0).get("postcode"));
        addressPage.selectCountyFromDropdown(data.get(0).get("county"));
        basePage.clickNext();
    }

    @Step
    @And("I select Yes to company paying and enter company details:")
    public void iSelectYesToCompanyPayingAndEnterCompanyDetails(DataTable dataTable) {
        checkProgressBarNavigation("Contacts");
        paymentContactDetailsPage.clickCompanyPayingForWorkYes();

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        paymentContactDetailsPage.enterCompanyName(data.get(0).get("company_name"));
        paymentContactDetailsPage.enterVatNumber(data.get(0).get("vat_num"));
        paymentContactDetailsPage.enterCompanyRegNumber(data.get(0).get("company_num"));
        basePage.clickNext();
    }

    @Step
    @And("I select No to company paying")
    public void iSelectNoToCompanyPaying() {
        checkProgressBarNavigation("Contacts");
        paymentContactDetailsPage.clickCompanyPayingForWorkNo();
    }
}
