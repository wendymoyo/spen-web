package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class ConnectionGenerationPage extends PageObject {

    @FindBy(id="includesGenerationOrStorageYes")
    WebElement generationStorageYes;

    @FindBy(id="includesGenerationOrStorageNo")
    WebElement generationStorageNo;

    @FindBy(id="generationOrStorageTechnology")
    WebElementFacade generationStorageTechDropdown;

    @FindBy(id="generationOrStorageRating")
    WebElementFacade generationStorageRating;

    public void clickGenerationStorageYes() { generationStorageYes.click(); }

    public void clickGenerationStorageNo() { generationStorageNo.click(); }

    public void selectGenerationTechnologyType(String generationTech)
    {
        generationStorageTechDropdown.selectByVisibleText(generationTech);
    }

    public void enterGenerationStorageRating(String number)
    {
        generationStorageRating.sendKeys(number);
    }

}
