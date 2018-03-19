package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//*[@id='nav-link-accountList']/span[2]")
	WebElement signinLink;

	@FindBy(xpath = "//*[@id='ap_email']")
	WebElement userName;

	@FindBy(xpath = "//*[@id='continue']")
	WebElement contBtn;

	@FindBy(xpath = "//*[@id='ap_password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='signInSubmit']")
	WebElement signinBtn;
	
	@FindBy(xpath = "//*[@id='nav-logo']/a[1]/span[1]")
	WebElement amazonLogo;

	public LoginPage(){

		PageFactory.initElements(driver, this);
	}

	public String verifyTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyAmazonLogo(){
		return amazonLogo.isDisplayed();
	}
	
	public HomePage login(String un , String pwd){
		
		signinLink.click();
		userName.sendKeys(un);
		contBtn.click();
		password.sendKeys(pwd);
		signinBtn.click();
		
		return new HomePage();
	}
	
	
}

