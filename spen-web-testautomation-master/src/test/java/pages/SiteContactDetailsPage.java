/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class SiteContactDetailsPage extends PageObject {

    @FindBy(id="siteContactTrue")
    WebElement siteContactYes;

    @FindBy(id="siteContactFalse")
    WebElement siteContactNo;

    @FindBy(id="position")
    WebElement position;

    public void clickSiteContactYes() { siteContactYes.click(); }

    public void clickSiteContactNo() { siteContactNo.click(); }

    public void enterPosition(String text) { position.sendKeys(text); }

}
