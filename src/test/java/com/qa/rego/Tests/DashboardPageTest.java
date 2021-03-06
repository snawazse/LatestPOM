package com.qa.rego.Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.rego.Base.BaseTest;
import com.qa.rego.Utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 200 - Design Accounts page for open cart application")
@Story("US 101 - desgin login page features")
@Story("US 102 - desgin accounts page features")
public class DashboardPageTest extends BaseTest {

	@Description("pre login for accounts page tests")
	@BeforeClass
	public void accPageSetup() {
		dashboardPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	@Description("accounts Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	public void accountsPageTitleTest() {
		String actAccountPageTitle = dashboardPage.getAccountsPageTitle();
		System.out.println("Acc page title : " + actAccountPageTitle);
		Assert.assertEquals(actAccountPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	@Description("accounts Page header Test")
	@Severity(SeverityLevel.NORMAL)
	public void accPageHeaderTest() {
		Assert.assertTrue(dashboardPage.isAccountsPageHeaderExist());
	}

	@Test
	@Description("search Exist Test")
	@Severity(SeverityLevel.CRITICAL)
	public void searchExistTest() {
		Assert.assertTrue(dashboardPage.isSearchExist());
	}

	@Test
	@Description("acc Sections Test")
	@Severity(SeverityLevel.NORMAL)
	public void accSectionsTest() {
		List<String> actSecList = dashboardPage.getAccountsPageSectionsList();
		System.out.println("Accounts Sections list = " + actSecList);
		Assert.assertEquals(actSecList, Constants.ACCOUNTS_SECTIONS_LIST);
	}

	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"MacBook"},
			{"iMac"},
			{"Samsung"},
			{"iPhone"}
		};
	}
	
	
	@Test(dataProvider = "getProductData")
	@Description("Search Header Test")
	@Severity(SeverityLevel.NORMAL)
	public void searchHeaderTest(String productName) {
		searchResultsPage = dashboardPage.doSearch(productName);
		String actSearchHeader = searchResultsPage.getResultsPageHeaderValue();
		Assert.assertTrue(actSearchHeader.contains(productName));
	}

	@Test
	@Description("check product count test after search")
	@Severity(SeverityLevel.CRITICAL)
	public void searchProductCountTest() {
		searchResultsPage = dashboardPage.doSearch("iMac");
		int actProductCount = searchResultsPage.getProductSearchCount();
		Assert.assertEquals(actProductCount, Constants.IMAC_PRODUCT_COUNT);
	}

	@Test
	@Description("check product list test after search")
	@Severity(SeverityLevel.CRITICAL)
	public void getSearchProductListTest() {
		searchResultsPage = dashboardPage.doSearch("iMac");
		List<String> actProductList = searchResultsPage.getProductResultsList();
		System.out.println(actProductList);
	}

}
