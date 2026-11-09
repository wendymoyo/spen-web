/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class QuoteTypePage extends PageObject {

    @FindBy(id="quotationTypeFormal")
    WebElement formalQuote;

    @FindBy(id="quotationTypeInformal")
    WebElement informalQuote;

    public void clickFormalQuote() { formalQuote.click(); }

    public void clickInformalQuote() { informalQuote.click(); }

}
