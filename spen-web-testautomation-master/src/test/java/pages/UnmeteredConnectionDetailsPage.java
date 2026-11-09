package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class UnmeteredConnectionDetailsPage extends PageObject {

    @FindBy(id="streetLightingPhase")
    WebElementFacade streetLightPhaseRequiredDropdown;

    @FindBy(id="streetLightingCount")
    WebElementFacade streetLightCount;

    @FindBy(id="clear-street-lights-link")
    WebElementFacade clearStreetLightsLink;

    @FindBy(id="advertisingBoardPhase")
    WebElementFacade advertisingBoardDropdown;

    @FindBy(id="advertisingBoardCount")
    WebElementFacade advertisingBoardCount;

    @FindBy(id="advertising-board-link")
    WebElementFacade clearAdvertisingBoardLink;

    @FindBy(id="controlPillarPhase")
    WebElementFacade controlPillarPhaseDropdown;

    @FindBy(id="controlPillarCount")
    WebElementFacade controlPillarCount;

    @FindBy(id="control-pillar-link")
    WebElementFacade clearControlPillarLink;

    @FindBy(id="otherEquipmentPhase")
    WebElementFacade otherEquipmentPhaseDropdown;

    @FindBy(id="otherEquipmentCount")
    WebElementFacade otherEquipmentCount;

    @FindBy(id="otherEquipmentInfo")
    WebElementFacade otherEquipmentInfo;

    @FindBy(id="coreMpan")
    WebElementFacade mpanNumber;

    @FindBy(id="connectionAdoptedTrue")
    WebElementFacade connectionAdoptedYes;

    @FindBy(id="connectionAdoptedFalse")
    WebElementFacade connectionAdoptedNo;

    public void selectStreetLightPhaseRequired(String streetLightPhase)
    {
        streetLightPhaseRequiredDropdown.selectByVisibleText(streetLightPhase);
    }

    public void enterStreetLightCount(String streetLightNumber)
    {
        streetLightCount.sendKeys(streetLightNumber);
    }

    public void clickOnClearStreetLightsLink()
    {
        clearStreetLightsLink.click();
    }

    public void selectAdvertisingBoardPhaseRequired(String advertisingPhase)
    {
        advertisingBoardDropdown.selectByVisibleText(advertisingPhase);
    }

    public void enterAdvertisingBoardCount(String advertisingBoardNumber)
    {
        advertisingBoardCount.sendKeys(advertisingBoardNumber);
    }

    public void clickOnClearAdvertisingBoardLink()
    {
        clearAdvertisingBoardLink.click();
    }

    public void selectControlPillarPhaseRequired(String controlPillarPhase)
    {
        controlPillarPhaseDropdown.selectByVisibleText(controlPillarPhase);
    }

    public void enterControlPillarCount(String controlPillarNumber)
    {
        controlPillarCount.sendKeys(controlPillarNumber);
    }

    public void clickOnClearControlPillarLink()
    {
        clearControlPillarLink.click();
    }

    public void selectOtherEquipmentPhaseRequired(String otherEquipmentPhase)
    {
        otherEquipmentPhaseDropdown.selectByVisibleText(otherEquipmentPhase);
    }

    public void enterOtherEquipmentCount(String otherEquipmentNumber)
    {
        otherEquipmentCount.sendKeys(otherEquipmentNumber);
    }

    public void enterOtherEquipmentInfo(String otherEquipmentText)
    {
        otherEquipmentInfo.sendKeys(otherEquipmentText);
    }

    public void enterMpanNumber(String mpan)
    {
        mpanNumber.sendKeys(mpan);
    }

    public void clickOnConnectionAdoptedYes()
    {
        connectionAdoptedYes.click();
    }

    public void clickOnConnectionAdoptedNo()
    {
        connectionAdoptedNo.click();
    }

}
