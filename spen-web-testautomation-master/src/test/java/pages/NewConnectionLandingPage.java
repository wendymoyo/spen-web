/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewConnectionLandingPage extends PageObject {

    // ICP Landing page alert
    @FindBy(css="div.alert[style='--alert-color: var(--tertiary-dark); undefined']")
    WebElementFacade icpLandingPageAlert;

    @FindBy(id="cicadminnorth-link")
    WebElementFacade adminNorthEmailLink;

    @FindBy(id="cicadminsouth-link")
    WebElementFacade adminSouthEmailLink;

    @FindBy(id="land-rights-link")
    WebElementFacade landRightsLink;

    @FindBy(id="ocp-link")
    WebElementFacade otherConnectionProvidersLink;

    @FindBy(xpath="//h2")
    WebElementFacade pageHeader;


    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public Boolean isIcpAlertDisplayed() {
        return icpLandingPageAlert.isVisible();
    }

    public Boolean isAdminNorthEmailLinkDisplayed() {
        return adminNorthEmailLink.isVisible();
    }

    public Boolean isAdminSouthEmailLinkDisplayed() {
        return adminSouthEmailLink.isVisible();
    }

    public Boolean isLandRightsLinkDisplayed() {
        return landRightsLink.isVisible();
    }

    public Boolean isOtherConnectionProvidersLinkDisplayed() {
        return otherConnectionProvidersLink.isVisible();
    }

}
