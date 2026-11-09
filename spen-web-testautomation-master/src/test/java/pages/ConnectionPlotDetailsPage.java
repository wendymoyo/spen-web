/**
 * Author: Wendy Moyo
 *
 * This contains the page elements for connection plot details for
 * Additional Load & New Connection plot details as they all have the same element IDs.
 *
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConnectionPlotDetailsPage extends PageObject {

    /* This page contains connection plot page elements for New Connection, Move Meter
     * and Additional Load journeys
     */
    @FindBy(id="propertyType")
    WebElementFacade propertyTypeDropdown;

    @FindBy(id="heatingMethod")
    WebElementFacade heatingTypeDropdown;

    @FindBy(id="mpanNumber")
    WebElementFacade mpanNumber;

    @FindBy(id="maximumLoadRequired")
    WebElementFacade maxLoadRequired;

    @FindBy(id="phaseRequired")
    WebElementFacade phaseRequiredDropdown;

    // Move a Meter - Distance moved textbox
    @FindBy(id="distanceMoved")
    WebElementFacade distanceMoved;

    // Move a Meter - Meter dropdown
    @FindBy(id="meterType")
    WebElementFacade meterTypeDropdown;

    // Move a Meter - Phase dropdown
    @FindBy(id="phase")
    WebElementFacade moveMeterPhaseDropdown;

    // Connection location details textbox for New Connection Plots
    @FindBy(xpath="//textarea[@name='locationAdditionalInfo']")
    WebElementFacade locationDetails;

    @FindBy(id="connections-spreadsheet-link")
    WebElementFacade downloadNewConnectionsSpreadsheetLink;


    public void selectPropertyType(String propertyType)
    {
        propertyTypeDropdown.selectByVisibleText(propertyType);
    }

    public void selectHeatingType(String heatingType)
    {
        heatingTypeDropdown.selectByVisibleText(heatingType);
    }

    public void enterMpanNumber(String mpan) {
        typeInto(mpanNumber, mpan);
    }

    public void enterMaxLoadRequired(String maxLoad) {
        typeInto(maxLoadRequired, maxLoad);
    }

    public void selectPhaseRequired(String phase)
    {
        phaseRequiredDropdown.selectByVisibleText(phase);
    }

    public void enterDistanceMoved(String distance) {
        typeInto(distanceMoved, distance);
    }

    public void selectMoveMeterPhaseRequired(String phase)
    {
        moveMeterPhaseDropdown.selectByVisibleText(phase);
    }

    public void selectMeterType(String meterType)
    {
        meterTypeDropdown.selectByVisibleText(meterType);
    }

    public void clickEnterDetailsButtonForConnection(String connection) {
        $("//div[contains(text(), '%s')]/../a[@id='connection-details-link']".replace("%s", connection)).click();

    }

    public void clickEditDetailsLinkForConnection(String connection) {
        $("//div[contains(text(), '%s')]/../a[@id='edit-connection-link']".replace("%s", connection)).click();
    }

    public void clickBusinessTypeRadioButton(String business) {
        String element_name = "businessType";
        if (business.equalsIgnoreCase("Other")) {
            element_name += "Unknown";
        } else {
            element_name += business.replaceAll(" ", "");
        }
        WebElement radioButton = getDriver().findElement(By.id(element_name));
        radioButton.click();
    }

    public void clickEvChargingRadioButton(String charger) {
        String element_name = "evChargingType";
        if (charger.equalsIgnoreCase("I don't know")) {
            element_name += "DontKnow";
        } else {
            element_name += charger.replaceAll(" ", "");
        }
        WebElement radioButton = getDriver().findElement(By.id(element_name));
        radioButton.click();
    }

    public void enterConnectionLocationDetails(String text) {
        typeInto(locationDetails, text);
    }

    public void clickDownloadNewConnectionsSpreadsheetLink() { downloadNewConnectionsSpreadsheetLink.click(); }

}
