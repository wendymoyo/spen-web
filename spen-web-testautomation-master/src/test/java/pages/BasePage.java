/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage extends PageObject {

    @FindBy(id="postcode")
    WebElementFacade postcodeTextbox;

    @FindBy(id="check-now-button")
    WebElement checkNowButton;

    @FindBy(id="apply-now-button")
    WebElement applyNowButton;

    @FindBy(id="continue-application-link")
    WebElement continueApplicationButton;

    @FindBy(id="previous-button")
    WebElement backButton;

    @FindBy(id="next-button")
    WebElement nextButton;

    @FindBy(xpath="//h2")
    WebElementFacade pageHeader;

    // Progress bar navigation
    @FindBy(xpath="//div[contains(@class, 'stepper-icon-current')]/../p")
    WebElement currentNavigationIcon;

    @FindBy(id="footer-navigation")
    WebElementFacade footerNavigation;

    @FindBy(xpath="//div[@id='footer-links']/a")
    WebElement footerLinks;

    @FindBy(xpath="//div[@id='footer-social-icons']/a")
    WebElementFacade footerSocialIcons;

    @FindBy(id="footer-copyright")
    WebElementFacade footerCopyright;


    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public void clickBack() { backButton.click(); }

    public Boolean isBackButtonDisplayed() {
        return backButton.isDisplayed();
    }

    public void clickNext() {
        withTimeoutOf(Duration.ofSeconds(3)).waitFor(nextButton).isVisible();
        nextButton.click();
    }

    public void enterPostcode(String postcode) {
        typeInto(postcodeTextbox, postcode);
    }

    public void clickCheckNow() { checkNowButton.click(); }

    public void clickApplyNow() { applyNowButton.click(); }

    public void clickContinueApplication() { continueApplicationButton.click(); }

    public String getCurrentProgressBarNavigation() {
        return currentNavigationIcon.getText();
    }

    public Boolean checkPageHeaderIsDisplayed(String header) {
        return $("//h2[contains(text(), '%s')]".replace("%s", header)).isVisible();
    }

    public Boolean isFooterNavigationDisplayed() {
        return footerNavigation.isVisible();
    }

    public Integer getFooterLinksCount() {
        return getDriver().findElements(By.xpath("//div[@id='footer-links']/a")).size();
    }

    public Boolean isSocialMediaIconsDisplayed() {
        return footerSocialIcons.isVisible();
    }

    public Integer getFooterSocialIconsCount() {
        return getDriver().findElements(By.xpath("//div[@id='footer-social-icons']/a")).size();
    }

}
