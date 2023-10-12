package com.userstories.pratesting.pom;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.userstories.pratesting.lib.BaseSetup;

public class LoginPage extends BaseSetup {
	/***********************************
	 * MethodName :initiateDriver()
	 *  Method Description: To initiate the driver
	 * Package name : com.userstories.pratesting.pom
	 ************************************/
	public void initiateDriver(WebDriver driver) {
		this.driver = driver;

	}

	/***********************************
	 * MethodName :CognizantLogin()
	 *  Method Description:To login into the application
	 * Package name : com.userstories.pratesting.pom
	 ************************************/

	public void CognizantLogin(String Email, String Password) throws Exception {

		try {
			driver.findElement(emailText).sendKeys(Email);
			driver.findElement(Btn1).click();
			Thread.sleep(3000);
			driver.findElement(pwdText).sendKeys(Password);
			driver.findElement(Btn2).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "The user is able to enter the credientials");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to enter the credientials");

		}

	}

	/***********************************
	 * MethodName :EnteringCode() 
	 * Method Description:To Enter the verification code
	 * Package name : com.userstories.pratesting.pom
	 ************************************/
	public void EnteringCode() throws Exception {
		try {
			System.out.println("Enter your verification code:");
			String verificationCode;
			Scanner scanner = new Scanner(System.in);
			verificationCode = scanner.next();
			driver.findElement(verificationText).sendKeys(verificationCode);
			driver.findElement(Btn3).click();
			test.log(LogStatus.PASS, "The user is able to get and enter the verification code");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to get and enter the verification code");
		}
	}

	/***********************************
	 * MethodName :KeepMeSingnedIn() 
	 * Method Description:To click on the Keepmesign
	 * in button Package name : com.userstories.pratesting.pom
	 ************************************/

	public void KeepMeSingnedIn() {

		try {
			driver.findElement(Btn4).click();
			test.log(LogStatus.PASS, "The user is able to click on the sign in button");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to click on the sign in button");
		}

	}

}
