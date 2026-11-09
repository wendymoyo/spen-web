/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import pages.NewConnectionWorkTypePage;

public class NewConnectionSteps {

    NewConnectionWorkTypePage newConnectionWorkTypePage;

    @Step
    @Given("the user is on the new connection page")
    public void launchNewConnectionApp() {
        newConnectionWorkTypePage.open();
    }

    @Step
    @Given("I select {string} connection type")
    public void iSelectConnectionType(String connectionType) {
        Serenity.setSessionVariable("appName").to("New Connection");
        if (connectionType.equalsIgnoreCase("House")) {
            newConnectionWorkTypePage.clickOnHouse();
        } else if (connectionType.equalsIgnoreCase("Flat")) {
            newConnectionWorkTypePage.clickOnFlat();
        } else if (connectionType.equalsIgnoreCase("Commercial Premises")) {
            newConnectionWorkTypePage.clickOnCommercial();
        } else if (connectionType.equalsIgnoreCase("Commercial EV Charger")) {
            newConnectionWorkTypePage.clickOnCommercialEvCharger();
        } else {
            System.out.println("Wrong connection type provided!");
        }
    }
}
