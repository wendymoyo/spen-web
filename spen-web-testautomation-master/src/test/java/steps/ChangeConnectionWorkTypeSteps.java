package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import pages.ChangeConnectionWorkTypePage;


public class ChangeConnectionWorkTypeSteps {

	ChangeConnectionWorkTypePage changeConnectionWorkTypePage;

	@Step
	@Given("the user is on the change connection page")
	public void launchChangeConnectionApp() {
		changeConnectionWorkTypePage.open();
	}

	@Step
	@And("I select {string} application")
	public void iSelectApplication(String appName) {
		Serenity.setSessionVariable("appName").to(appName);
		switch(appName) {
			case "Move Meter":
				changeConnectionWorkTypePage.clickOnMoveMeter();
				break;
			case "Additional Load":
				changeConnectionWorkTypePage.clickOnAdditionalLoad();
				break;
			case "Disconnection":
				changeConnectionWorkTypePage.clickOnDisconnection();
				break;
			case "Diversion":
				changeConnectionWorkTypePage.clickOnDiversion();
				break;
			case "Unmetered Connection":
				changeConnectionWorkTypePage.clickOnUnmetered();
				break;
			case "Add Solar Panel":
				changeConnectionWorkTypePage.clickSolarPanel();
				break;
			default:
				System.out.println("Incorrect application name provided!");
		}
	}
}
