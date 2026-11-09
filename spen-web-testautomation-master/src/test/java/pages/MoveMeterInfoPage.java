/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MoveMeterInfoPage extends PageObject {

    @FindBy(xpath="//h1[contains(text(), 'Moving your Electricity Meter Supply Position')]")
    WebElementFacade moveMeterPositionPageHeader;

    @FindBy(xpath="//h2[contains(text(), 'Moving a Meter Supply Position')]")
    WebElementFacade moveMeterSupplyHeader;

    @FindBy(id="diagram")
    WebElementFacade moveMeterDiagram;

    @FindBy(xpath="//*[@id='ready-to-apply']/validation-message-display/form/button")
    WebElementFacade applyNowButton;

    public Boolean isMoveMeterSupplyPositionPageHeaderDisplayed() {
        return moveMeterPositionPageHeader.isDisplayed();
    }

    public Boolean isMoveMeterDiagramDisplayed() {
        return moveMeterDiagram.isDisplayed();
    }

    public void clickApplyNowButton() { applyNowButton.click(); }

}
