/**
 * Author: Wendy Moyo
 */

package tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.ContactDetailsSteps;

@RunWith(SerenityRunner.class)
class ContactDetailsTest {

    @Steps
    ContactDetailsSteps contactDetailsSteps;

    @Managed()
    WebDriver driver;

    @Test
    void select_site_address_same_as_applicant_address() {
        contactDetailsSteps.iSelectYesToSiteAddressSameAsApplicantAddress();
    }

}
