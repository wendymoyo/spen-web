/**
 * Author: Wendy Moyo
 *
 * This contains the page elements for Applicant details, Payment contact details
 * and Site contact details.
 *
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ContactDetailsPage extends PageObject {

    @FindBy(id="title")
    WebElementFacade titleDropdown;

    @FindBy(id="firstName")
    WebElementFacade firstName;

    @FindBy(id="lastName")
    WebElementFacade lastName;

    @FindBy(id="companyName")
    WebElementFacade businessName;

    @FindBy(id="mobile")
    WebElementFacade mobile;

    @FindBy(id="phone")
    WebElementFacade landline;

    @FindBy(id="email")
    WebElementFacade email;

    @FindBy(id="sameAddressAsSiteYes")
    WebElementFacade sameAddressAsSiteYes;

    @FindBy(id="sameAddressAsSiteNo")
    WebElementFacade sameAddressAsSiteNo;

    public void selectTitle(String title)
    {
        titleDropdown.selectByVisibleText(title);
    }

    public void enterFirstName(String text) {
        typeInto(firstName, text);
    }

    public void enterLastName(String text) {
        typeInto(lastName, text);
    }

    public void enterBusinessName(String text) {
        typeInto(businessName, text);
    }

    public void enterMobileNumber(String number) {
        typeInto(mobile, number);
    }

    public void enterLandlineNumber(String number) {
        typeInto(landline, number);
    }

    public void enterEmail(String text) {
        typeInto(email, text);
    }

    public void clickSameAddressAsSiteYes() { sameAddressAsSiteYes.click(); }

    public void clickSameAddressAsSiteNo() { sameAddressAsSiteNo.click(); }


}
