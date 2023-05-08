package com.nopcommerce.testsuite;

import com.nopcommerce.pages.ComputerPage;
import com.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComputerPageTest extends BaseTest {
    ComputerPage computersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        computersPage = new ComputerPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        computersPage.clickOnComputerAndDesktop();
        computersPage.sortComputerDesktops("6");
        Thread.sleep(2000);
        Assert.assertEquals(computersPage.gettingListOfProduct(), computersPage.gettingListBeforeSorting());
    }

}
