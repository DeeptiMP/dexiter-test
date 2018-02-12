package com.dexiter.test.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dexiter.config.TestConfiguration;

public class TestLogin {
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondition()
	{
		//driver = TestConfiguration.getInstance();
		
		driver = new FirefoxDriver();
		login = new LoginPage(driver);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

	@Test
	public void testLoginInvalidC77896()
	{
		//wait for login page to load
		login.waitForLoginPageToLoad();
		
		login.getEmailTextbox().sendKeys("abc@gmail.com");
		login.getPasswordTextbox().sendKeys("password");
		login.getLoginButton().click();
		
	}
}
