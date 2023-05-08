package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.Random;

public class ElectronicsPage extends Utility {

    @CacheLookup
    By electronicsMenu = By.xpath("//ul[@class ='top-menu notmobile']/li/a[@href = '/electronics']");

    @CacheLookup
    By cellPhone = By.xpath("//ul[@class ='top-menu notmobile']//a[@href = '/cell-phones']");
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Cell phones')]")
    WebElement getTextCellPhone;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'List')]")
    WebElement clickOnListTab;
    @CacheLookup
    @FindBy(xpath = "//h2/a[contains(text(),'Nokia Lumia 1020')]")
    WebElement clickOnNokiaLumia1020;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Nokia Lumia 1020')]")
    WebElement getTextNokiaLumia1020;
    @CacheLookup
    @FindBy(xpath = "//span[@id='price-value-20']")
    WebElement getPriceForNokiaLumia;
    @CacheLookup
    @FindBy(xpath = "//input[@id='product_enteredQuantity_20']")
    WebElement updateQuantity;
    @CacheLookup
    @FindBy(id = "add-to-cart-button-20")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement addedToCartMessage;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/span[1]")
    WebElement closeMessage;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement hoverToShoppingCart;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement clickOnGoToCart;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement shoppingCartMessage;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'(2)')]")
    WebElement quantityMessage;

    @CacheLookup
    @FindBy(xpath = "(//strong[text()='$698.00'])[2]")
    WebElement total698;

    @CacheLookup
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement clickOnCheck;
    @CacheLookup
    @FindBy
    By clickOnCheckout = By.xpath("//button[@id='checkout']");

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeMessage;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement clickRegister;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement verifyRegister;

    public void clickOnElectronicsMenuAndCellPhone() {
        Actions actions = new Actions(driver);
        Reporter.log("Click on Electronic Menu and Click on Cell Phone ");
        actions.moveToElement(driver.findElement(electronicsMenu)).moveToElement(driver.findElement(cellPhone)).click().build().perform();
    }

    public String getCellPhoneText() throws InterruptedException {
        Thread.sleep(2000);
        Reporter.log("To Verify Message  " + getTextCellPhone.toString());
        return getTextFromElement(getTextCellPhone);
    }

    public void clickOnListTab() {
        Reporter.log("Click on ListTab " + clickOnListTab.toString());
        clickOnElement(clickOnListTab);
    }

    public void clickOnNokiaLumia1020() throws InterruptedException {
        Thread.sleep(3000);
        Reporter.log("click on nokia lumia "+clickOnNokiaLumia1020);
        clickOnElement(clickOnNokiaLumia1020);
    }

    public String getNokiaLumiaText() {
        Reporter.log("get nokia text");
        return getTextFromElement(getTextNokiaLumia1020);
    }

    public String getPriceForNokiaLumia() {
    Reporter.log("get price for nokia ");
        return getTextFromElement(getPriceForNokiaLumia);
    }

    public void updateQuantityTo2() {
        Reporter.log("Clear quantity from qty field");
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        Reporter.log("Update quantity to 2 in qty field" + updateQuantity);
        sendTextToElement(updateQuantity, "2");
    }

    public void setAddToCart() {
        Reporter.log("add to the cart");
        clickOnElement(addToCart);
    }

    public String getAddedToCartMessage() {
        Reporter.log("To Verify Message  " + addedToCartMessage.toString());
        return getTextFromElement(addedToCartMessage);
    }

    public void closePopUpMessage() {
        Reporter.log("Click on Close Popup Message " + closeMessage.toString());
        clickOnElement(closeMessage);
    }

    public void clickOnGoToCart() {
        Reporter.log("Mouse Hover to Shopping cart" + hoverToShoppingCart.toString());
        mouseHoverToElement(hoverToShoppingCart);
        Reporter.log("Click on Go to Cart " + closeMessage.toString());
        clickOnElement(clickOnGoToCart);
    }

    public String shoppingCartMessage() {
        Reporter.log("shopping cart message "+ shoppingCartMessage.getText());
        return getTextFromElement(shoppingCartMessage);
    }

    public String updateQuantityMessage() {
        Reporter.log("Update Qty message "+ quantityMessage.getText());
        return getTextFromElement(quantityMessage).substring(1, 2);
    }

    public String verifyTotal() {
        Reporter.log("verified total"+total698.getText());
        return getTextFromElement(total698);
    }

    public void clickOnCheckBox() {
        Reporter.log("Click on CheckBox " + clickOnCheck.toString());
        clickOnElement(clickOnCheck);
    }

    public void setClickOnCheckoutBox() {
        Reporter.log("Set Click on CheckBox " + clickOnCheckout.toString());
        clickOnElement(clickOnCheckout);
    }

    public String verifyWelcomeText() {
        Reporter.log("verify welcome text"+welcomeMessage.getText());
        return getTextFromElement(welcomeMessage);
    }

    public void clickOnRegisterLink() {
        Reporter.log("Click on Register Link " + clickRegister.toString());
        clickOnElement(clickRegister);
    }

    public String verifyRegisterText() {
        Reporter.log("verify welcome text"+verifyRegister.getText());
        return getTextFromElement(verifyRegister);
    }

    public void fillingMandatoryFields(String message, String sendText, By by) {
        Reporter.log("Fill Mandatory Fields ");
        sendTextToElement(by, sendText);
    }

    public void selectRadioButton(String message, By by) {
        Reporter.log("Select Radio Button  ");
        clickOnElement(by);
    }

    public void selectByDropDown(String message, By by, String name) {
        Reporter.log("Select "+ name + " from Dropdown");
        selectByVisibleTextFromDropDown(by, name);
    }

    public void randomEmailGeneratorAndSendText(By by, String firstName, String lastName) {
        Random randomGenerator = new Random();
        int emailNum = randomGenerator.nextInt(9999);
        String email = firstName + "." + lastName + emailNum + "@email.com";
        sendTextToElement(by, email);
    }

    public void randomPasswordGeneratorAndSendText(By by, String lastName) {
        int passNum = 156;
        String password = lastName + "#" + passNum;
        sendTextToElement(by, password);
    }

    public void selectPressButton(String message, By by) {
        Reporter.log("Click on Press Button  " + by.toString());
        clickOnElement(by);
    }
    public String exptectedTextMessage(String expected) {
        System.out.println("Expected Text or Message is : " + expected);
        Reporter.log("To Verify Message  " + expected.toString());
        return expected;
    }

    public String actualTextToVerify(By by) {
        String actual = driver.findElement(by).getText();
        System.out.println("Actual Text or Message is : " + actual);
        Reporter.log("To Verify Message  " + actual.toString());
        return actual;
    }

    public void selectCheckBox(String message, By by) {
        Reporter.log("Select Check Box" + by.toString());
        clickOnElement(by);
    }

    public void verifyCurrentURL(String urlText) {
        String expectedUrl = urlText;
        String actualUrl = driver.getCurrentUrl();
        Reporter.log("To Verify Current Url  " );

        assertAssert("url not matching", expectedUrl, actualUrl);
    }
}
