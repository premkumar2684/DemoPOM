package com.demo.qa.testcases;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.FlightsPage;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.PurchasePage;
import com.demo.qa.pages.TravelPage;
import com.demo.qa.util.TestUtil;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlightBookingTest extends TestBase {

    TravelPage travelPage;
    HomePage homePage;
    FlightsPage flightsPage;
    PurchasePage purchasePage;
    TestUtil testUtil;
    String sheetName = "BookingData";
    
    public FlightBookingTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        travelPage = new TravelPage();
        testUtil = new TestUtil();
    } 
    
    @DataProvider
    public Object[][] getTestData() {
    	testUtil = new TestUtil();
        Object data[][] = testUtil.getTestdata(sheetName);
        return data;
    }

    
    @Test(priority = 4,dataProvider = "getTestData")
    public void flightBookingTest(String Name, String Address, String City, String State,String Zipcode,String Cardtype,String CCNumber,String CCEXPMonth,String CCEXPYear,String nameOnCard) {
    	
    	travelPage = new TravelPage();
    	homePage = new HomePage();
    	flightsPage = new FlightsPage();
    	purchasePage = new PurchasePage();
    	travelPage.chooseFlights("Boston","Rome");
    	String reservePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(reservePageTitle, "BlazeDemo - reserve");
    	flightsPage.chooseFlightMethod();
    	String PurchasePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(PurchasePageTitle, "BlazeDemo Purchase");
    	purchasePage.inputCustomerDataMethod(Name,Address,City,State,Zipcode,Cardtype,CCNumber,CCEXPMonth,CCEXPYear,nameOnCard);
        String ConfirmationPageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(ConfirmationPageTitle, "BlazeDemo Confirmation");
        
       
    }
    
   
    @AfterMethod()
   public void tearDown() {
     driver.quit();
   } 

}
