/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import pages.AddressPage;
import pages.BasePage;

import static org.junit.Assert.*;

public class AddressSteps {

    BasePage basePage;
    AddressPage addressPage;

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @Step
    @When("I enter the site address postcode {string}")
    public void iEnterTheSiteAddressPostcode(String postcode) {
        checkProgressBarNavigation("Site");
//        assertTrue("Page footer is not displayed!", basePage.isFooterNavigationDisplayed());
//        assertEquals("Page footer links count is wrong! Expected: 6 ", 6, (int) basePage.getFooterLinksCount());
//        assertEquals("Page footer social icons count is wrong! Expected: 3 ", 3, (int) basePage.getFooterSocialIconsCount());
        addressPage.enterPostcode(postcode);
    }

    @And("I select an address from the list")
    public void iSelectAnAddressFromTheList() {
        addressPage.selectFirstOptionAddressFromList();
    }

    @And("I select the address {string}")
    public void iSelectTheAddress(String address) {
        addressPage.selectAddressFromList(address);
        basePage.clickNext();
    }

    @And("I select an address not eligible for fixed price")
    public void iSelectAnAddressNotEligibleForFixedPrice() {
        addressPage.selectFirstOptionAddressFromList();
        basePage.clickNext();
    }

    @And("I select county {string}")
    public void iSelectCounty(String county) {
        addressPage.selectCountyFromDropdown(county);
        basePage.clickNext();
    }

    @And("I select an address from the list and county {string}")
    public void iSelectAnAddressFromTheListAndCounty(String county) {
        addressPage.selectFirstOptionAddressFromList();
        if (addressPage.getStreetName() == null || addressPage.getStreetName().isEmpty()) {
            addressPage.enterStreetName("Auto Test Street");
        }
        iSelectCounty(county);
    }

    @When("I select a fixed price eligible postcode {string} and address {string}")
    public void iSelectAFixedPriceEligiblePostcodeAndAddress(String postcode, String address) {
        // Added a space character at the end of postcode to improve search result
        addressPage.enterPostcode(postcode + " ");
        addressPage.selectAddressFromList(address);
        basePage.clickNext();
    }

    @When("I enter the site address and postcode {string} manually")
    public void iEnterTheSiteAddressAndPostcodeManually(String postcode) {
        checkProgressBarNavigation("Site");
        addressPage.enterAddressManually("123", "Test Street", "Test Town", postcode);
    }

    @When("I enter the unmetered site address and postcode {string} manually")
    public void iEnterTheUnmeteredSiteAddressAndPostcodeManually(String postcode) {
        checkProgressBarNavigation("Site");
        addressPage.enterUnmeteredAddressManually("Test Street", "Test Town", postcode);
    }

    @When("I enter the Move meter site address postcode {string}")
    public void iEnterTheMoveMeterSiteAddressPostcode(String postcode) {
        checkProgressBarNavigation("Site");
        addressPage.enterPostcode(postcode + " ");
    }
}
