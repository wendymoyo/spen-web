package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class ChangeConnectionLandingPage extends PageObject {

    @FindBy(id="estimated-cost")
    WebElementFacade estimatedCost;

    @FindBy(id="costEstimateTermsAccepted")
    WebElementFacade termsConditionsCheckbox;

    @FindBy(id="email")
    WebElementFacade emailTextbox;

    @FindBy(id="sendEmail")
    WebElementFacade emailEstimatedQuote;

    @FindBy(xpath="//button[text()='Close']")
    WebElementFacade closeButton;

    public Boolean isEstimatedCostDisplayed() {
        return estimatedCost.isVisible();
    }

    public Boolean isTermsAndConditionsCheckboxDisplayed() {
        return termsConditionsCheckbox.isVisible();
    }

    public void clickTermsAndConditionsCheckbox() {
        termsConditionsCheckbox.click();
    }

    public void emailEstimatedQuote(String email) {
        emailTextbox.sendKeys(email);
        emailEstimatedQuote.click();
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(closeButton).isVisible();
        closeButton.click();
    }


}
