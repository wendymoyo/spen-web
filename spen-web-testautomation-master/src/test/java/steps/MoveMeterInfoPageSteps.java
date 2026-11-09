/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.BasePage;
import pages.MoveMeterInfoPage;

import static org.junit.Assert.assertTrue;

public class MoveMeterInfoPageSteps {

    MoveMeterInfoPage moveMeterInfoPage;
    BasePage basePage;

    @Step
    @And("I am shown the Moving a Meter Supply Position information page")
    public void iAmShownTheMovingAMeterSupplyPositionInformationPage() {
        assertTrue("Move Meter Supply Position page header is not displayed!",
                moveMeterInfoPage.isMoveMeterSupplyPositionPageHeaderDisplayed());
        assertTrue("Move Meter diagram is not displayed!",
                moveMeterInfoPage.isMoveMeterDiagramDisplayed());
    }

    @Step
    @And("I click Move Meter Apply Now button")
    public void iClickMoveMeterApplyNowButton() {
        moveMeterInfoPage.clickApplyNowButton();
    }
}
