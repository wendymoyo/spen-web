/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class PaymentContactDetailsPage extends PageObject {

    @FindBy(id="payingForWorkYes")
    WebElement payingForWorkYes;

    @FindBy(id="payingForWorkNo")
    WebElement payingForWorkNo;

    @FindBy(id="customerTypeYes")
    WebElement companyPayingYes;

    @FindBy(id="customerTypeNo")
    WebElement companyPayingNo;

    @FindBy(id="companyName")
    WebElementFacade companyName;

    @FindBy(id="vatNumber")
    WebElementFacade vatNumber;

    @FindBy(id="crnNumber")
    WebElementFacade companyRegNumber;

    public void clickPayingForWorkYes() { payingForWorkYes.click(); }

    public void clickPayingForWorkNo() { payingForWorkNo.click(); }

    public void clickCompanyPayingForWorkYes() { companyPayingYes.click(); }

    public void clickCompanyPayingForWorkNo() { companyPayingNo.click(); }

    public void enterCompanyName(String text) { companyName.sendKeys(text); }

    public void enterVatNumber(String text) { vatNumber.sendKeys(text); }

    public void enterCompanyRegNumber(String text) { companyRegNumber.sendKeys(text); }

}
