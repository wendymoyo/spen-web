/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class PaceFormPage extends PageObject {

    @FindBy(id="preAppCompanyName")
    WebElementFacade companyName;

    @FindBy(id="preAppEmail")
    WebElementFacade email;

    @FindBy(id="phoneNumber")
    WebElementFacade phoneNumber;

    @FindBy(xpath="//*[@for='directTransmissionConnection']")
    WebElementFacade directTransmissionConnection;

    @FindBy(xpath="//*[@for='distributionConnection']")
    WebElementFacade distributionConnection;

    @FindBy(id="preAppConnectionFreeText")
    WebElementFacade distributionPointOfContact;

    @FindBy(id="preAppNameAndAddress")
    WebElementFacade projectNameAndAddress;

    @FindBy(xpath="//form/input[@type='text']")
    WebElementFacade projectLocationSearch;

    @FindBy(xpath="//button[@title='Search']")
    WebElementFacade searchButton;

    @FindBy(xpath="//ul/li")
    WebElementFacade projectLocation;

    @FindBy(id="preAppCapacity")
    WebElementFacade projectCapacity;

    @FindBy(id="preAppRequirements")
    WebElementFacade demandRequirements;

    @FindBy(id="preppConsentsStatus")
    WebElementFacade consentsStatusDropdown;

    @FindBy(id="screenshotBtn")
    WebElementFacade confirmSiteButton;

    @FindBy(xpath="//input[@type='date']")
    WebElementFacade aspiredConnectionDate;

    @FindBy(id="preAppTechnology")
    WebElementFacade technology;

    @FindBy(id="preAppIssues")
    WebElementFacade environmentIssues;

    @FindBy(id="preAppVoltage")
    WebElementFacade pointOfConnectionVoltage;

    @FindBy(xpath="//*[@for='overheadLine']")
    WebElementFacade overheadLine;

    @FindBy(xpath="//*[@for='undergroundCable']")
    WebElementFacade undergroundCable;

    @FindBy(xpath="//*[@for='yes']")
    WebElementFacade customerConsentYes;

    @FindBy(xpath="//*[@for='no']")
    WebElementFacade customerConsentNo;

    @FindBy(id="preAppFurtherInfo")
    WebElementFacade furtherInfo;

    public String getCompanyNameText() {
        return companyName.getValue();
    }

    public String getEmailText() {
        return email.getValue();
    }

    public String getMobileText() {
        return phoneNumber.getValue();
    }

    public void clickDirectTransmissionConnectionRadio() {
        directTransmissionConnection.click();
    }

    public void clickDistributionConnectionRadio() {
        distributionPointOfContact.sendKeys(Keys.ARROW_DOWN);
        distributionConnection.click();
    }

    public void enterDistributionPointOfContact(String text) {
        distributionPointOfContact.sendKeys(Keys.ARROW_DOWN);
        typeInto(distributionPointOfContact, text);
    }

    public void enterProjectNameAndAddress(String text) {
        projectNameAndAddress.sendKeys(Keys.PAGE_DOWN);
        typeInto(projectNameAndAddress, text);
    }

    public void enterProjectLocation(String text) {
        projectLocationSearch.sendKeys(Keys.PAGE_DOWN);
        typeInto(projectLocationSearch, text);
        projectLocationSearch.sendKeys(Keys.ENTER);
    }

    public void selectProjectLocationFromList() {
        projectLocation.click();
    }

    public void clickUseCurrentLocation() {
        projectLocation.click();
    }

    public void enterProjectCapacity(String text) {
        projectCapacity.sendKeys(Keys.ARROW_DOWN);
        typeInto(projectCapacity, text);
    }

    public void enterDemandRequirements(String text) {
        demandRequirements.sendKeys(Keys.ARROW_DOWN);
        typeInto(demandRequirements, text);
    }

    public void selectConsentsStatusFromDropdown(String status) {
        consentsStatusDropdown.sendKeys(Keys.ARROW_DOWN);
        consentsStatusDropdown.selectByVisibleText(status);
    }

    public void enterAspiredConnectionDate(String text) {
        aspiredConnectionDate.sendKeys(Keys.ARROW_DOWN);
        typeInto(aspiredConnectionDate, text);
    }

    public void enterTechnology(String text) {
        technology.sendKeys(Keys.ARROW_DOWN);
        typeInto(technology, text);
    }

    public void enterEnvironmentIssues(String text) {
        environmentIssues.sendKeys(Keys.ARROW_DOWN);
        typeInto(environmentIssues, text);
    }

    public void enterPointOfConnectionVoltage(String text) {
        pointOfConnectionVoltage.sendKeys(Keys.ARROW_DOWN);
        typeInto(pointOfConnectionVoltage, text);
    }

    public void clickOverheadLineRadio() { overheadLine.click(); }

    public void clickUndergroundCableRadio() { undergroundCable.click(); }

    public void clickCustomerConsentYesRadio() {
        furtherInfo.sendKeys(Keys.ARROW_DOWN);
        customerConsentYes.click();
    }

    public void clickCustomerConsentNoRadio() {
        furtherInfo.sendKeys(Keys.ARROW_DOWN);
        customerConsentNo.click();
    }

    public void enterFurtherInfo(String text) {
        furtherInfo.sendKeys(Keys.PAGE_DOWN);
        typeInto(furtherInfo, text);
    }

    public void clickConfirmSiteButton(String text) {
        confirmSiteButton.click();
    }

    public void clickButton(String text) {
        $("//*[contains(text(), '%s')]".replace("%s", text)).click();
    }
}
