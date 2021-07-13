package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	//1. By Locator
	private By EmailID=By.id("email");
	
	private By Password=By.id("passwd");
	
	private By SignInButton=By.id("SubmitLogin");
	
	private By ForgetPassLink=By.linkText("Forgot your password?");  
	
	//2. Constructore
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Page Action : Feature (Behavior) of the page the form of methords:
	public String GetLoginPagetitle() {
		return driver.getTitle();
	}
	
	public boolean ForgetPasswordLinkExist() {
		return driver.findElement(ForgetPassLink).isDisplayed();
	}
	
	public void enterUsername(String UserID) {
		driver.findElement(EmailID).sendKeys(UserID);
	}
	
	public void EnterPassword(String Passwrd) {
		driver.findElement(Password).sendKeys(Passwrd);
	}
	
	public void ClickOnSignINbutton() {
		driver.findElement(SignInButton).click();
	}

	public AccountPages doLogin(String un,String pwd) {
		driver.findElement(EmailID).sendKeys(un);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(SignInButton).click();
		
		return new AccountPages(driver);
		
	}
}
