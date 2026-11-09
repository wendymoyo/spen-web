package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.BasePage;
import pages.UnmeteredConnectionDetailsPage;

import java.util.List;
import java.util.Map;

public class UnmeteredConnectionDetailsSteps {

    BasePage basePage;
    UnmeteredConnectionDetailsPage unmeteredConnectionDetailsPage;

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        Assert.assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @And("I provide Unmetered Connection plot details:")
    public void iProvideUnmeteredConnectionPlotDetails(DataTable dataTable) {
        checkProgressBarNavigation("Connections");
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("connection").equalsIgnoreCase("Street Light")) {
                iProvideStreetLightsPhaseAndConnections(columns.get("phase"), columns.get("number"));
            } else if (columns.get("connection").equalsIgnoreCase("Advertising board")) {
                iProvideAdvertisingBoardPhaseAndConnections(columns.get("phase"), columns.get("number"));
            } else if (columns.get("connection").equalsIgnoreCase("Control pillar")) {
                iProvideControlPillarPhaseAndConnections(columns.get("phase"), columns.get("number"));
            } else if (columns.get("connection").equalsIgnoreCase("Other equipment")) {
                iProvideOtherEquipmentPhaseConnectionsAndOtherInfo(columns.get("phase"), columns.get("number"), columns.get("other_info"));
            } else {
                System.out.println("Incorrect unmetered connection point provided!");
            }
        }
    }

    @Step
    @And("I provide street lights phase {string} and connections {string}")
    public void iProvideStreetLightsPhaseAndConnections(String phase, String number) {
        unmeteredConnectionDetailsPage.selectStreetLightPhaseRequired(phase);
        unmeteredConnectionDetailsPage.enterStreetLightCount(number);
    }

    @Step
    @And("I provide advertising board phase {string} and connections {string}")
    public void iProvideAdvertisingBoardPhaseAndConnections(String phase, String number) {
        unmeteredConnectionDetailsPage.selectAdvertisingBoardPhaseRequired(phase);
        unmeteredConnectionDetailsPage.enterAdvertisingBoardCount(number);
    }

    @Step
    @And("I provide control pillar phase {string} and connections {string}")
    public void iProvideControlPillarPhaseAndConnections(String phase, String number) {
        unmeteredConnectionDetailsPage.selectControlPillarPhaseRequired(phase);
        unmeteredConnectionDetailsPage.enterControlPillarCount(number);
    }

    @Step
    @And("I provide other equipment phase {string}, connections {string} and other info {string}")
    public void iProvideOtherEquipmentPhaseConnectionsAndOtherInfo(String phase, String number, String text) {
        unmeteredConnectionDetailsPage.selectOtherEquipmentPhaseRequired(phase);
        unmeteredConnectionDetailsPage.enterOtherEquipmentCount(number);
        unmeteredConnectionDetailsPage.enterOtherEquipmentInfo(text);

    }

    @Step
    @And("I enter the mpan number {string}")
    public void iEnterTheMpanNumber(String mpan) {
        unmeteredConnectionDetailsPage.enterMpanNumber(mpan);
    }

    @Step
    @And("I select connection adopted as {string}")
    public void iSelectConnectionAdoptedAs(String answer) {
        if (answer.equalsIgnoreCase("Yes")) {
            unmeteredConnectionDetailsPage.clickOnConnectionAdoptedYes();
        } else if (answer.equalsIgnoreCase("No")) {
            unmeteredConnectionDetailsPage.clickOnConnectionAdoptedNo();
        }
        basePage.clickNext();
    }

}
