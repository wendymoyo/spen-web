/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChangeConnectionOptionsPage extends PageObject {

    @FindBy(id="question-01")
    WebElementFacade changeOptionOne;

    @FindBy(id="question-02")
    WebElementFacade changeOptionTwo;

    @FindBy(id="question-03")
    WebElementFacade changeOptionThree;

    @FindBy(id="question-04")
    WebElementFacade changeOptionFour;

    public void clickOnChangeOptionOne() { changeOptionOne.click(); }

    public void clickOnChangeOptionTwo() { changeOptionTwo.click(); }

    public void clickOnChangeOptionThree() { changeOptionThree.click(); }

    public void clickOnChangeOptionFour() {
        changeOptionFour.click();
    }

}
