/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AppSubmissionPage extends PageObject {

    @FindBy(xpath="//h1")
    WebElementFacade pageHeader;

    @FindBy(xpath="//div[@class='alert-detail']")
    WebElementFacade successAlert;

    @FindBy(id="what-happens-next")
    WebElementFacade whatHappensNextInfo;

    @FindBy(xpath="//h2[contains(text(), 'What happens next?')]")
    WebElementFacade whatHappensNextHeader;

    @FindBy(xpath="//h2[contains(text(), 'Online payment')]")
    WebElementFacade onlinePaymentHeader;

    @FindBy(id="did-you-know")
    WebElementFacade didYouKnowInfo;

    @FindBy(id="done-link")
    WebElementFacade doneButton;


    public String getPageHeaderText() {
        pageHeader.waitUntilPresent();
        return pageHeader.getText();

    }

    public Boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }

    public Boolean isWhatHappensNextInfoDisplayed() {
        return whatHappensNextInfo.isDisplayed();
    }

    public Boolean isWhatHappensNextHeaderDisplayed() {
        return whatHappensNextHeader.isDisplayed();
    }

    public Boolean isOnlinePaymentHeaderDisplayed() {
        return onlinePaymentHeader.isDisplayed();
    }

    public Boolean isDidYouKnowInfoDisplayed() {
        return didYouKnowInfo.isDisplayed();
    }

    public Boolean isDoneButtonDisplayed() {
        return doneButton.isDisplayed();
    }

    public void clickDoneButton() { doneButton.click(); }

}
