package com.demo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.TravelPage;
import com.demo.qa.util.TestUtil;


public class FlightsPage extends TravelPage {
	 //Page factory - OR:
    
    @FindBy(xpath = "//tbody/tr[2]/td[1]/input[1]")
    WebElement chooseFlightBtn;
    
	
	TravelPage travelPage;
    HomePage homePage;
    
	
	
	public FlightsPage() {
        PageFactory.initElements(driver, this);
    }
	
	
	
	 public void chooseFlightMethod() {	
		 chooseFlightBtn.click();
		 	
		 	
	        
	    }
	 	

	   
}
