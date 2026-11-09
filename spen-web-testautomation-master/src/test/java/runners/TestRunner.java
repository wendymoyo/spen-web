package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	features = "src/test/resources/features",
	glue = "steps",
	plugin = {"pretty"},
	tags = "@wendy"
		
)

public class TestRunner {


}
