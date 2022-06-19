package com.qa.rego.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.rego.Utils.Constants;
import com.qa.rego.Utils.ElementUtil;

public class DashboardPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By search = By.name("search");
	private By searchBtn = By.cssSelector("div#search button");
	private By header = By.cssSelector("div#logo a");
	private By accSecList = By.cssSelector("div#content h2");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle() {
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	public boolean isAccountsPageHeaderExist() {
		return eleUtil.doIsDisplayed(header);
	}
	
	public boolean isSearchExist() {
		return eleUtil.doIsDisplayed(search);
	}
	
	public SearchResultsPage doSearch(String productName) {
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doClick(searchBtn);
			return new SearchResultsPage(driver);
		}
		return null;
		
	}
	
	
	
	public List<String> getAccountsPageSectionsList() {
		List<WebElement> secList = eleUtil.getElements(accSecList);
		List<String> accSecValList = new ArrayList<String>();
		for(WebElement e : secList) {
			String text = e.getText();
			accSecValList.add(text);
		}
		return accSecValList;
	}
	
	
	
	
	
	

}
