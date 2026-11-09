package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://devccp.spenergynetworks.co.uk/change-connection/work-type")
public class ChangeConnectionWorkTypePage extends PageObject{
	
	@FindBy(id="AP-SM-link")
	WebElement movemeterpoint;
	
	@FindBy(id="ADL-link")
	WebElement additionalLoad;
	

	@FindBy(id="DS-link")
	WebElement disconnection;
	
	@FindBy(id="DV-link")
	WebElement diversion;
	
	@FindBy(id="UC-link")
	WebElement unmeteredConnection;
	
	@FindBy(id="solar-panel-link")
	WebElement solarpanel;

	// Breadcrumb navigation headers
	@FindBy(xpath="//li/a[text()='Home']")
	WebElementFacade homeNavigationHeader;

	@FindBy(id="getting-connected-link")
	WebElementFacade gettingConnectedNavigationHeader;

	@FindBy(id="existing-connections-link")
	WebElementFacade existingConnectionHeader;
	

	public void clickOnMoveMeter()
	{
		movemeterpoint.click();
	}
		
	public void clickOnAdditionalLoad()
	{
		additionalLoad.click();
	}

	public void clickOnDisconnection()
	{
		disconnection.click();
	}
	
	public void clickOnDiversion()
	{
		diversion.click();
	}
		
	public void clickOnUnmetered()
	{
		unmeteredConnection.click();
	}
	
	public void clickSolarPanel()
	{
		solarpanel.click();
	}

	public Boolean isHomeNavigationHeaderDisplayed() {
		return homeNavigationHeader.isDisplayed();
	}

	public Boolean isGettingConnectedNavigationHeaderDisplayed() {
		return gettingConnectedNavigationHeader.isDisplayed();
	}

	public Boolean isExistingConnectionHeaderDisplayed() {
		return existingConnectionHeader.isDisplayed();
	}
		

}
