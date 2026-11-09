package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class DisconnectionDetailsPage extends PageObject {

    @FindBy(id="moreThanThreeConnectionsNo")
    WebElementFacade oneToThreeRadio;

    @FindBy(id="moreThanThreeConnectionsYes")
    WebElementFacade fourOrMoreRadio;

    @FindBy(id="disconnections-spreadsheet-link")
    WebElementFacade downloadDisconnectionsSpreadsheetLink;


    @FindBy(id="addDisconnectionButton")
    WebElementFacade addDisconnectionPointButton;

    public void clickOneToThreeRadioButton() { oneToThreeRadio.click(); }

    public void clickFourOrMoreRadioButton() { fourOrMoreRadio.click(); }

    public void enterMpanNumber(String plot_num, String mpan) {
        $("//input[@id='mpanNumber_%s']".replace("%s", plot_num)).sendKeys(mpan);
    }

    public void clickSameAsSiteAddressYes(String plot_num) {
        $("//*[@id='sameAddressAsSiteYes_%s']".replace("%s", plot_num)).click();
    }

    public void clickSameAsSiteAddressNo(String plot_num) {
        $("//*[@id='sameAddressAsSiteNo_%s']".replace("%s", plot_num)).click();
    }

    public void clickLocationVacantYes(String plot_num) {
        $("//*[@id='locationVacantYes_%s']".replace("%s", plot_num)).click();
    }

    public void clickLocationVacantNo(String plot_num) {
        $("//*[@id='locationVacantNo_%s']".replace("%s", plot_num)).click();
    }

    public Boolean isMpanErrorMessageDisplayed(String plot_num) {
        return $("//*[@id='mpanNumber_%sError']".replace("%s", plot_num)).isVisible();
    }

    public void enterDisconnectionSitePostcode(String plot_num, String postcode) {
        $("//*[@id='addressSearch_%s']".replace("%s", plot_num)).sendKeys(postcode);
    }

    public void selectFirstOptionAddressFromList(String plot_num) {
        $("//li[@id='addressSearch_%s__option--0']".replace("%s", plot_num)).click();
    }

    public void selectAddressFromList(String plot_num, String address) {
        $("//li[contains(text(),'%s']".replace("%s", address)).click();
    }

    public String getStreetName(String plot_num) {
        return $("//*[@id='street_%s']".replace("%s", plot_num)).getValue();
    }

    public void enterHouseNumber(String plot_num, String number) {
        $("//*[@id='buildingNoOrName_%s']".replace("%s", plot_num)).sendKeys(number);
    }

    public void enterStreetName(String plot_num, String name) {
        $("//*[@id='street_%s']".replace("%s", plot_num)).sendKeys(name);
    }

    public void enterTownName(String plot_num, String name) {
        $("//*[@id='town_%s']".replace("%s", plot_num)).sendKeys(name);
    }

    public void enterPostcode(String plot_num, String postcode) {
        $("//*[@id='postcode_%s']".replace("%s", plot_num)).sendKeys(postcode);
    }

    public void enterDisconnectionAddressManually(String plot_num, String house, String street, String town, String postcode) {
        enterHouseNumber(plot_num, house);
        enterStreetName(plot_num, street);
        enterTownName(plot_num, town);
        enterPostcode(plot_num, postcode);
    }

    public void selectCountyFromDropdown(String plot_num, String county) {
        $("//*[@id='area_%s']".replace("%s", plot_num)).selectByVisibleText(county);
    }

    public void clickDeleteDisconnectionPoint(String plot_num) {
        $("//*[@id='delete-modal-show_%s']".replace("%s", plot_num)).click();
    }

    public void clickAddDisconnectionPointButton() { addDisconnectionPointButton.click(); }

    public void clickDownloadDisconnectionsSpreadsheetLink() { downloadDisconnectionsSpreadsheetLink.click(); }





}
