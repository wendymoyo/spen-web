/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ConnectionPlotDetailsSteps {

    NewConnectionsPage newConnectionsPage;
    BasePage basePage;
    ConnectionPlotDetailsPage connectionPlotDetailsPage;
    ConnectionGenerationPage connectionGenerationPage;
    OtherSignificantLoadsPage otherSignificantLoadsPage;
    UploadFilePage uploadFilePage;
    ExcavationPage excavationPage;

    @Step
    public Boolean isPageTitleDisplayed() {
        return newConnectionsPage.isPageHeaderDisplayed();
    }

    @Step
    public String getPageTitle() {
        return newConnectionsPage.getPageHeaderText();
    }

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        Assert.assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @Step
    @And("I provide the additional load details: {string}, {string}, {string}, {string}, {string}")
    public void iProvideTheAdditionalLoadDetails(String property, String heating, String mpan, String maxLoad, String phase) {
        checkProgressBarNavigation("Connections");
        connectionPlotDetailsPage.selectPropertyType(property);
        connectionPlotDetailsPage.selectHeatingType(heating);
        connectionPlotDetailsPage.enterMpanNumber(mpan);
        connectionPlotDetailsPage.enterMaxLoadRequired(maxLoad);
        connectionPlotDetailsPage.selectPhaseRequired(phase);
        basePage.clickNext();
    }

    @Step
    @And("I provide the move meter supply position details: {string}, {string}, {string}, {string}")
    public void iProvideTheMoveMeterSupplyPositionDetails( String distance, String property, String phase, String works) {
        checkProgressBarNavigation("Estimate");
        Serenity.setSessionVariable("works").to(works);
        connectionPlotDetailsPage.enterDistanceMoved(distance);
        connectionPlotDetailsPage.selectPropertyType(property);
        connectionPlotDetailsPage.selectMoveMeterPhaseRequired(phase);

        // Flat property type is not asked the excavation question
        if (!property.equalsIgnoreCase("Flat / Apartment")) {
            if (works.equalsIgnoreCase("I will")) {
                excavationPage.clickCustomerWillExcavate();
            } else if (works.equalsIgnoreCase("SPEN")) {
                excavationPage.clickSpenWillExcavate();
            }
        }

        basePage.clickNext();
    }

    @Step
    @And("I select {string} connections")
    public void iSelectConnections(String option) {
        checkProgressBarNavigation("Connections");
        assertTrue("Connections page header is not displayed!", isPageTitleDisplayed());
        if (option.equalsIgnoreCase("1-4")) {
            newConnectionsPage.clickOnOneToFourConnections();
        } else if (option.equalsIgnoreCase("5 or more")) {
            newConnectionsPage.clickOnFiveOrMoreConnections();
        } else {
            System.out.println("The connection option provided is incorrect!");
        }
        basePage.clickNext();
    }

    @Step
    @And("I select the Connection plots for New connection property types:")
    public void iSelectConnectionPlotsForNewConnectionPropertyTypes(DataTable dataTable) {
        checkProgressBarNavigation("Connections");
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("property").equalsIgnoreCase("House")) {
                newConnectionsPage.enterHouseConnectionPlots(columns.get("plots"));
            } else if (columns.get("property").equalsIgnoreCase("Flat")) {
                newConnectionsPage.enterFlatConnectionPlots(columns.get("plots"));
            } else if (columns.get("property").equalsIgnoreCase("Landlord")) {
                newConnectionsPage.enterLandlordConnectionPlots(columns.get("plots"));
            } else if (columns.get("property").equalsIgnoreCase("Commercial")) {
                newConnectionsPage.enterCommercialConnectionPlots(columns.get("plots"));
            } else if (columns.get("property").equalsIgnoreCase("Multiple EV Charge points")) {
                newConnectionsPage.enterMultipleEvChargePoints(columns.get("plots"));
            } else if (columns.get("property").equalsIgnoreCase("Temporary")) {
                newConnectionsPage.enterTemporaryConnectionPlots(columns.get("plots"));
            } else {
                System.out.println("Incorrect New connection property provided!");
            }
        }
        basePage.clickNext();
    }

    @Step
    @And("I provide Connection details for each plot:")
    public void iProvideConnectionDetailsForEachPlot(DataTable dataTable) {
        checkProgressBarNavigation("Connections");
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            connectionPlotDetailsPage.clickEnterDetailsButtonForConnection(columns.get("plot"));
            connectionPlotDetailsPage.selectHeatingType(columns.get("heating"));
            connectionPlotDetailsPage.enterMaxLoadRequired(columns.get("max_load"));
            connectionPlotDetailsPage.selectPhaseRequired(columns.get("phase"));

            // Select business type for Commercial plot
            if (columns.get("business_type") != null && !columns.get("business_type").equalsIgnoreCase("N/A")) {
                connectionPlotDetailsPage.clickBusinessTypeRadioButton(columns.get("business_type"));
            }
            // Select Ev Charging type for Ev Charger plot
            if (columns.get("ev_charge") != null && !columns.get("ev_charge").equalsIgnoreCase("N/A")) {
                connectionPlotDetailsPage.clickEvChargingRadioButton(columns.get("ev_charge"));
            }
            basePage.clickNext();

            // Select Other Significant Loads for plot
            if (columns.get("other_loads") != null && !columns.get("other_loads").equalsIgnoreCase("None")) {
                iSelectOtherSignificantLoads(columns.get("other_loads"));
            } else {
                iDoNotSelectOtherSignificantLoads();
            }

            // Select Generation / Storage option
            if (columns.get("gen_storage").equalsIgnoreCase("Yes")) {
                iSelectYesToGenerationStorageAndSelectTechnologyAndRating(columns.get("tech"), columns.get("rating"));
            } else {
                iSelectNoToGenerationStorage();
            }

            // Enter additional Location details
            if (columns.get("location") != null && !columns.get("location").equalsIgnoreCase("None")) {
                iEnterConnectionLocationDetails(columns.get("location"));
            } else {
                iDoNotProvideConnectionLocationDetails();
            }
        }
        basePage.clickNext();
    }

    @Step
    @And("I select other significant loads: {string}")
    public void iSelectOtherSignificantLoads(String otherLoads) {
        checkProgressBarNavigation("Connections");
        String[] loads = otherLoads.split(", ");
        for (String load : loads) {
            if (load.equalsIgnoreCase("Swimming Pool")) {
                otherSignificantLoadsPage.clickSwimmingPoolCheckbox();
            } else if (load.equalsIgnoreCase("Welding Equipment")) {
                otherSignificantLoadsPage.clickWeldingEquipmentCheckbox();
            } else if (load.equalsIgnoreCase("Large Electrical Motors")) {
                otherSignificantLoadsPage.clickLargeElectricalMotorsCheckbox();
            } else if (load.contains("3-Phase EV Charger")) {
                otherSignificantLoadsPage.clickThreePhaseEvChargerCheckbox();
            } else if (load.contains("Other")) {
                otherSignificantLoadsPage.clickOtherLoadsCheckbox();
                otherSignificantLoadsPage.enterOtherLoadsInfo("Automation Testing - Other Loads");

                // Generate random number for rating value
                Random rand = new Random();
                String rating = String.valueOf(rand.nextInt(1000));
                otherSignificantLoadsPage.enterOtherLoadsRating(rating);
            } else {
                System.out.println("Incorrect significant load option provided!");
            }
        }
        basePage.clickNext();
    }

    @Step
    @And("I do not select other significant loads")
    public void iDoNotSelectOtherSignificantLoads() {
        basePage.clickNext();
    }

    @Step
    @And("I select Yes to generation storage and select {string} technology and rating {string}")
    public void iSelectYesToGenerationStorageAndSelectTechnologyAndRating(String tech, String rating) {
        checkProgressBarNavigation("Connections");
        connectionGenerationPage.clickGenerationStorageYes();
        connectionGenerationPage.selectGenerationTechnologyType(tech);
        connectionGenerationPage.enterGenerationStorageRating(rating);
        basePage.clickNext();
    }

    @Step
    @And("I select No to generation storage")
    public void iSelectNoToGenerationStorage() {
        checkProgressBarNavigation("Connections");
        connectionGenerationPage.clickGenerationStorageNo();
        basePage.clickNext();
    }

    @Step
    @And("I enter connection location details {string}")
    public void iEnterConnectionLocationDetails(String text) {
        checkProgressBarNavigation("Connections");
        connectionPlotDetailsPage.enterConnectionLocationDetails(text);
        basePage.clickNext();
    }

    @Step
    @And("I do not provide connection location details")
    public void iDoNotProvideConnectionLocationDetails() {
        checkProgressBarNavigation("Connections");
        basePage.clickNext();
    }

    @Step
    @And("I upload a New connection spreadsheet")
    public void iUploadANewConnectionSpreadsheet() {
        checkProgressBarNavigation("Connections");
        String filePath = "src\\test\\resources\\uploadFiles\\NewConnectionsTest.xlsx";
        uploadFilePage.uploadFile(filePath);
        assertTrue("Spreadsheet is not uploaded!", uploadFilePage.getUploadedFile());
        basePage.clickNext();
    }

    @And("I select meter type as {string}")
    public void iSelectMeterTypeAs(String meterType) {
        checkProgressBarNavigation("Meter");
        connectionPlotDetailsPage.selectMeterType(meterType);
        basePage.clickNext();
    }
}
