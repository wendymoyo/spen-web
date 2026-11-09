/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TargetDateContactPrefPage extends PageObject {

    @FindBy(id="haveWorkStartDateYes")
    WebElementFacade workStartDateYes;

    @FindBy(id="haveWorkStartDateNo")
    WebElementFacade workStartDateNo;

    @FindBy(xpath="//input[@type='date']")
    WebElementFacade dateInput;

    @FindBy(id="preferredContactMethodEmail")
    WebElementFacade emailContact;

    @FindBy(id="preferredContactMethodPhone")
    WebElementFacade phoneContact;

    @FindBy(id="preferredContactMethodPost")
    WebElementFacade postContact;

    @FindBy(id="additionalInfo")
    WebElementFacade additionalInfo;


    public void clickWorkStartDateYes() { workStartDateYes.click(); }

    public void clickWorkStartDateNo() { workStartDateNo.click(); }

    public void enterWorkStartDate(String date) { typeInto(dateInput, date); }

    public void clickEmailContactMethod() { emailContact.click(); }

    public void clickPhoneContactMethod() { phoneContact.click(); }

    public void clickPostContactMethod() { postContact.click(); }

    public void enterAdditionalInfo(String info) { additionalInfo.sendKeys(info); }


}
