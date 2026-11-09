/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.BasePage;
import pages.UploadFilePage;

import static org.junit.Assert.assertTrue;

public class UploadFileSteps {

    UploadFilePage uploadFilePage;
    BasePage basePage;


    @Step
    public void checkProgressBarNavigation(String expectedProgress) {
        String actualProgress = basePage.getCurrentProgressBarNavigation();
        Assert.assertEquals("The current progress navigation is incorrect. Expected: " +expectedProgress+ " , Actual: " +actualProgress,
                expectedProgress, actualProgress);
    }

    @Step
    @And("I upload a file")
    public void iUploadAFile() {
        checkProgressBarNavigation("Upload");
        String filePath = "src\\test\\resources\\uploadFiles\\Siteplan.jpg";
        uploadFilePage.uploadFile(filePath);
        assertTrue("File is not uploaded!", uploadFilePage.getUploadedFile());
    }

    @Step
    @Then("I can submit my application")
    public void iCanSubmitMyApplication() {
        uploadFilePage.clickSubmit();
    }
}
