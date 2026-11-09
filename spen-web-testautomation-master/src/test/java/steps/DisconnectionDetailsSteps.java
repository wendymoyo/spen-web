package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.BasePage;
import pages.ConnectionPlotDetailsPage;
import pages.DisconnectionDetailsPage;
import pages.UploadFilePage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class DisconnectionDetailsSteps {

    BasePage basePage;
    DisconnectionDetailsPage disconnectionDetailsPage;
    ConnectionPlotDetailsPage connectionPlotDetailsPage;
    UploadFilePage uploadFilePage;

    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        Assert.assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @Step
    @And("I select {string} disconnections")
    public void iSelectDisconnections(String option) {
        checkProgressBarNavigation("Disconnection");
        assertTrue("Wrong page header is displayed! ", basePage.checkPageHeaderIsDisplayed("Disconnections"));
        if (option.equalsIgnoreCase("1-3")) {
            disconnectionDetailsPage.clickOneToThreeRadioButton();
        } else if (option.equalsIgnoreCase("4 or more")) {
            disconnectionDetailsPage.clickFourOrMoreRadioButton();
        } else {
            System.out.println("The disconnection option provided is incorrect!");
        }
        basePage.clickNext();
    }

    @And("I provide the Disconnection plot details:")
    public void iProvideTheDisconnectionPlotDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            disconnectionDetailsPage.clickAddDisconnectionPointButton();
            disconnectionDetailsPage.enterMpanNumber(columns.get("plot"), columns.get("mpan"));
            if (columns.get("site_address").equalsIgnoreCase("Yes")) {
                disconnectionDetailsPage.clickSameAsSiteAddressYes(columns.get("plot"));
            } else if (columns.get("site_address").equalsIgnoreCase("No")) {
                disconnectionDetailsPage.clickSameAsSiteAddressNo(columns.get("plot"));
                select_disconnection_point_address(columns.get("plot"), columns.get("site_postcode"), columns.get("county"));
            }
            select_location_vacant_option(columns.get("plot"), columns.get("vacant"));
        }
        basePage.clickNext();
    }

    @Step
    public void select_disconnection_point_address(String plot_num, String postcode, String county) {
//        disconnectionDetailsPage.enterDisconnectionSitePostcode(plot_num, postcode);
//        disconnectionDetailsPage.selectFirstOptionAddressFromList(plot_num);
//        if (disconnectionDetailsPage.getStreetName(plot_num) == null || disconnectionDetailsPage.getStreetName(plot_num).isEmpty()) {
//            disconnectionDetailsPage.enterStreetName(plot_num,"Auto Disconnection Test Street");
//        }

        // Enter address manually as address search sometimes fails to return results
        disconnectionDetailsPage.enterDisconnectionAddressManually(plot_num, "35", "Test Street", "Test Town", postcode);
        disconnectionDetailsPage.selectCountyFromDropdown(plot_num, county);
    }

    @Step
    public void select_location_vacant_option(String plot_num, String vacant) {
        if (vacant.equalsIgnoreCase("Yes")) {
            disconnectionDetailsPage.clickLocationVacantYes(plot_num);
        } else if (vacant.equalsIgnoreCase("No")) {
            disconnectionDetailsPage.clickLocationVacantNo(plot_num);
        }
    }

    @Step
    @And("I upload a Disconnections spreadsheet")
    public void iUploadADisconnectionsSpreadsheet() {
        checkProgressBarNavigation("Disconnection");
        String filePath = "src\\test\\resources\\uploadFiles\\DisconnectionsTest.xlsx";
        uploadFilePage.uploadFile(filePath);
        assertTrue("Spreadsheet is not uploaded!", uploadFilePage.getUploadedFile());
        basePage.clickNext();
    }

}
