package com.nopcommerce.testsuite;

import com.nopcommerce.pages.ElectronicsPage;
import com.nopcommerce.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElectronicsPageTest extends BaseTest {
    ElectronicsPage electronicsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        electronicsPage = new ElectronicsPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        electronicsPage.clickOnElectronicsMenuAndCellPhone();
        Assert.assertEquals(electronicsPage.getCellPhoneText(), "Cell phones", "Not Matching");

    }

    @Test(groups = {"smoke", "regression"})
    public void TheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        electronicsPage.clickOnElectronicsMenuAndCellPhone();
        Assert.assertEquals(electronicsPage.getCellPhoneText(), "Cell phones", "Not Matching");
        electronicsPage.clickOnListTab();
        electronicsPage.clickOnNokiaLumia1020();
        Assert.assertEquals(electronicsPage.getNokiaLumiaText(), "Nokia Lumia 1020", "Text Not Matching");
        Assert.assertEquals(electronicsPage.getPriceForNokiaLumia(), "$349.00", "Price Not Matching");
        electronicsPage.updateQuantityTo2();
        electronicsPage.setAddToCart();
        Assert.assertEquals(electronicsPage.getAddedToCartMessage(), "The product has been added to your shopping cart",
                "Not Matching");
        electronicsPage.closePopUpMessage();
        electronicsPage.clickOnGoToCart();
        Assert.assertEquals(electronicsPage.shoppingCartMessage(), "Shopping cart", "Not Matching");
        Assert.assertEquals(electronicsPage.updateQuantityMessage(), "2", "Not Matching");
        Assert.assertEquals(electronicsPage.verifyTotal(), "$698.00", "Not matching");
        electronicsPage.clickOnCheckBox();
        electronicsPage.setClickOnCheckoutBox();
        Assert.assertEquals(electronicsPage.verifyWelcomeText(), "Welcome, Please Sign In!", "Not Matching");
        electronicsPage.clickOnRegisterLink();
        Assert.assertEquals(electronicsPage.verifyRegisterText(), "Register", "Not Matching");

        electronicsPage.selectRadioButton("", By.id("gender-male"));
        electronicsPage.fillingMandatoryFields("Enter Fist Name", "Prime", By.id("FirstName"));
        electronicsPage.fillingMandatoryFields("Enter Last Name", "Testing", By.id("LastName"));
        electronicsPage.selectByDropDown("Selecting Birth Date", By.name("DateOfBirthDay"), "11");
        Thread.sleep(1000);
        electronicsPage.selectByDropDown("Selecting Birth Month", By.name("DateOfBirthMonth"), "December");
        Thread.sleep(1000);
        electronicsPage.selectByDropDown("Selecting Birth Year", By.name("DateOfBirthYear"), "1955");
        electronicsPage.randomEmailGeneratorAndSendText(By.id("Email"), "Prime", "Testing");
        electronicsPage.randomPasswordGeneratorAndSendText(By.id("Password"), "Testing");
        electronicsPage.randomPasswordGeneratorAndSendText(By.id("ConfirmPassword"), "Testing");
        electronicsPage.selectPressButton("", By.id("register-button"));

        assertAssert("Verify the message Your registration completed", electronicsPage.exptectedTextMessage("Your registration completed"),
                electronicsPage.actualTextToVerify(By.xpath("//div[@class='result' and text()='Your registration completed']")));

        electronicsPage.selectPressButton("Click on CONTINUE tab", By.xpath("//a[contains(@class, 'continue-button')]"));

        assertAssert("Verify the text Shopping card", electronicsPage.exptectedTextMessage("Shopping cart"),
                electronicsPage.actualTextToVerify(By.xpath("//h1[text()='Shopping cart']")));

        electronicsPage.selectCheckBox("click on checkbox I agree with the terms of service", By.id("termsofservice"));
        electronicsPage.selectPressButton("Click on CHECKOUT", By.id("checkout"));

        electronicsPage.selectByDropDown("Selecting Country", By.id("BillingNewAddress_CountryId"), "India");
        electronicsPage.fillingMandatoryFields("Entering city", "Nadiad", By.id("BillingNewAddress_City"));
        electronicsPage.fillingMandatoryFields("Entering Address1", "505 Ghanshyam Nagar", By.id("BillingNewAddress_Address1"));
        electronicsPage.fillingMandatoryFields("Entering Zip Code", "380011", By.id("BillingNewAddress_ZipPostalCode"));
        electronicsPage.fillingMandatoryFields("Entering Phone number", "9989711425", By.id("BillingNewAddress_PhoneNumber"));

        electronicsPage.selectPressButton("Click on CONTINUE", By.name("save"));
        electronicsPage.selectRadioButton("Click on Radio Button 2nd Day Air ($0.00)", By.id("shippingoption_2"));
        electronicsPage.selectPressButton("Click on CONTINUE", By.xpath("//button[@onclick='ShippingMethod.save()']"));

        electronicsPage.selectRadioButton("Select Radio Button Credit Card", By.id("paymentmethod_1"));
        electronicsPage.selectPressButton("click save", By.xpath("//button[@onclick='PaymentMethod.save()']"));
        electronicsPage.selectByDropDown("Select Visa From select credit card dropdown", By.id("CreditCardType"), "Visa");
        electronicsPage.fillingMandatoryFields("Enter card holder name", "Prime Testing", By.id("CardholderName"));
        electronicsPage.fillingMandatoryFields("Enter card number", "4024007105297690", By.id("CardNumber"));
        electronicsPage.selectByDropDown("Select expiry month", By.id("ExpireMonth"), "10");
        electronicsPage.selectByDropDown("Select expiry year", By.id("ExpireYear"), "2023");
        electronicsPage.fillingMandatoryFields("Entering Credit Card Code", "728", By.id("CardCode"));
        electronicsPage.selectPressButton("Click Continue", By.id("payment-info-buttons-container"));

        assertAssert("Verify Payment Method is Credit Card", electronicsPage.exptectedTextMessage("Payment Method:"),
                electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Payment Method:')]")));
        assertAssert("Verify Payment Method is Credit Card", electronicsPage.exptectedTextMessage("Credit Card"),
                electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Credit Card')]")));

        assertAssert("Verify Shipping Method” is 2nd Day Air", electronicsPage.exptectedTextMessage("Shipping Method:"),
                electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Shipping Method:')]")));
        assertAssert("Verify Shipping Method is 2nd Day Air", electronicsPage.exptectedTextMessage("2nd Day Air"),
                electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), '2nd Day Air')]")));
        assertAssert("Verify Total is $698.00", electronicsPage.exptectedTextMessage("$698.00"),
                electronicsPage.actualTextToVerify(By.xpath("(//strong[text()='$698.00'])[2]")));
        electronicsPage.selectPressButton("Click continue", By.xpath("//button[@onclick='ConfirmOrder.save()']"));

        assertAssert("Verify the Text Thank You", electronicsPage.exptectedTextMessage("Thank you"),
                electronicsPage.actualTextToVerify(By.xpath("//h1[text()='Thank you']")));
        assertAssert("Verify the message Your order has been successfully processed!",
                electronicsPage.exptectedTextMessage("Your order has been successfully processed!"),
                electronicsPage.actualTextToVerify(By.xpath("//strong[contains(text(), 'fully processed!')]")));
        electronicsPage.selectPressButton("Click continue", By.xpath("//button[@onclick='setLocation(\"/\")']"));

        assertAssert("Verify the text Welcome to our store", electronicsPage.exptectedTextMessage("Welcome to our store"),
                electronicsPage.actualTextToVerify(By.xpath("//h2[text()='Welcome to our store']")));
        electronicsPage.selectPressButton("Click on Logout link", By.linkText("Log out"));

        electronicsPage.verifyCurrentURL("https://demo.nopcommerce.com/");
    }
}