/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class UploadFilePage extends PageObject {

    By uploadFile = By.xpath("//input[@name='files']");

    @FindBy(xpath="//li[@class='file-list-element']")
    WebElementFacade uploadedFile;

    @FindBy(id="next-button")
    WebElementFacade submitButton;

    public void uploadFile(String filePath) {
        upload(filePath).to(find(uploadFile));
    }

    public Boolean getUploadedFile() { return uploadedFile.isDisplayed(); }

    public void clickSubmit() { submitButton.click(); }
}
