package com.demo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.TravelPage;
import com.demo.qa.util.TestUtil;


public class PurchasePage extends TravelPage {
	 //Page factory - OR:
	 @FindBy(id = "inputName")
	 WebElement Name;
	 @FindBy(id="address")
	 WebElement Address;
	 @FindBy(id = "city")
	 WebElement City;
	 @FindBy(id="state")
	 WebElement state;
	 @FindBy(id="zipCode")
	 WebElement zipCode;
	 @FindBy(xpath="//select[@id='cardType']")
	 WebElement CardType;
	 @FindBy(id="creditCardNumber")
	 WebElement creditCardNumber;
	 @FindBy(id = "creditCardMonth")
	 WebElement creditCardMonth;
	 @FindBy(id="creditCardYear")
	 WebElement creditCardYear;
	 @FindBy(id="nameOnCard")
	 WebElement nameOnCard;
	 @FindBy(xpath="//input[@value='Purchase Flight']")
	 WebElement PurchaseFlightBtn;
	 @FindBy(css="tbody tr:nth-child(1) td:nth-child(2)")
	 WebElement bookingID;
    
	
	TravelPage travelPage;
    HomePage homePage;
    TestUtil testUtil;
	
	
	public PurchasePage() {
        PageFactory.initElements(driver, this);
    }
	
	
	
	 public void inputCustomerDataMethod(String Name1, String Address1, String city2, String state2, String zipcode2, String cardtype2, String cCNumber, String cCEXPMonth, String cCEXPYear,String nameOnCard1) {	
		 
		 Name.sendKeys("prem");
		 Address.sendKeys("123 street");
		 City.sendKeys("Bengaluru");
		 state.sendKeys("Karnataka");
		 zipCode.sendKeys("560078");
		 Select cardtype = new Select(CardType);
		 cardtype.selectByVisibleText("American Express");
		 cardtype.selectByValue("amex");
		 creditCardNumber.sendKeys("4111111111111111");
		 creditCardMonth.sendKeys("12");
		 creditCardYear.sendKeys("2025");
		 nameOnCard.sendKeys("Prem Kumar D");
		 PurchaseFlightBtn.click();
		 String confirmationID = bookingID.getText();
         System.out.println(confirmationID);
         
	    }
	 	

	   
}
