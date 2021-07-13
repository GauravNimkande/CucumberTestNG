package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPages {
	
	
	
	private WebDriver driver;
	
	private By accountSections= By.cssSelector("div#center_column span");

	public AccountPages(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public int getaccountSectionCount() {
		return driver.findElements(accountSections).size()-1;
	}
	public String getAccountpageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountsectionlist= new ArrayList<String>();
		List<WebElement> accountSectionList=driver.findElements(accountSections);
		
		for(WebElement e : accountSectionList) {
			String text=e.getText();
			accountsectionlist.add(text);
		}
		
		return accountsectionlist;
	}
	
}
