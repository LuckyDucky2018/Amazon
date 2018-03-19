package com.amazon.qa.pagesTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;



public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyTitleTest(){
		String title = loginPage.verifyTitle();
		Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more" );
	}
	
	@Test(priority=2)
	public void verifyAmazonLogoTest(){
		boolean flag = loginPage.verifyAmazonLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyLoginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
}
