package com.dexiter.test.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmailTextbox()
	{
		WebElement element = driver.findElement(By.id("email"));
		return element;
	}
	
	public WebElement getPasswordTextbox()
	{
		WebElement element = driver.findElement(By.id("pass"));
		return element;
	}
	
	public WebElement getLoginButton()
	{
		WebElement element = driver.findElement(By.id("u_0_3"));
		return element;
	}
	
	public void waitForLoginPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("u_0_3")));
	}
	
}
