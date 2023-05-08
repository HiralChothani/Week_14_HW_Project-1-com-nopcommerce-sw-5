package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.Random;

public class ShoppingCartPage extends Utility {

    @FindBy(xpath = "//a[@href='/computers']")
    WebElement clickComputer;

    @FindBy(xpath = "//a[@title='Show products in category Desktops']")
    WebElement clickDesktop;
    @FindBy(id = "products-orderby")
    WebElement sort;

    @FindBy(xpath = "(//button[contains(text(),'to cart')])[1]")
    WebElement clickCart;
    //By actualVerifyText = By.xpath("//h1[contains(text(),'Build your own computer')]");
    @FindBy(name = "product_attribute_1")
    WebElement selctComputer;


    public void clickOnComputerAndDesktop() {
        Reporter.log("click on computer " + clickComputer.getText());
        clickOnElement(clickComputer);
        Reporter.log("click on computer " + clickDesktop.getText());
        clickOnElement(clickDesktop);
    }

    public void sortComputerDesktopsToAtoZ(String value) {
        Reporter.log("sort computerdesktops to AtoZ" + sort.getText());
        selectByValueFromDropDown(sort, value);
    }

    public void clickOnShoppingCart() throws InterruptedException {
        Reporter.log("click on shopping cart" + clickCart.getText());
        Thread.sleep(5000);
        clickOnElement(clickCart);
    }


    public void selectPentiumComputer(String name) {
        Reporter.log("select Pentium Computer" + selctComputer.getText());
        selectByVisibleTextFromDropDown(selctComputer, name);
    }

    public void selectByDropDown(String message, By by, String name) {
        Reporter.log("Select " + name +  " from Dropdown list");
        selectByVisibleTextFromDropDown(by, name);
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
    public void selectRadioButton(String message, By by) {
        Reporter.log("Click on Radio Button " + by.toString());
        clickOnElement(by);
    }

    public void selectCheckBox(String message, By by) {
        Reporter.log("Click on CheckBox " + by.toString());
        clickOnElement(by);
    }

    public void selectPressButton(String message, By by) {
        Reporter.log("Select Press Button " + by.toString());
        clickOnElement(by);
    }

    public void mouseHoveronShoppingCartAndClickOnGoToCart() {
        Reporter.log("Mouse Hover and Click on Shopping Cart ");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Reporter.log("Click on Go Cart Button");
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        goToCart.click();
    }

    public void changeTheQuantityTo2AndClickOnUpdateShoppingCart() {
        Reporter.log("Clear Quantity field");
        clearContent(By.xpath("//input[@class='qty-input']"));
        Reporter.log("Change The Quantity");
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Reporter.log("Click on Update Cart Button");
        clickOnElement(By.id("updatecart"));
    }

    public void fillingMandatoryFields(String message, String sendText, By by) {
        sendTextToElement(by, sendText);
    }

    public void randomEmailGeneratorAndSendText(By by, String firstName, String lastName) {
        Random randomGenerator = new Random();
        int emailNum = randomGenerator.nextInt(9999);
        String email = firstName + "." + lastName + emailNum + "@email.com";
        sendTextToElement(by, email);
    }
}

