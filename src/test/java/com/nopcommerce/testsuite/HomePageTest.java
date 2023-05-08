package com.nopcommerce.testsuite;


import com.nopcommerce.pages.HomePage;
import com.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyPageNavigation() {

        String actClick = homePage.selectMenu("Computers");
        String expClick = "Computers";
        Assert.assertEquals(actClick, expClick, "Not matching");

    }
}
