package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import steps.ChangeConnectionWorkTypeSteps;

@RunWith(SerenityRunner.class)
public class ChangeConnectionWorkTypeTest {
	
	@Steps
	ChangeConnectionWorkTypeSteps changeConnectionWorkTypeSteps;
	
	@Managed()
	WebDriver driver;

	@Test
	public void should_open_change_connection_work_type_page() {
		changeConnectionWorkTypeSteps.launchChangeConnectionApp();
	}

	@Test
	public void should_click_on_MoveMeterPoint() {
		changeConnectionWorkTypeSteps.iSelectApplication("Move Meter");
	}
	
	@Test
	public void should_click_on_AdditionalLoad() {
		changeConnectionWorkTypeSteps.iSelectApplication("Additional Load");
	}

	@Test
	public void should_click_on_Disconnection() {
		changeConnectionWorkTypeSteps.iSelectApplication("Disconnection");
	}
	
	@Test
	public void should_click_on_Diversion() {
		changeConnectionWorkTypeSteps.iSelectApplication("Diversion");
	}
	
	@Test
	public void should_click_on_UnmeteredConnection() {
		changeConnectionWorkTypeSteps.iSelectApplication("Unmetered Connection");
	}
	
	@Test
	public void should_click_on_AddSolarPanel() {
		changeConnectionWorkTypeSteps.iSelectApplication("Add Solar Panel");
	}
}
