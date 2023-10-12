package com.userstories.pratesting.pom;

import org.openqa.selenium.By;

public class AllLocators {
	public static By emailText = By.id("i0116");
	public static By Btn1 = By.xpath("//input[@type='submit']");
	public static By pwdText = By.name("passwd");
	public static By Btn2 = By.id("idSIButton9");
	public static By verificationText = By.name("otc");
	public static By Btn3 = By.xpath("//*[@type='submit']");
	public static By Btn4 = By.id("idSIButton9");
	public static By BookMenu = By.xpath("//*[@id=\"navbar\"]/div[3]/div[1]");
	public static By ProjectPrograme = By.xpath("//*[@id='projectIcon']/span");
	public static By AstrazeLink = By.xpath("/html[1]/body[1]/div[8]/div[3]/ul[1]/li[5]/ul[1]/li[1]/a[1]");
	public static By Execute = By.id("LOCK_Execute");
	public static By RiskLink = By.id("LOCK_User_Stories");
	public static By plusSymbol = By.id("KEY_BUTTON_Add-btnIconEl");
	public static By Namelocator = By.id("_Text_Check_CM_Name");
	public static By Descriptionlocator = By.xpath ("//*[@id=\"DN_StoryPoints\"]");
	public static By RiskOwnerlocator = By.id("AG_CARDOWNER");
	public static By RiskSourcelocator = By.xpath("//*[@id=\"AG_STATE\"]");
	public static By Calenderlocator = By.xpath("//*[@id=\"cal_CM_DUEDATE\"]");
	public static By Monthlocator = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]");
	public static By Yearlocator = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]");
	public static By savebutton = By.id("SaveBtn");
	public static By returnButton = By.id("CancelBtn");
}
