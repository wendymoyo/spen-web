/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class OtherSignificantLoadsPage extends PageObject {

    @FindBy(id="swimmingPool")
    WebElement swimmingPoolCheckbox;

    @FindBy(id="weldingEquipment")
    WebElement weldingEquipmentCheckbox;

    @FindBy(id="largeElectricalMotors")
    WebElement largeElectricalMotorsCheckbox;

    @FindBy(id="threePhaseEvCharger")
    WebElement threePhaseEvChargerCheckbox;

    @FindBy(id="otherSignificantLoads")
    WebElement otherLoadsCheckbox;

    @FindBy(id="loadsAdditionalInfo")
    WebElementFacade otherLoadsTextbox;

    @FindBy(id="additionalLoadsRating")
    WebElementFacade otherLoadsRating;

    public void clickSwimmingPoolCheckbox() { swimmingPoolCheckbox.click(); }

    public void clickWeldingEquipmentCheckbox() { weldingEquipmentCheckbox.click(); }

    public void clickLargeElectricalMotorsCheckbox() { largeElectricalMotorsCheckbox.click(); }

    public void clickThreePhaseEvChargerCheckbox() { threePhaseEvChargerCheckbox.click(); }

    public void clickOtherLoadsCheckbox() { otherLoadsCheckbox.click(); }

    public void enterOtherLoadsInfo(String text) { otherLoadsTextbox.sendKeys(text); }

    public void enterOtherLoadsRating(String number) { otherLoadsRating.sendKeys(number); }

}
