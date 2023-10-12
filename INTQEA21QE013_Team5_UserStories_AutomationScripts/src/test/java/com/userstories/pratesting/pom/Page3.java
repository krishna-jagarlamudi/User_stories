package com.userstories.pratesting.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import com.userstories.pratesting.lib.BaseSetup;

public class Page3 extends BaseSetup {
	/***********************************
	 * MethodName :initiateDriver() 
	 * Method Description: To initiate the driver
	 * Package name : com.userstories.pratesting.pom
	 ************************************/

	public void initiateDriver(WebDriver driver) {
		this.driver = driver;

	}

	/***********************************
	 * MethodName :clickonplus() 
	 * Method Description: To click the plus button
	 * Package name : com.userstories.pratesting.pom
	 * 
	 * @throws Exception
	 ************************************/

	public void clickonplus() throws Exception {
		try {
			TakingScreenShot("UserstoriesPage");
			coustomizehtmlreport(indexSI++, "The user able to view previous Userstories added", "Pass", "PreviousUserstoriesAdded");
			driver.findElement(plusSymbol).click();
			TakingScreenShot("Adding Credientials Page");
			coustomizehtmlreport(indexSI++, "Invoking the Userstories credientials Page", "Pass", "Credientials Page");
			test.log(LogStatus.PASS, "The user is able to click the plus symbol");
		} catch (Exception e) {
			coustomizehtmlreport(indexSI++, "Invoking the risk credientials Page", "Fail", "Credientials Page");
			coustomizehtmlreport(indexSI++, "The user able to view previous Userstories added", "Fail", "PreviousUserstoriesAdded");
			test.log(LogStatus.FAIL, "The user is not able to click the plus symbol");
		}
	}

	/***********************************
	 * MethodName :Switchtoiframe() 
	 * Method Description: To Switch to iframe Package
	 * name : com.Userstories.pratesting.pom
	 * 
	 * @throws Exception
	 ************************************/

	public void Switchtoiframe() throws Exception {
		try {
			driver.switchTo().frame("contentframe");
			test.log(LogStatus.PASS, "The user is able to switch to iframe");
		} catch (Exception e) {

			test.log(LogStatus.FAIL, "The user is not able to switch to iframe");
		}
	}

	/***********************************
	 * MethodName :EnteringName()
	 * Method Description:To enter the name Package name :
	 * com.userstories.pratesting.pom
	 * 
	 * @throws Exception
	 ************************************/

	public void EnteringName(String Name) throws Exception {
		try {

			driver.findElement(Namelocator).sendKeys(Name);
			TakingScreenShot("Name");
			coustomizehtmlreport(indexSI++, "Adding the name to Userstories Page", "Pass", "Adding name");
			test.log(LogStatus.PASS, "The user is able to enter the name");
		} catch (Exception e) {
			coustomizehtmlreport(indexSI++, "Adding the credientials to Userstories Page", "Fail", "Adding name");
			test.log(LogStatus.FAIL, "The user is not able to enter the name");
		}
	}
	
	public void EnteringDescription(String StoryPoints) throws Exception {
		try {

			driver.findElement(Descriptionlocator).sendKeys(""+StoryPoints);
			TakingScreenShot("Name");
			coustomizehtmlreport(indexSI++, "Adding the name to Userstories Page", "Pass", "Adding name");
			test.log(LogStatus.PASS, "The user is able to enter the name");
		} catch (Exception e) {
			coustomizehtmlreport(indexSI++, "Adding the credientials to Userstories Page", "Fail", "Adding name");
			test.log(LogStatus.FAIL, "The user is not able to enter the name");
		}
	}


	/***********************************
	 * MethodName :selectingOwner()
	 * Method Description:To Select the risk owner
	 * Package name : com.userstories.pratesting.pom
	 ************************************/
	public void selectingOwner(String RishOwner) {
		try {

			Select sel1 = new Select(driver.findElement(RiskOwnerlocator));
			sel1.selectByVisibleText(RishOwner);
			test.log(LogStatus.PASS, "The us er is able to select the risk owner name");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to select the risk owner name");
		}
	}



	/***********************************
	 * MethodName :selRiskSource() Method Description:To Select the risk source
	 * Package name : com.Cognizant.pratesting.pom
	 ************************************/

	public void selRiskSource(String RiskSource) {
		try {

			Select sel = new Select(driver.findElement(RiskSourcelocator));
			sel.selectByVisibleText(RiskSource);

		} catch (Exception e) {

		}

	}

	/***********************************
	 * MethodName :selClosureDate() 
	 * Method Description:To Select the closure date
	 * Package name : com.userstories.pratesting.pom
	 ************************************/

	public void selClosureDate(String CloseDate) throws Exception {
		try {
			String[] date_split = CloseDate.split("-");
			String date = date_split[0];
			String month = date_split[1];
			String year = date_split[2];
			driver.findElement(Calenderlocator).click();

			Select sel = new Select(driver.findElement(Monthlocator));
			sel.selectByVisibleText(month);

			Select selyear = new Select(driver.findElement(Yearlocator));
			selyear.selectByVisibleText(year);

			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[text()='" + date + "']"))
					.click();
			test.log(LogStatus.PASS, "The user is able to select the closure date");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to select the closure date");
		}

	}

	/***********************************
	 * MethodName :clickOnSave() 
	 * Method Description:To click on save button Package
	 * name : com.userStories.pratesting.pom
	 ************************************/

	public void clickOnSave() {
		try {
			driver.findElement(savebutton).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "The user is able to click the save button");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to click the save button");
		}

	}

	/***********************************
	 * MethodName :clickOnReturn() 
	 * Method Description:To click on return button
	 * Package name : com.userStories.pratesting.pom
	 * @throws Exception
	 ************************************/

	public void clickOnReturn() throws Exception {
		try {

			driver.findElement(returnButton).click();
			TakingScreenShot("Userstoriesadded");
			coustomizehtmlreport(indexSI++, "Checking the addition of Userstories", "Pass", "Finalresult");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			test.log(LogStatus.PASS, "The user is able to click the return button");
		} catch (Exception e) {
			coustomizehtmlreport(indexSI++, "Checking the addition of Userstories", "Fail", "Finalresult");
			test.log(LogStatus.FAIL, "The user is not able to click the return button");

		}

	}

}
