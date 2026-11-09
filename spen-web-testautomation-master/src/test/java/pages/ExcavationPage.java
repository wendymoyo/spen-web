/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ExcavationPage extends PageObject {

    @FindBy(id="excavationTypeSPENALL")
    WebElementFacade spen;

    @FindBy(id="excavationTypeSPENPUBLIC")
    WebElementFacade customer;

    public void clickSpenWillExcavate() { spen.click(); }

    public void clickCustomerWillExcavate() { customer.click(); }
}
