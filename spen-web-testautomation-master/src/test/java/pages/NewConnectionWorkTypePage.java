/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://devccp.spenergynetworks.co.uk/new-connection/work-type")
public class NewConnectionWorkTypePage extends PageObject {

    @FindBy(id="H01-link")
    WebElement house;

    @FindBy(id="F01-link")
    WebElement flat;

    @FindBy(id="C01-link")
    WebElement commercial;

    @FindBy(id="EV01-link")
    WebElement commercialEvCharger;

    public void clickOnHouse()
    {
        house.click();
    }

    public void clickOnFlat() { flat.click(); }

    public void clickOnCommercial()
    {
        commercial.click();
    }

    public void clickOnCommercialEvCharger()
    {
        commercialEvCharger.click();
    }
}
