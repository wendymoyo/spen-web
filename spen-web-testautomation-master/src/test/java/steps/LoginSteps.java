package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Step
    @And("I login using email {string} and password {string}")
    public void iLoginUsingEmailAndPassword(String email, String password) {
        if (loginPage.isLoginPageDisplayed()) {
            if (loginPage.isCookiesDialogVisible()) {
                loginPage.closeCookiesDialog();
            }
            loginPage.enterUserLoginDetails(email, password);
            loginPage.clickLoginButton();
        }
    }
}
