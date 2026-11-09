/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.BasePage;
import pages.MoveMeterPublicRoad;

public class MoveMeterPublicRoadSteps {

    MoveMeterPublicRoad moveMeterPublicRoad;
    BasePage basePage;


    @And("I select {string} to property being more than one meter from a public road")
    public void iSelectToPropertyBeingMoreThanMeterFromAPublicRoad(String option) {
        if (option.equals("Yes")) {
            moveMeterPublicRoad.clickMoreThanOneMeterYes();
        } else {
            moveMeterPublicRoad.clickMoreThanOneMeterNo();
        }
        basePage.clickNext();
    }
}
