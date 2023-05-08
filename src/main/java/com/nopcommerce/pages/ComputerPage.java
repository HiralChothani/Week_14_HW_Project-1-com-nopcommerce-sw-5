package com.nopcommerce.pages;


import com.nopcommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//ul[@class ='top-menu notmobile']/li/a[@href = '/computers']")
    WebElement clickComputer;
    @CacheLookup
    @FindBy(xpath = "//ul[@class ='top-menu notmobile']//a[@href = '/desktops']")
    WebElement clickDesktop;

    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement sort;

      @CacheLookup
            @FindBy(xpath = "//h2[@class='product-title']")
            List<WebElement> listProducts;

    public void clickOnComputerAndDesktop() {
        Reporter.log("Clicking on computer " + clickComputer.getText() + " then desktop " + clickDesktop.getText());

        Actions actions = new Actions(driver);
        actions.moveToElement(clickComputer).moveToElement(clickDesktop).click().build().perform();
    }

    public void sortComputerDesktops(String value) {
        Reporter.log("Sorting computer desktops " + sort.getText());
        selectByValueFromDropDown(sort, value);
    }
    public ArrayList gettingListBeforeSorting() {
        Reporter.log("Verifying list before sorting " + listProducts);
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Position");
        //selectByVisibleTextFromDropDown(By.xpath("//h2"),"Position");

        ArrayList<String> beforeSortingZToA = new ArrayList<>();
        for (WebElement list : listProducts) {
            beforeSortingZToA.add(list.getText());
        }
        return beforeSortingZToA;

    }

    public ArrayList gettingListOfProduct() {
        Reporter.log("Verifying list after sorting " + listProducts);
        ArrayList<String> sortedList = new ArrayList<>();
        for (WebElement list : listProducts) {
            sortedList.add(list.getText());
        }
        return sortedList;
    }
    }

