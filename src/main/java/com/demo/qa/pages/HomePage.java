package com.demo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.base.TestBase;

public class HomePage extends TestBase {
	 //Page factory - OR:
	 @FindBy(xpath = "//a[normalize-space()='home']")
	 WebElement homePageBtn;
	 @FindBy(xpath = "//a[normalize-space()='Register']")
	 WebElement registerlink;
	 @FindBy(id = "email")
	 WebElement emailAddress;
	 @FindBy(id = "password")
	 WebElement password;
	 @FindBy(xpath = "//button[@type='submit']")
	 WebElement loginBtn;	 
	 @FindBy(id = "name")
	 WebElement name;
	 @FindBy(id = "company")
	 WebElement companyname;
	 @FindBy(id = "password-confirm")
	 WebElement passwordconfirm;
	 @FindBy(xpath = "//button[@type='submit']")
	 WebElement registerBtn;
	//button[@type='submit']

    //Initialize the page objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
    	
        return driver.getTitle();
    }

    
    public void login(String un, String pwd) {
    	homePageBtn.click();
    	emailAddress.sendKeys(un);
        password.sendKeys(pwd);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
        
    }

     public void register(String un,String company,String email,String pwd,String confirmPassword) {
    	 
    	 	homePageBtn.click();
    	 	registerlink.click();
    		name.sendKeys(un);
    		companyname.sendKeys(company);
    		emailAddress.sendKeys(email);
            password.sendKeys(pwd);
            passwordconfirm.sendKeys(confirmPassword);
            registerBtn.click();

        
        
      
    }


   
}
