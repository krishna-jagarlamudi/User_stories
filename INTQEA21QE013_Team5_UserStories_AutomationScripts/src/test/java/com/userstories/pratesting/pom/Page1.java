package com.userstories.pratesting.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.userstories.pratesting.lib.BaseSetup;

public class Page1 extends BaseSetup{
	/***********************************
	 * MethodName :initiateDriver() 
	 * Method Description: To initiate the driver
	 * Package name : com.userstories.pratesting.pom
	 ************************************/

	public void initiateDriver(WebDriver driver) {
		this.driver = driver;

	}

	/***********************************
	 * MethodName : menuBook()
	 * Method Description: To click on the menu book Package
	 * name : com.userstories.pratesting.pom
	 ************************************/

	public void menuBook() throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(BookMenu)));
			TakingScreenShot("pratesting page");
			coustomizehtmlreport(indexSI++, "Login to pratesting application", "Pass", "Login");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			Actions mouse = new Actions(driver);

			mouse.moveToElement(driver.findElement(BookMenu)).build().perform();

			test.log(LogStatus.PASS, "The user is able to mouse over the menu");
		} catch (Exception e) {
			coustomizehtmlreport(indexSI++, "Login to pratesting application", "Fail", "Login");
			test.log(LogStatus.FAIL, "The user is not able to mouse over the menu");
		}

	}

	/***********************************
	 * MethodName : clickOnAstraLink() 
	 * Method Description: To click on the AstraLink
	 * name : com.userstories.pratesting.pom
	 * @throws Exception
	 ************************************/
	public void clickOnAstraLink() throws Exception {
		try {
			
			TakingScreenShot("AstrazeLink");
			coustomizehtmlreport(indexSI++, "The user able to view Userstories Link", "Pass", "AstrazeLink");
			driver.findElement(AstrazeLink).click();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			test.log(LogStatus.PASS, "The user is able to enter into AstrazeLink");
		} catch (Exception e) {
			coustomizehtmlreport(indexSI++, "The user able to view Userstories Link", "Fail", "AstrazeLink");
			test.log(LogStatus.FAIL, "The user is not able to enter into AstrazeLink");
		}

	}
}
