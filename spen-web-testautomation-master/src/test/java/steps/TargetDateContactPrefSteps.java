/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.BasePage;
import pages.TargetDateContactPrefPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TargetDateContactPrefSteps {

    TargetDateContactPrefPage targetDateContactPrefPage;
    BasePage basePage;

    @Step
    @And("I select Yes to target date and enter a future date")
    public void iSelectYesToTargetDateAndEnterAFutureDate() {
        targetDateContactPrefPage.clickWorkStartDateYes();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate oneYearLater = LocalDate.now().plusYears(1);
        targetDateContactPrefPage.enterWorkStartDate(dtf.format(oneYearLater));
    }

    @And("I select No to target date")
    public void iSelectNoToTargetDate() {
        targetDateContactPrefPage.clickWorkStartDateNo();
        basePage.clickNext();
    }

    @And("I select {string} as contact preference")
    public void iSelectAsContactPreference(String contact) {
        if (contact.equalsIgnoreCase("email")) {
            targetDateContactPrefPage.clickEmailContactMethod();
        } else if (contact.equalsIgnoreCase("phone")) {
            targetDateContactPrefPage.clickPhoneContactMethod();
        } else if (contact.equalsIgnoreCase("post")) {
            targetDateContactPrefPage.clickPostContactMethod();
        } else {
            System.out.println("Wrong contact method provided!");
        }
    }

    @And("I enter additional information {string}")
    public void iEnterAdditionalInformation(String info) {
        targetDateContactPrefPage.enterAdditionalInfo(info);
        basePage.clickNext();
    }

    @And("I do not enter additional information")
    public void iDoNotEnterAdditionalInformation() {
        basePage.clickNext();
    }
}
