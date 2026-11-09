/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PreviousApplicationPage extends PageObject {

    @FindBy(id="no-link")
    WebElementFacade prevAppNoButton;

    @FindBy(id="yes-link")
    WebElementFacade prevAppYesButton;

    @FindBy(id="user-menu-button")
    WebElementFacade userMenuButton;

    @FindBy(xpath="//h2[contains(text(), 'Do you want to update a previous application?')]")
    WebElementFacade previousAppPageHeader;

    @FindBy(id="reQuoteTypeDesignChange")
    WebElementFacade designChangeRadio;

    @FindBy(id="reQuoteTypeContactsChanged")
    WebElementFacade contactsChangedRadio;

    @FindBy(id="reQuoteTypeQOOD")
    WebElementFacade quoteExpiredRadio;

    @FindBy(id="reQuoteTypeOther")
    WebElementFacade otherRadio;

    @FindBy(id="otherDetails")
    WebElementFacade otherDetailsTextbox;

    // Design changed - Submit new app landing page
    @FindBy(css="div#alert-wrapper > [style='--alert-color: var(--error); undefined']")
    WebElementFacade newAppAlert;

    @FindBy(css="div.alertContainer > [style='--alert-color: var(--tertiary-dark); undefined']")
    WebElementFacade contactDetailsAlert;

    @FindBy(id="scotland-phone-link")
    WebElementFacade scotlandPhoneNumber;

    @FindBy(id="england-wales-phone-link")
    WebElementFacade englandWalesPhoneNumber;

    // Applicant contact details page
    @FindBy(id="quoteRefNo")
    WebElementFacade quoteRefTextbox;

    @FindBy(xpath="//button[text()='Submit request']")
    WebElementFacade submitRequestButton;

    // App update request confirmation page
    @FindBy(css="div#alert-wrapper > [style='--alert-color: var(--primary-dark); undefined']")
    WebElementFacade updateRequestAlert;

    @FindBy(id="done-link")
    WebElementFacade doneButton;

    public void clickPrevAppNoButton() { prevAppNoButton.click(); }

    public void clickPrevAppYesButton() { prevAppYesButton.click(); }

    public Boolean isPreviousAppPageHeaderDisplayed() {
        return previousAppPageHeader.isVisible();
    }

    public Boolean isUserMenuDisplayed() {
        return userMenuButton.isVisible();
    }

    public void clickDesignChangeRadioButton() { designChangeRadio.click(); }

    public void clickContactsChangedRadioButton() { contactsChangedRadio.click(); }

    public void clickQuoteExpiredRadioButton() { quoteExpiredRadio.click(); }

    public void clickOtherRadioButton() { otherRadio.click(); }

    public void enterOtherDetails(String text) {
        typeInto(otherDetailsTextbox, text);
    }

    public Boolean isDesignChangeAlertDisplayed() {
        return newAppAlert.isVisible();
    }

    public String getDesignChangeAlertText() {
        return $("//div[@id='alert-wrapper']//div[@class='alert-detail']//div").getText();
    }

    public Boolean isSubmitNewAppButtonDisplayed() {
        return $("//button[text()='Submit new application']").isVisible();
    }

    public Boolean isSpenContactDetailsAlertDisplayed() {
        return contactDetailsAlert.isVisible();
    }

    public String getScotlandPhoneNumber() {
        return scotlandPhoneNumber.getText();
    }

    public String getEnglandWalesPhoneNumber() {
        return englandWalesPhoneNumber.getText();
    }

    public void enterQuoteRef(String text) {
        typeInto(quoteRefTextbox, text);
    }

    public void clickSubmitRequestButton() { submitRequestButton.click(); }

    public Boolean isUpdateRequestAlertDisplayed() {
        return updateRequestAlert.isVisible();
    }

    public String getUpdateRequestAlertText() {
        return $("//div[@id='alert-wrapper']//div[@class='alert-detail']//div").getText();
    }

    public String getUpdateRequestInfoText() {
        return $("//div[@id='alert-wrapper']/p[@class='body-2']").getText();
    }

    public Boolean isDoneButtonDisplayed() {
        return doneButton.isVisible();
    }

    public String getPageHeaderText() {
        return $("//h1").getText();
    }

}
