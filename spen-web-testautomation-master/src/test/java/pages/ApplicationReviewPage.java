/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ApplicationReviewPage extends PageObject {

    @FindBy(id="link-applicant-details")
    WebElementFacade applicantDetailsEditLink;

    @FindBy(id="link-site-address")
    WebElementFacade siteAddressEditLink;

    @FindBy(xpath="//div[contains(text(), 'Quotation type')]/../div[contains(text(), 'estimate')]")
    WebElementFacade quoteType;

    @FindBy(id="link-excavation:")
    WebElementFacade excavationEditLink;

    @FindBy(xpath="//div[contains(text(), 'Excavation')]/../div[contains(text(), 'excavate')]")
    WebElementFacade excavation;

    @FindBy(id="link-disconnections:")
    WebElementFacade disconnectionsEditLink;

    @FindBy(id="link-move_distance:")
    WebElementFacade moveDistanceEditLink;

    @FindBy(id="link-phase_req'd:")
    WebElementFacade phaseRequiredEditLink;

    @FindBy(id="link-meter_type:")
    WebElementFacade meterTypeEditLink;

    @FindBy(id="link-preferred_date:")
    WebElementFacade preferredDateEditLink;

    @FindBy(id="link-connection-details")
    WebElementFacade connectionDetailsEditLink;

    @FindBy(id="link-contact-preferences")
    WebElementFacade additionalInfoEditLink;

    @FindBy(xpath="//h4/strong[text()='Formal Quotation Validity']")
    WebElementFacade formalQuoteValidityHeader;

    @FindBy(xpath="//h4/strong[text()='Land Consensus']")
    WebElementFacade landConsensusHeader;

    public Boolean isApplicantDetailsEditLinkDisplayed() {
        return applicantDetailsEditLink.isDisplayed();
    }

    public Boolean isHeaderDisplayed(String headerName) {
        return $("//h3[text()='%s']".replace("%s", headerName)).isVisible();
    }

    public Boolean isSectionHeaderDisplayed(String sectionName) {
        return $("//h4[contains(text(), '%s')]".replace("%s", sectionName)).isVisible();
    }

    public String getQuoteType() {
        return quoteType.getText();
    }

    public String getExcavationText() {
        return excavation.getText();
    }

    public Boolean isSiteAddressEditLinkDisplayed() {
        return siteAddressEditLink.isDisplayed();
    }

    public Boolean isUnmeteredConnectionDetailsEditLinkDisplayed() {
        return connectionDetailsEditLink.isVisible();
    }

    public Boolean isExcavationEditLinkDisplayed() { return excavationEditLink.isDisplayed(); }

    public Boolean isDisconnectionsEditLinkDisplayed() {
        return disconnectionsEditLink.isDisplayed();
    }

    public Boolean isMoveDistanceEditLinkDisplayed() {
        return moveDistanceEditLink.isDisplayed();
    }

    public Boolean isPhaseRequiredEditLinkDisplayed() {
        return phaseRequiredEditLink.isDisplayed();
    }

    public Boolean isMeterTypeEditLinkDisplayed() {
        return meterTypeEditLink.isDisplayed();
    }

    public Boolean isPreferredDateEditLinkDisplayed() {
        return preferredDateEditLink.isDisplayed();
    }

    public Boolean isAdditionalInfoEditLinkDisplayed() {
        return additionalInfoEditLink.isDisplayed();
    }

    public Boolean isFormalQuoteValidityHeaderDisplayed() {
        return formalQuoteValidityHeader.isDisplayed();
    }

    public Boolean isLandConsensusHeaderDisplayed() {
        return landConsensusHeader.isDisplayed();
    }

    public void clickEditDetailsLinkForSection(String section) {
        $("//div[contains(text(), '%s')]/../a[text()='Edit']".replace("%s", section)).click();
    }

}
