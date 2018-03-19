package com.amazon.qa.pagesTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SearchResultsPage;

public class SearchResultsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	
	public SearchResultsPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		homePage.verifySearchBox();
		searchResultsPage = new SearchResultsPage();
	}
	
	@Test(priority=1)
	public void verifyTitleTest(){
		String title = searchResultsPage.verifyTitle();
		Assert.assertEquals(title, "Amazon.com: Gifts" ,"This title is wrong");
	}
	
	@Test(priority = 2)
	public void verifyDropDownTest(){
		searchResultsPage.verifydropDownMenu();
	}
	
	@Test(priority=3)
	public void verifyWatchPageTest(){
		searchResultsPage.verifyWatch();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
