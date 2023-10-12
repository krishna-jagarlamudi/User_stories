package com.userstories.pratesting.lib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.userstories.pratesting.pom.AllLocators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup extends AllLocators {
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	File f = new File("./HTML Report/report.html");
	public static int indexSI = 1;
	public static String browser;
	public static String imagename;

	/***********************************
	 * MethodName :invokeBrowser(String browser)
	 * Method Description: To invoke the
	 * browser Package name : com.userstories.pratesting.lib
	 ************************************/

	public void InvokeBrowser(String browser) {
		this.browser = browser;
		try {

			if (browser.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				// create firefox instance
				driver = new FirefoxDriver();
			}
			// Check if parameter passed as 'chrome'
			else if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				// create chrome instance
				driver = new ChromeDriver();
			}
			// if no browser is send as parameter
			else {

				WebDriverManager.edgedriver().setup();
				// create Edge instance
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			test.log(LogStatus.PASS, "The user is able to invoke the browser");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to invoke the browser");
		}
	}

	/***********************************
	 * MethodName : invokeApplication() 
	 * Method Description: To invoke the
	 * Application Package name : com.userstories.pratesting.lib
	 ************************************/

	public WebDriver invokeApplication() {
		// To invoke the pratesting application
		try {
			driver.get("https://pratesting.cognizant.com/");
			test.log(LogStatus.PASS, "The user is able to invoke the Application");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to invoke the Application");
		}
		return driver;
	}

	/***********************************
	 * MethodName : ExcelDataReader(String filepath, String sheet, int startiterator, int enditerator) 
	 *  Method Description: To Read the TestData
	 * Package name : com.userstories.pratesting.lib
	 ************************************/

	public static Object[][] ExcelDataReader(String filepath, String sheet, int startiterator, int enditerator)
			throws Exception {
		
		// To read the Excel file
		FileInputStream ExcelFile = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
		XSSFSheet Sheet = workbook.getSheet(sheet);
		
		// To count the total number of rows
		int row = Sheet.getLastRowNum();
		
		// To count the total number of columns
		int totalColumnsNum = Sheet.getRow(0).getPhysicalNumberOfCells();
		
		// creating instance for two dimentional object array
		int Numberofiteration = enditerator - startiterator + 1;
		Object[][] Data = new Object[Numberofiteration][1];
		
		// creating hash table instance
		Hashtable<String, String> table = null;
		int count = 0;
		int testCount = 0;
		
		// iterate over rows and columns
		for (int i = startiterator; i <= enditerator; i++) {
			table = new Hashtable<String, String>();
			for (int j = 0; j < totalColumnsNum; j++) {

				String value = String.valueOf(Sheet.getRow(i).getCell(j));
				String keys = String.valueOf(Sheet.getRow(count).getCell(j));
				table.put(keys, value);

			}
			Data[testCount][0] = table;
			testCount++;

		}

		return Data;
	}

	/***********************************
	 * MethodName : TakingScreenShot(String imagename)
	 * Method Description: To take
	 * the screen shot Package name :com.userstories.pratesting.lib
	 ************************************/
	public void TakingScreenShot(String imagename) {
		this.imagename = imagename;
		try {
			Thread.sleep(3000);
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(src, new File("./ScreenShot/" + imagename + ".png"));
			test.log(LogStatus.PASS, "The user is able to take the screenshot");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "The user is not able to take the screenshot");
		}

	}

	/***********************************
	 * MethodName :ReportSetup() 
	 * Method Description: To create the extent report
	 * Package name :com.userstories.pratesting.lib
	 * @throws Exception
	 ************************************/

	public void ReportSetup() throws Exception {
		// to create the instance of extent report
		reports = new ExtentReports("./praTestingExtendReport/Report.html");
		// to create the html report
		test = reports.startTest("praTestingScript1");

	}

	public static void coustomizehtmlreport(int indexSI, String Description, String result, String Screenshot)
			throws IOException {
		String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-mm").format(new GregorianCalendar().getTime());

		File file = new File("./HTML Report/CustomizedHTMLReport.html");

		if (!file.exists()) {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<html>" + "\n");
			bw.write("<head><title>" + "MainSpring HTML Report" + "</title>" + "\n");
			bw.write("</head>" + "\n");
			bw.write("<body>");
			bw.write("<font face='Tahoma'size='2'>" + "\n");
			bw.write("<u><h1 align='center'>" + "MainSpring HTML Report" + "</h1></u>" + "\n");
			bw.write("<u><h2 align='center'>" + "Browser:" + browser + "</h2></u>" + "\n");
			bw.flush();
			bw.close();
		}
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(file, true));
		if (indexSI == 1) {

			bw1.write("<table align='center' border='0' width='70%' height='10'>");
			bw1.write("<tr><td width='70%' </td></tr>");
			bw1.write("<table align='center' border='1' width='70%' height='47'>");
			bw1.write("<tr>");
			bw1.write(
					"<td colspan='1' align='center'><b><font color='#000000' face='Tahoma' size='2'>Module :Risks;</font><font color='#0000FF'' face='Tahoma' size='2'>Add Risk</font></b></td>");
			bw1.write(
					"<td colspan='2' align='left'><b><font color='#000000' face='Tahoma' size='2'>Start Time :&nbsp;</font></b><font color='#0000FF'' face='Tahoma' size='1'>"
							+ startDateTime + " </font></td>");
			bw1.write("</tr>");
			bw1.write("</tr>");
			bw1.write(
					"<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Test Case</font></b></td>");
			bw1.write(
					"<td  bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma' size='2'>Description</font></b></td>");
			bw1.write(
					"<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Result</font></b></td>");
			bw1.write(
					"<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Screenshot</font></b></td>");
			bw1.write("</tr>");
		}
		String dir = System.getProperty("user.dir") + "\\ScreenShot\\" + imagename + ".png'>";
		bw1.write("<tr>" + "\n");
		bw1.write("<td bgcolor='#00FFFF'align='Center'><font color='#000000' face='Tahoma' size='2'>" + indexSI
				+ "</font></td>" + "\n");
		bw1.write("<td  bgcolor='#00FFFF' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
				+ Description + " </font></b></td>" + "\n");
		bw1.write("<td  bgcolor='#00FFFF' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
				+ result + "</font></b></td>" + "\n");
		bw1.write("<td  bgcolor='#00FFFF' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
				+ "<a href='" + dir + Screenshot + "</a>" + "</font></b></td>" + "\n");

		bw1.write("</tr>" + "\n");
		bw1.write("</body>" + "\n");
		bw1.write("</html>");
		bw1.flush();
		bw1.close();
	}
}
