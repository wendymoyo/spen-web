/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewConnectionsPage extends PageObject {

    @FindBy(xpath="//h2[contains(text(), 'Connections')]")
    WebElementFacade pageHeader;

    @FindBy(id="OneToFourConnections")
    WebElementFacade oneToFour;

    @FindBy(id="FiveOrMoreConnections")
    WebElementFacade fiveOrMore;

    @FindBy(id="houseConnections")
    WebElementFacade houseConnectionPlots;

    @FindBy(id="flatConnections")
    WebElementFacade flatConnectionPlots;

    @FindBy(id="landlordConnections")
    WebElementFacade landlordConnectionPlots;

    @FindBy(id="temporaryConnections")
    WebElementFacade temporaryConnectionPlots;

    @FindBy(id="commercialConnections")
    WebElementFacade commercialConnectionPlots;

    @FindBy(id="multipleEvChargePoints")
    WebElementFacade multipleEvChargePoints;

    public Boolean isPageHeaderDisplayed() {
        return pageHeader.isDisplayed();
    }

    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public void clickOnOneToFourConnections() { oneToFour.click(); }

    public void clickOnFiveOrMoreConnections() { fiveOrMore.click(); }

    public void enterHouseConnectionPlots(String number) {
        typeInto(houseConnectionPlots, number);
    }

    public void enterFlatConnectionPlots(String number) {
        typeInto(flatConnectionPlots, number);
    }

    public void enterLandlordConnectionPlots(String number) {
        typeInto(landlordConnectionPlots, number);
    }

    public void enterTemporaryConnectionPlots(String number) {
        typeInto(temporaryConnectionPlots, number);
    }

    public void enterCommercialConnectionPlots(String number) {
        typeInto(commercialConnectionPlots, number);
    }

    public void enterMultipleEvChargePoints(String number) {
        typeInto(multipleEvChargePoints, number);
    }


}
