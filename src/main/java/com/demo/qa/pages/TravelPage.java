package com.demo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.qa.base.TestBase;

public class TravelPage extends HomePage {

    //Page factory - OR:
       
    @FindBy(xpath = "//select[@name='fromPort']")
    WebElement fromValue;
    
    @FindBy(xpath = "//select[@name='toPort']")
    WebElement toValue;
    
    @FindBy(xpath = "//input[@value='Find Flights']")
    WebElement findFlightsBtn;

 


    //    Initializing the page objects
    public TravelPage() {
        PageFactory.initElements(driver, this);
    }
    public void chooseFlights(String from, String to) {
    	Select chooseFrom = new Select(fromValue);
    	chooseFrom.selectByVisibleText(from);
    	chooseFrom.selectByValue(from);
    	Select chooseTo = new Select(toValue);
    	chooseTo.selectByVisibleText(to);
    	chooseTo.selectByValue(to);
    	findFlightsBtn.click();
        
    }

   }
