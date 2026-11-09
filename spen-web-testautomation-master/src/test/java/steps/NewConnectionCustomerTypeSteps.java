/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.NewConnectionCustomerTypePage;

public class NewConnectionCustomerTypeSteps {

    NewConnectionCustomerTypePage newConnectionCustomerTypePage;

    @Step
    @And("I select {string} customer type option")
    public void iSelectCustomerTypeOption(String customer) {
        switch(customer) {
            case "Homeowner / Tenant":
                newConnectionCustomerTypePage.clickOnHomeownerTenant();
                break;
            case "Property Developer":
                newConnectionCustomerTypePage.clickOnPropertyDeveloper();
                break;
            case "Commercial Business":
                newConnectionCustomerTypePage.clickOnCommercialBusiness();
                break;
            case "Housing Authority":
                newConnectionCustomerTypePage.clickOnHousingAuthority();
                break;
            case "Independent Connection Provider":
                newConnectionCustomerTypePage.clickOnIndependentConnectionProvider();
                break;
            case "3rd Party / Consultant":
                newConnectionCustomerTypePage.clickOnThirdPartyConsultant();
                break;
            default:
                System.out.println("Incorrect customer type provided!");
        }
    }

}
