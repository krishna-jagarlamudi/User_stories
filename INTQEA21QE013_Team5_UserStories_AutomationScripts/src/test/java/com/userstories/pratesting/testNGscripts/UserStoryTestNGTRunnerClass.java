package com.userstories.pratesting.testNGscripts;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.userstories.pratesting.lib.BaseSetup;
import com.userstories.pratesting.pom.LoginPage;
import com.userstories.pratesting.pom.Page1;
import com.userstories.pratesting.pom.Page2;
import com.userstories.pratesting.pom.Page3;


public class UserStoryTestNGTRunnerClass extends BaseSetup {
	public static WebDriver driver;
	BaseSetup bu = new BaseSetup();
	LoginPage login = new LoginPage();
	Page1 msp1 = new Page1();
	Page2 msp2 = new Page2();
	Page3 msp3 = new Page3();

	@DataProvider
	public Object[][] datadriver() throws Exception {
		String filePath = System.getProperty("user.dir") + "/TestDataOfUserStories/UserStoriesValidCredentials.xlsx";
		return BaseSetup.ExcelDataReader(filePath, "Sheet1", 1, 1);
	}

	@Test(dataProvider = "datadriver")
	public void Test(Hashtable<String, String> table) throws Exception {

		ReportSetup();
		bu.InvokeBrowser("chrome");
		driver = bu.invokeApplication();
		login.initiateDriver(driver);
		login.CognizantLogin(table.get("Email"), table.get("Password"));
		login.EnteringCode();
		login.KeepMeSingnedIn();
		msp1.initiateDriver(driver);
		msp1.menuBook();
		msp1.clickOnAstraLink();
		msp2.initiateDriver(driver);
		msp2.monitermenu();
		msp2.clickonrisk();
		msp3.initiateDriver(driver);
		msp3.clickonplus();
		msp3.Switchtoiframe();
		msp3.selClosureDate(table.get("Target Closure Date"));
		msp3.EnteringName(table.get("Name"));
		msp3.EnteringDescription(table.get("StoryPoint"));
		msp3.selectingOwner(table.get("Risk Owner"));
		msp3.selRiskSource(table.get("Risk Source"));		
		msp3.clickOnSave();
		msp3.clickOnReturn();
		driver.quit();

	}

	@AfterTest
	public void endReport() {
		reports.endTest(test);
		reports.flush();
		reports.close();
	}

}
