/**
 * Author: Wendy Moyo
 */

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class PortalPage extends PageObject {

    @FindBy(xpath="//h1")
    WebElementFacade pageHeader;

    @FindBy(id="basic-nav-dropdown")
    WebElementFacade userMenuDropdown;

    // Portal Change Password page
    @FindBy(xpath="//input[@name='currentPassword']")
    WebElementFacade currentPasswordTextbox;

    @FindBy(xpath="//input[@name='password']")
    WebElementFacade passwordTextbox;

    @FindBy(xpath="//input[@name='confirmPassword']")
    WebElementFacade confirmPasswordTextbox;

    @FindBy(xpath="//div[@class='MuiAlert-icon']")
    WebElementFacade changePwdAlertIcon;

    @FindBy(xpath="//div[@class='MuiAlert-message']")
    WebElementFacade changePwdAlertMsg;

    // Portal Registration page
    @FindBy(id="title")
    WebElementFacade titleDropdown;

    @FindBy(xpath="//*[@name='firstName']")
    WebElementFacade firstName;

    @FindBy(xpath="//*[@name='lastName']")
    WebElementFacade lastName;

    @FindBy(xpath="//*[@name='username']")
    WebElementFacade email;

    @FindBy(xpath="//*[@name='usernameConfirm']")
    WebElementFacade confirmEmail;

    @FindBy(xpath="//*[@name='landline']")
    WebElementFacade landline;

    @FindBy(xpath="//*[@name='mobile']")
    WebElementFacade mobile;

    @FindBy(xpath="//*[@name='company']")
    WebElementFacade company;

    @FindBy(xpath="//*[@name='passwordConfirmation']")
    WebElementFacade passwordConfirmation;

    @FindBy(xpath="//button[contains(text(), 'Save')]")
    WebElementFacade saveButton;


    public void clickUserMenuDropdown() { userMenuDropdown.click(); }

    public void enterCurrentPassword(String text) {
        typeInto(currentPasswordTextbox, text);
    }

    public void enterPassword(String text) {
        typeInto(passwordTextbox, text);
    }

    public void enterConfirmPassword(String text) {
        typeInto(confirmPasswordTextbox, text);
    }

    public Boolean isChangePasswordAlertIconDisplayed() {
        return changePwdAlertIcon.isVisible();
    }

    public String getChangePasswordAlertMsgText() {
        return changePwdAlertMsg.getText();
    }


    public void clickOnPortalButton(String text) {
//        $("//*[contains(text(), '%s')]".replace("%s", text)).click();
        WebElement button = findBy("//*[contains(text(), '%s')]".replace("%s", text));
        button.sendKeys(Keys.PAGE_DOWN);
        button.click();
    }

    public void clickSaveButton() {
        saveButton.sendKeys(Keys.PAGE_DOWN);
        saveButton.click();
    }

    public void clickButton(String text) {
        WebElement button = getDriver().findElement(By.xpath("//*[contains(text(), '%s')]".replace("%s", text)));
        button.sendKeys(Keys.PAGE_DOWN);
        button.click();
    }

    public void clickOnPortalLink(String text) {
        $("//*[contains(text(), '%s')]".replace("%s", text)).click();
    }

    public String getPageHeaderText() { return pageHeader.getText(); }

    public void enterLastName(String text) {
        lastName.sendKeys(Keys.CONTROL, Keys.chord("a")); // select all text in textbox
        lastName.sendKeys(Keys.DELETE); // delete text in textbox
        typeInto(lastName, text);
    }

    public String getLastNameText() { return lastName.getValue(); }

    public void selectTitle(String title)
    {
        titleDropdown.selectByVisibleText(title);
    }

    public void enterFirstName(String text) {
        typeInto(firstName, text);
    }

    public void enterCompanyName(String text) {
        typeInto(company, text);
    }

    public void enterMobileNumber(String number) {
        typeInto(mobile, number);
    }

    public void enterLandlineNumber(String number) {
        typeInto(landline, number);
    }

    public void enterEmail(String text) {
        typeInto(email, text);
    }

    public void enterEmailConfirmation(String text) {
        typeInto(confirmEmail, text);
    }

    public void enterPasswordConfirmation(String text) {
        typeInto(passwordConfirmation, text);
    }

    public void clickOnPortalHomeButton(String text) {
        $("//p[text()='%s']".replace("%s", text)).click();
    }

    public String getCompanyNameText() {
        return company.getValue();
    }

    public String getEmailText() {
        return email.getValue();
    }

    public String getMobileText() {
        return mobile.getValue();
    }

}

