package com.dexiter.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dexiter.util.DataHandlers;

public class TestConfiguration {
	
	public static WebDriver getInstance()
	{
		WebDriver driver = null;
		String browserType = DataHandlers.getDataFromPropertyFile("configuration", "browser");
		String url = DataHandlers.getDataFromPropertyFile("configuration", "url");
		
		if(browserType.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browserType.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else
		{
			System.err.println("Invalid browser type");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

}
