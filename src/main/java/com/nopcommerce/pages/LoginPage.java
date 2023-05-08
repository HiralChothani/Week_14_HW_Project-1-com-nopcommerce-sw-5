package com.nopcommerce.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class LoginPage extends Utility {

    @FindBy(xpath = "//a[@class = 'ico-login']")
    WebElement loginTab;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(name = "Password")
    WebElement passwordField;
    @FindBy(xpath = "//div/button[@class='button-1 login-button']")
    WebElement loginButton;



    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;
    public String getWelcomeText(){
        String message = getTextFromElement(welcomeText);
        Reporter.log("To Verify Message  " + message.toString());
        return message;
    }

    public void enterEmailId(String email){
        Reporter.log("enter email id"+ email );
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
    }

    public void enterPassword(String password){
        Reporter.log("enter password "+ password);
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void clickOnLoginTab(){
        Reporter.log("click on login tab"+loginTab.getText());
        clickOnElement(loginTab);
       CustomListeners.test.log(Status.PASS,"Click on loginTab");
    }
    public void clickOnLoginButton(){
        Reporter.log("click on login tab"+loginTab.getText());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

    public String getErrorMessage(){
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS,"Get errorMessage");
        return message;
    }
}
