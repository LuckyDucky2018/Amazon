package com.amazon.qa.pagesTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SearchResultsPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		searchResultsPage = new SearchResultsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority =1)
	public void verifyTitleTest(){
		String title = homePage.verifyPageTitle();
		Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}
	
	@Test(priority =2)
	public void verifyLoggedInNameTest(){
		Assert.assertTrue(homePage.verifyLoggedinName());
	}
	
	@Test(priority =3)
	public void verifySearBoxTestTest(){
		searchResultsPage = homePage.verifySearchBox();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
