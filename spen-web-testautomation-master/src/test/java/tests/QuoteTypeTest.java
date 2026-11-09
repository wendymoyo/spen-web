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
import steps.QuoteTypeSteps;

@RunWith(SerenityRunner.class)
public class QuoteTypeTest {

    @Steps
    QuoteTypeSteps quoteTypeSteps;

    @Managed()
    WebDriver driver;

    @Test
    public void select_formal_quote() {
        quoteTypeSteps.iSelectFormalQuoteType();
    }

    @Test
    public void select_informal_quote() {
        quoteTypeSteps.iSelectInformalQuoteType();
    }
}
