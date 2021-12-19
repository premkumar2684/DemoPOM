package com.demo.qa.testcases;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.TravelPage;
import com.demo.qa.util.TestUtil;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    TravelPage travelPage;
    HomePage homePage;
    TestUtil testUtil;
    String sheetName = "RegistrationData";
   

    public HomePageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
       }
    
    @DataProvider
    public Object[][] getTestData() {
    	testUtil = new TestUtil();
        Object data[][] = testUtil.getTestdata(sheetName);
        return data;
    }
    
    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "BlazeDemo", "Home page title is not matched");
    }
    
    @Test(priority = 2,dataProvider = "getTestData")
    public void registerationTest(String username,String company,String email,String password,String confirmPassword) {
    	
    	homePage = new HomePage();
    	testUtil = new TestUtil();
    	homePage.register(username,company,email,password,confirmPassword);
    	String DashboardPageTitle = homePage.verifyHomePageTitle();
    	System.out.println(DashboardPageTitle);
        Assert.assertEquals(DashboardPageTitle, "BlazeDemo");
       }
    
    @Test(priority = 3)
    public void loginTest() {
    	
    	homePage = new HomePage();
    	homePage.login(prop.getProperty("username"),prop.getProperty("password"));
    	//String title = dashboardPage.validateDashboardPageTitle();
    	String DashboardPageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(DashboardPageTitle, "BlazeDemo");
       }

     

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
