/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.ChangeConnectionOptionsPage;

public class ChangeConnectionOptionsSteps {

    ChangeConnectionOptionsPage changeConnectionOptionsPage;


    /*
     * This code selects any of the Change Connection types after selecting
     * either Diversion, Disconnection, Add Load or Unmetered connection options.
     *
     */
    @Step
    @And("I select {string} change connection option")
    public void iSelectChangeConnectionOption(String option) {
        switch(option) {
            case "Check to see if my existing connection is capable of taking an increased load":
            case "Disconnect a single standard supply":
            case "Moving underground cables or overhead powerlines":
            case "New unmetered supply on a new street":
                changeConnectionOptionsPage.clickOnChangeOptionOne();
                break;
            case "Increase the capacity of my connection from single to three phase":
            case "Disconnect multiple standard supplies":
            case "New unmetered supply on an existing street":
                changeConnectionOptionsPage.clickOnChangeOptionTwo();
                break;
            case "Increase the capacity of my connection":
            case "Disconnect a high-voltage supply":
                changeConnectionOptionsPage.clickOnChangeOptionThree();
                break;
            case "I would like to alter my capacity agreement":
            case "Disconnect electrical equipment, cable or plant":
                changeConnectionOptionsPage.clickOnChangeOptionFour();
                break;
            default:
                System.out.println("Incorrect change connection option provided!");
        }
    }

}
