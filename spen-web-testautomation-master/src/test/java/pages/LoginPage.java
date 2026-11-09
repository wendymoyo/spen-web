/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(name="username")
    WebElementFacade emailTextbox;

    @FindBy(name="password")
    WebElementFacade passwordTextbox;

    @FindBy(xpath="//button[contains(text(), 'Forgot Password')]")
    WebElementFacade forgotPasswordLink;

    @FindBy(css="button.btn.btn-primary")
    WebElementFacade loginButton;

    @FindBy(xpath="//h1[contains(text(), 'Account Login')]")
    WebElementFacade loginPageHeader;

    @FindBy(xpath="//button[@class='osano-cm-dialog__close osano-cm-close']")
    WebElementFacade closeCookiesDialog;

    public void enterUserLoginDetails(String email, String password) {
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
    }

    public void clickForgotPassword() { forgotPasswordLink.click(); }

    public void clickLoginButton() { loginButton.click(); }

    public Boolean isCookiesDialogVisible() {
        return closeCookiesDialog.isVisible();
    }

    public void closeCookiesDialog() { closeCookiesDialog.click(); }

    public Boolean isLoginPageDisplayed() {
        return loginPageHeader.isVisible();
    }

}
