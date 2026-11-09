/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.NewConnectionPropertyTypePage;

public class NewConnectionPropertyTypeSteps {

    NewConnectionPropertyTypePage newConnectionPropertyTypePage;

    /*
     * This code selects any of the New Connection property types after selecting
     * either House, Flat, Commercial or EV Charger connection options.
     *
     */
    @Step
    @And("I select {string} property type option")
    public void iSelectPropertyTypeOption(String option) {
        switch(option) {
            case "1 Property":
            case "Up to 69kva":
            case "Additional flat to existing property":
            case "A new connection for a domestic EV Charging Point":
                newConnectionPropertyTypePage.clickOnOptionOne();
                break;
            case "2-4 Properties":
            case "More than 69kva but less than 250kva":
            case "New build 1 - 4 flats":
            case "A new connection for a commercial EV Charging Point":
                newConnectionPropertyTypePage.clickOnOptionTwo();
                break;
            case "More than 4 Properties":
            case "More than 250kva":
            case "New Build more than 4 flats":
                newConnectionPropertyTypePage.clickOnOptionThree();
                break;
            case "New build containing flats & Commercial":
                newConnectionPropertyTypePage.clickOnOptionFour();
                break;
            case "Conversion of old Commercial building into flats":
                newConnectionPropertyTypePage.clickOnOptionFive();
                break;
            default:
                System.out.println("Incorrect property type provided!");
        }
    }

}
