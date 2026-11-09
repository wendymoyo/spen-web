/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class NewConnectionPropertyTypePage extends PageObject {

    @FindBy(id="question-1")
    WebElement optionOne;

    @FindBy(id="question-2")
    WebElement optionTwo;

    @FindBy(id="question-3")
    WebElement optionThree;

    @FindBy(id="question-4")
    WebElement optionFour;

    @FindBy(id="question-5")
    WebElement optionFive;

    public void clickOnOptionOne()
    {
        optionOne.click();
    }

    public void clickOnOptionTwo()
    {
        optionTwo.click();
    }

    public void clickOnOptionThree()
    {
        optionThree.click();
    }

    public void clickOnOptionFour()
    {
        optionFour.click();
    }

    public void clickOnOptionFive()
    {
        optionFive.click();
    }
}
