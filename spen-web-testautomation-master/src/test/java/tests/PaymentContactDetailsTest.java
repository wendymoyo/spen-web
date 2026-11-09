/**
 * Author: Wendy Moyo
 */

package tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.PaymentContactDetailsSteps;

@RunWith(SerenityRunner.class)
public class PaymentContactDetailsTest {

    @Steps
    PaymentContactDetailsSteps paymentContactDetailsSteps;

    @Managed()
    WebDriver driver;

    @Test
    public void select_customer_is_paying_for_work() {
        paymentContactDetailsSteps.iSelectYesToPayingForWork();
    }

    @Test
    public void select_customer_is_not_paying_for_work() {
        paymentContactDetailsSteps.iSelectNoToPayingForWork();
    }

}
