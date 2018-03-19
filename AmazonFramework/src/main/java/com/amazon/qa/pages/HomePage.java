package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//*[@id='ah-dashboard']//p[@class='hud-profilecard-name']")
	WebElement loggedinName;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@class='nav-input' and @type='submit']")
	WebElement searchIcon;
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean verifyLoggedinName(){
		
		return loggedinName.isDisplayed();
	}
	
	public SearchResultsPage verifySearchBox(){
		searchBox.sendKeys("Gifts");
		searchIcon.click();
		return new SearchResultsPage();
		
	}

}
