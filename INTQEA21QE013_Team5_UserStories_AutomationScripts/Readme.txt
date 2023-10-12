Hi user. Please consider going through the description and instructions given below.

DESCRIPTION :
* This framework of the main project is to start the web site.

*TEST SCENARIO DESCRIPTION:-
	1> To open the browser 
	2> Launch the given web-site and verify the URL     (https://pratesting.cognizant.com)
	3> Login with given credentials and validate user name.
	4> Then press the Next Button.
	5> Login with the given credentials and validate the password.
	6> Click on the Sign-in Button.
	7> Write the OTP and then verify and then press the YES button.
	8> Now, the MainSpring Main page is open.
	9> Now click on menu lines in the left corner.
       10> Then Click on the "AstraZe-Global Reltio Support" Project name.
       11> Then Click on the Execute tab.
       12> In the Execute tab there is "User stories" click on it.
       13> Then create new User stories, so click on the "+" sign.
       14> Then enter the details fetch from Excel Sheet in that User stories and press save and then click the "OK" alert button.
       15> Then, it creates more work packages by the press on the "+" sign and all details fetch from Excel Sheet again.
       16> Close the browser.
	
*PROJECT EXPLORER Layout:-
	  INTQEA21QE013_Team5_UserStories_AutomationScripts
	  		*src/test/test
	  			>lib
	  				BaseSetup.java
	  			>pom
	  				AllLocators.java
	  				LoginPage.java
	  				Page1.java
	  				page2.java
	  				page3.java
	  			>testNGscripts
	  				UserStoryTestNGRunnerClass.java(file to run the code)  				
	  		*src/test/resources
	  			>DriverPath	
					chromedriver.exe
					geckodriver.exe
					msedgedriver.exe
			*JRE System Library				
	  		*Maven Dependencies
	  		*Documentation
	  			Documentation.docx
	  		*HTML Report
	  		*praTestingExtendReport 
	  		*Screenshot  
	  		*ReadMe.txt
	  		*TestDataOfUserStories
	  		*Pom.xml
	

*INSTRUCTIONS
*****Use loginTest.java to run the code as the Main function.
*****Install or add all the required libraries or jar files or dependencies.
*****When run the project write your cognizant email and password in the Excel sheet files.
*****You have to enter the OTP by Yourself.
********Please wait a minute to start the filling for new User Stories mandatory fields.



*INSTRUCTIONS TO RUN AS SELENIUM GRID

>we need to have the jar file of selenium grid and different drivers

>To create hub open command prompt 
	java -jar selenium-server-standalone-3.141.59.jar -role hub

>To create node and register again open new command prompt
	java -Dwebdriver.chrome.driver="<path of chromedriver.exe in your system>" -jar selenium-server-standalone-3.141.59.jar 
	-role node -hub <url_of_hub>/grid/register