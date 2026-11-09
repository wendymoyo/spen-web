/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class MoveMeterPublicRoad extends PageObject {

    @FindBy(id="moreThanOneMeterYes")
    WebElement moreThanOneMeterYes;

    @FindBy(id="moreThanOneMeterNo")
    WebElement moreThanOneMeterNo;

    public void clickMoreThanOneMeterYes() { moreThanOneMeterYes.click(); }

    public void clickMoreThanOneMeterNo() { moreThanOneMeterNo.click(); }

}
