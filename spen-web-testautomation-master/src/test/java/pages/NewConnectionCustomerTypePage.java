/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewConnectionCustomerTypePage extends PageObject {

    @FindBy(id="customerType-1")
    WebElementFacade homeownerTenant;

    @FindBy(id="customerType-2")
    WebElementFacade propertyDeveloper;

    @FindBy(id="customerType-3")
    WebElementFacade commercialBusiness;

    @FindBy(id="customerType-6")
    WebElementFacade housingAuthority;

    @FindBy(id="customerType-4")
    WebElementFacade independentConnectionProvider;

    @FindBy(id="customerType-5")
    WebElementFacade thirdPartyConsultant;

    public void clickOnHomeownerTenant() { homeownerTenant.click(); }

    public void clickOnPropertyDeveloper() { propertyDeveloper.click(); }

    public void clickOnCommercialBusiness() { commercialBusiness.click(); }

    public void clickOnHousingAuthority() { housingAuthority.click(); }

    public void clickOnIndependentConnectionProvider() { independentConnectionProvider.click(); }

    public void clickOnThirdPartyConsultant() { thirdPartyConsultant.click(); }

}
