/**
 * Author: Wendy Moyo
 *
 * This page contains the page elements for Site Address, applicant Address,
 * Payment contact address and Site contact address as they all have the same IDs.
 *
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class AddressPage extends PageObject {

    @FindBy(id="addressSearch")
    WebElement addressSearch;

    @FindBy(id="addressSearch__listbox")
    WebElementFacade addressSearchList;

    @FindBy(id="buildingNoOrName")
    WebElement houseNumberTextbox;

    @FindBy(id="street")
    WebElement streetTextbox;

    @FindBy(id="town")
    WebElement townTextbox;

    @FindBy(id="area")
    WebElementFacade countyDropdown;

    @FindBy(id="postcode")
    WebElement postcodeTextbox;


    public void enterPostcode(String postcode) {
        typeInto(addressSearch, postcode);
    }

    public void selectFirstOptionAddressFromList() {
        withTimeoutOf(Duration.ofSeconds(3)).waitFor(addressSearchList).isVisible();
        $("//li[@id='addressSearch__option--0']").click();
    }

    public void selectAddressFromList(String address) {
        withTimeoutOf(Duration.ofSeconds(3)).waitFor(addressSearchList).isVisible();
        $("//li[contains(text(),'%s')]".replace("%s", address)).click();
    }

    public void selectCountyFromDropdown(String county) {
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(countyDropdown).isCurrentlyVisible();
        countyDropdown.selectByVisibleText(county);
    }

    public String getStreetName() {
        return streetTextbox.getAttribute("value");
    }

    public void enterHouseNumber(String house) {
        typeInto(houseNumberTextbox, house);
    }

    public void enterStreetName(String street) {
        typeInto(streetTextbox, street);
    }

    public void enterTownName(String town) {
        typeInto(townTextbox, town);
    }

    public void enterAddressManually(String house, String street, String town, String postcode) {
        typeInto(houseNumberTextbox, house);
        typeInto(streetTextbox, street);
        typeInto(townTextbox, town);
        typeInto(postcodeTextbox, postcode);
    }

    public void enterUnmeteredAddressManually(String street, String town, String postcode) {
        typeInto(streetTextbox, street);
        typeInto(townTextbox, town);
        typeInto(postcodeTextbox, postcode);
    }

}
