/**
 * Author: Wendy Moyo
 */

package tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.pages.components.FileToUpload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UploadFileSteps;

@RunWith(SerenityRunner.class)
public class UploadFileTest {

    @Steps
    UploadFileSteps uploadFileSteps;

    @Managed()
    WebDriver driver;

    @Test
    public void upload_file() {
        uploadFileSteps.iUploadAFile();
    }

    @Test
    public void click_on_submit_button() {
        uploadFileSteps.iCanSubmitMyApplication();
    }

}
