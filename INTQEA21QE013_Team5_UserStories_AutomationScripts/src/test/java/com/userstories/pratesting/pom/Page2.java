package com.userstories.pratesting.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.userstories.pratesting.lib.BaseSetup;

public class Page2 extends BaseSetup {

	/***********************************
	 * MethodName :initiateDriver()
	 *  Method Description: To initiate the driver
	 * Package name : com.userstories.pratesting.pom
	 ************************************/
	public void initiateDriver(WebDriver driver) {
		this.driver = driver;

	}

	/***********************************
	 * MethodName : monitermenu()
	 * Method Description: To click on the monitermenu
	 * Package name : com.userstories.pratesting.pom
	 * 
	 * @throws Exception
	 ************************************/

	public void monitermenu() throws Exception {

		try {

			Actions mouse = new Actions(driver);
			mouse.moveToElement(driver.findElement(Execute)).build().perform();
			TakingScreenShot("Userlink");
			coustomizehtmlreport(indexSI++, "The user able to view the Userstories dropdown", "Pass", "UserstoriesinMoniterMenu");
			test.log(LogStatus.PASS, "The user is able to mouse over the moniter");

		} catch (Exception e) {
			coustomizehtmlreport(indexSI++, "The user able to view the Userstories dropdown", "Pass", "UserstoriesinMoniterMenu");
			test.log(LogStatus.FAIL, "The user is not able to mouse over the moniter");

		}

	}

	/***********************************
	 * MethodName :clickonrisk()
	 *  Method Description: To click on the risk Package
	 * name : com.userstories.pratesting.pom
	 * @throws Exception
	 ************************************/

	public void clickonrisk() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(RiskLink));
			driver.findElement(RiskLink).click();
			test.log(LogStatus.PASS, "The user is able to enter the Userstorieslink");
		} catch (Exception e) {

			test.log(LogStatus.FAIL, "The user is not able to enter the Userstorieslink");
		}

	}
}
