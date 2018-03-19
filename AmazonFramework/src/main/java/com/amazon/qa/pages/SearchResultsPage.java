package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class SearchResultsPage extends TestBase{
	
	@FindBy(id="sort")
	WebElement dropDown;
	
	@FindBy(xpath = "//*[@id='result_15']/div/div/div/div[1]/div/div/a/img")
	WebElement watch;
	
	
	public SearchResultsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle(){
		return driver.getTitle();
	}
	public void verifydropDownMenu(){
		
		Select sel = new Select(dropDown);
		sel.selectByValue("price-asc-rank");
	}
	
	public WatchPage verifyWatch(){
		watch.click();
		return new WatchPage();
	}
	

}
