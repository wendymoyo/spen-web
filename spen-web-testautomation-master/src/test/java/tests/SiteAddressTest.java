/**
 * Author: Wendy Moyo
 */

package tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.AddressSteps;

@RunWith(SerenityRunner.class)
public class SiteAddressTest {

    @Steps
    AddressSteps addressSteps;

    @Managed()
    WebDriver driver;

    @Test
    public void select_site_address() {
        addressSteps.iSelectAnAddressFromTheList();
    }

}
