package serviceNow.serviceNow.Automation;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import serviceNow.genericObjects.ExcelReader;
import serviceNow.pageObjects.ChangeManagement_SN;
import serviceNow.pageObjects.LoginPage_SSP;
import serviceNow.pageObjects.PlatformGeneric;
import serviceNow.pageObjects.TrackAnIncident;

public class StepMethod {
	
	WebDriver driver;
	String bDriver = System.getProperty("user.dir") + "\\WebDrivers\\";
	String SNURL;
	String ASURL;
	String UserName;
	String Password;
	Scenario scenario;
	String testCasename;
	Collection<String> featureName;
	WebDriverWait wait;
	ExcelReader celldata;
	String ImpersonateUser;
	String SheetName;
	String FeatureName;
	
	@Before
    public void hookScenario(Scenario scenario) throws IOException 
	{
        this.scenario = scenario;
        testCasename = scenario.getName();
        featureName = scenario.getSourceTagNames();
        SheetName = scenario.getId().split(";")[0].replace("-","");
        FeatureName = SheetName.toUpperCase();
        celldata = new ExcelReader();
		SNURL = celldata.GetEnvironment("Env", "Yes", "ServiceNow_URL");
		ASURL = celldata.GetEnvironment("Env", "Yes", "AS_URL");
		UserName = celldata.GetEnvironment("Env", "Yes", "UserName");
		Password = celldata.GetEnvironment("Env", "Yes", "Password");
	}
	
	@Given("^Open \"([^\"]*)\" and launch URL$")
	public void open_and_launch_URL(String browser) throws Throwable {
		try
		{	
			if(browser.equalsIgnoreCase("firefox"))
			{
				String geckoDriver = bDriver + "geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", geckoDriver);
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome"))
			{
				String chromeDriver = bDriver + "chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeDriver);
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("ie"))
			{
				String ieDriver = bDriver + "IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", ieDriver);
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//ExcelReader celldata = new ExcelReader();
			//String SNURL = celldata.get("Yes", "ServiceNow_URL");
			driver.get(SNURL);
			
			if(scenario.isFailed())
			{
				scenario.write("Fail: Failed to launch " + browser + " browser");
				//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
			}
			else
			{
				scenario.write("Pass: '" + browser + "' browser launched successfull");
			}
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
		/*finally
		{
            driver.close();
            driver.quit();
        }*/
	}

	@Given("^Authenticate the user$")
	public void authenticate_the_user() throws Throwable {
		wait = new WebDriverWait(driver, 60);
		try
		{	
			wait.until(ExpectedConditions.elementToBeClickable(By.id("user_name")));
			//LoginPage_SSP login = new LoginPage_SSP(driver);
			LoginPage_SSP login = new LoginPage_SSP(driver);
			login.NavigateToHomePage(UserName, Password);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("filter")));
			if(scenario.isFailed())
			{
				scenario.write("Fail: Failed to login into ServiceNow");
				//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTE);
			}
			else
			{
				scenario.write("Pass: Login successfull");
			}
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	@Then("^Impersonate as a different user$")
	public void impersonate_as_a_different_user() throws Throwable {
		//ImpersonateUser
		wait = new WebDriverWait(driver, 60);
		ImpersonateUser = celldata.GetData(FeatureName, testCasename, "ImpersonateUser1");
		LoginPage_SSP impersonste = new LoginPage_SSP(driver);
		impersonste.ImpersonateUser(ImpersonateUser);
		
		if(scenario.isFailed())
		{
			scenario.write("Fail: Failed to login into ServiceNow");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), ImpersonateUser);
		}
		else
		{
			scenario.write("Pass: Impersonate successfull");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), ImpersonateUser);
		}
	}
	
	@Given("^Launch SelfService Portal$")
	public void launch_SelfService_Portal() throws Throwable {
		wait = new WebDriverWait(driver, 60);
		driver.get(ASURL);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("top_icon")));
		if(scenario.isFailed())
		{
			scenario.write("Fail: Failed to login into SSP");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Pass: SSP launched successfull");
		}
	}

	@When("^Verify the Welcome message$")
	public void verify_the_Welcome_message() throws Throwable {
		//parameters
		String firstName = celldata.GetData(FeatureName, testCasename, "UserFirstName");
		String userLocation = celldata.GetData(FeatureName, testCasename, "UserLocation");
		String AddressChange = celldata.GetData(FeatureName, testCasename, "AddressChange");
		//String firstName = "Mohith";
		//String userLocation = "Henley Local A4934";
		String actualWelcomeMessage = "Hello " + firstName + " at " + userLocation + "\n" + AddressChange;
		
		//System.out.println(actualWelcomeMessage);
		wait = new WebDriverWait(driver, 60);
	    try
		{
			String portalWelcomeMessage = driver.findElement(By.className("ng-scope")).getText();
			if(portalWelcomeMessage.contains(actualWelcomeMessage))
			{
				scenario.write("Pass: Welcome Message is verified successfully");
			}
			else
			{
				scenario.write("Fail: Failed to verify welcome message");
				//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
			}
		}
		
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	@Then("^Verify the Welcome message popup text$")
	public void verify_the_Welcome_message_popup_text() throws Throwable {
		wait = new WebDriverWait(driver, 60);
		String AddressChange = celldata.GetData(FeatureName, testCasename, "AddressChange");
		String[] array1 = AddressChange.split("Until");
		String actualAlertMessagePart1 = array1[0];
		String actualAlertMessagePart2 = array1[1];
		String actualAlertMessage = actualAlertMessagePart1 + "\nUntil" + actualAlertMessagePart2;
		
		//String actualAlertMessage = "If your location is incorrect, please ask a manager to contact HR on 0800 015 30 30 to correct this.\n" + 
				//"Until the correct location is shown here please ask a colleague to log any issues you are experiencing.";
		try
		{
			driver.findElement(By.xpath("/html/body/div/section/main/div[2]/div/sp-page-row[2]/div/div/span/div/div/div/div/div[2]/span/u")).click();
			Thread.sleep(1000);
			String popuptext = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[2]")).getText();
			//String popuptext = popup.getText();
			if(popuptext.contains(actualAlertMessage))
			{
				scenario.write("Pass: Link in Welcome Message to address location issue is verified successfully");
			}
			else
			{
				scenario.write("Fail: Link in Welcome Message to address location issue verification fail");
			}
		}
		
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	@Given("^TabName verification$")
	public void tabname_verification() throws Throwable {
		wait = new WebDriverWait(driver, 60);
		String tabName = driver.getTitle();
		if(tabName.contains("Assist Home"))
		{
			scenario.write("Pass : Portal Home page Tab name is 'Assist Home'");
		}
		else
		{
			scenario.write("Fail: Portal Home page Tab name is not 'Assist Home'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.linkText("Report an Issue")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report an Issue")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Report an Issue"))
		{	
			scenario.write("Pass : Report an Issue page Tab name is 'Report an Issue'");
		}
		else
		{
			scenario.write("Fail : Report an Issue page Tab name is not 'Report an Issue'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}

		tabName = "";
		driver.findElement(By.linkText("Handsets")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CN70 RSS Handsets")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Handset Issue"))
		{	
			scenario.write("Pass : Report an Issue for Handset page Tab name is 'Handsets Issue'");
		}
		else
		{
			scenario.write("Fail : Report an Issue for Handset page Tab name is not 'Handsets Issue'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.linkText("CN70 RSS Handsets")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Report an Issue"))
		{	
			scenario.write("Pass : Report an Issue for CN70 RSS Handset page Tab name is 'Report an Issue'");
		}
		else
		{
			scenario.write("Fail : Report an Issue for CN70 RSS Handset page Tab name is not 'Report an Issue'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.linkText("Report an Issue")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Handsets")));
		Thread.sleep(1000);
		driver.findElement(By.linkText("SmartShop")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report an Issue")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("SmartShop"))
		{	
			scenario.write("Pass : SmartShop page Tab name is 'SmartShop'");
		}
		else
		{
			scenario.write("Fail : SmartShop page Tab name is not 'SmartShop'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.xpath("//*[@id=\"x2bc82396dbf1a380d344ffc41d961975\"]/div/a/h4")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report an Issue")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Smartshop Tablet Issues"))
		{	
			scenario.write("Pass : Smartshop Tablet Issues page Tab name is 'Smartshop Tablet Issues'");
		}
		else
		{
			scenario.write("Fail : Smartshop Tablet Issues page Tab name is not 'Smartshop Tablet Issues'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.xpath("//*[@id=\"xcfa133dedbf1a380d344ffc41d961993\"]/div/a/h4")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report an Issue")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Report an Issue"))
		{	
			scenario.write("Pass : Report an Issue for Tablet is broken page Tab name is 'Report an Issue'");
		}
		else
		{
			scenario.write("Fail : Report an Issue for Tablet is broken page Tab name is not 'Report an Issue'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.linkText("Report an Issue")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Handsets")));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Printers")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report an Issue")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Printer Issue"))
		{	
			scenario.write("Pass : Report an Issue page for printers Tab name is 'Printer Issue'");
		}
		else
		{
			scenario.write("Fail : Report an Issue page for printers Tab name is not 'Printer Issue'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.linkText("Brother Printer")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report an Issue")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Report an Issue"))
		{	
			scenario.write("Pass : Report an Issue for Brother Printer page Tab name is 'Report an Issue'");
		}
		else
		{
			scenario.write("Fail : Brother Printer page Tab name is not 'Report an Issue'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.linkText("Home")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Knowledge Base")));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Knowledge Base")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Knowledge Base"))
		{	
			scenario.write("Pass : Knowledge Base page Tab name is 'Knowledge Base'");
		}
		else
		{
			scenario.write("Fail : Knowledge Base page Tab name is not 'Knowledge Base'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.partialLinkText("Brother Printer 6400")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Knowledge Base")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Knowledge Base"))
		{	
			scenario.write("Pass : Knowledge Base page Tab name is 'Knowledge Base'");
		}
		else
		{
			scenario.write("Fail : Knowledge Base page Tab name is not 'Knowledge Base'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		driver.findElement(By.linkText("Home")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report an Issue")));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Track an Incident")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open Incident")));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open Incidents")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Track An Issue"))
		{	
			scenario.write("Pass : Track an Incident page Tab name is 'Track An Issue'");
		}
		else
		{
			scenario.write("Fail : Track an Incident page Tab name is not 'Track An Issue'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
		tabName = "";
		WebElement webtable  = driver.findElement(By.xpath("//*[@id=\"xf3dcfce7dbb16b80c3d8f9231d9619d0\"]/div/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[7]"));
		webtable.click();
		//String rowdata = webtable.getText();
		//driver.findElement(By.linkText(rowdata)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Track an Incident")));
		Thread.sleep(1000);
		tabName = driver.getTitle();
		if(tabName.contains("Incident"))
		{	
			scenario.write("Pass : Track an Incident Tab name is 'Incident'");
		}
		else
		{
			scenario.write("Fail : Portal Home page Tab name is not 'Incident'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		
	}

	@When("^Navigate to Change Management$")
	public void navigate_to_Change_Management() throws Throwable {
		wait = new WebDriverWait(driver, 60);
		Thread.sleep(1000);
		
		driver.findElement(By.id("filter")).sendKeys("Change");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Create New")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		if(scenario.isFailed())
		{
			scenario.write("Fail: Navigation to Change Management Failed");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Pass: Successfully Navigated to Change Management");
		}
	}
	
	@When("^Navigate to platform page$")
	public void navigate_to_platform_page() throws Throwable {
		
		PlatformGeneric pg = new PlatformGeneric(driver);
		String FilterNavigation = celldata.GetData(FeatureName, testCasename, "FilterNavigation");
		String MenuItem = celldata.GetData(FeatureName, testCasename, "MenuItem");
		pg.PlatformNavigation(FilterNavigation, MenuItem);
		
		if(scenario.isFailed())
		{
			scenario.write("Fail: Navigation to " + MenuItem);
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Pass: Successfully Navigated to " + MenuItem);
		}
	}
		
	@When("^Navigate to Create new incident page$")
	public void navigate_to_Create_new_incident_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait = new WebDriverWait(driver, 60);
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.linkText("Create New")).click();
		//Thread.sleep(10000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/nav/div/div[2]/button")));
		if(scenario.isFailed())
		{
			scenario.write("Fail: Navigation to Create Now Incident page Failed");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Pass: Successfully Navigated to Create Now Incident page");
		}
	}
	
	@When("^Select Change type$")
	public void select_Change_type() throws Throwable {
		wait = new WebDriverWait(driver, 60);
		String ChangeType = celldata.GetData(FeatureName, testCasename, "ChangeType");
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		cmobj.SelectChangeType(ChangeType);
				
		if(scenario.isFailed())
		{
			scenario.write("Fail: Navigation to Normal Change Failed");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Pass: Successfully Navigated to Normal Change");
		}
	}

	@Then("^Verify Category field$")
	public void verify_Category_field() throws Throwable {
		
		wait = new WebDriverWait(driver, 60);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		int index = cmobj.VerifyCategory("Savings and Loans", "change_request.category");		
		if(index > 0)
		{
			scenario.write("Pass: <Savings and Loans> option exist in the Category list");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Fail: <Savings and Loans> option does not exist in the Category list");
		}
		
		int index2 = cmobj.VerifyCategory("Banking Services", "change_request.category");		
		if(index2 < 0)
		{
			scenario.write("Pass: <Banking Services> option does not exist in the Category list");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Fail: <Banking Services> option exist in the Category list");
		}
		//Once all your stuff done with this frame need to switch back to default
		driver.switchTo().defaultContent();
	}
	
	@Then("^Verify incident Category field$")
	public void verify_incident_Category_field() throws Throwable {
		wait = new WebDriverWait(driver, 60);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		int index = cmobj.VerifyCategory("Savings and Loans", "incident.category");		
		if(index > 0)
		{
			scenario.write("Pass: 'Savings and Loans' option exist in the Category list");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Fail: 'Savings and Loans' option does not exist in the Category list");
		}
		
		int index2 = cmobj.VerifyCategory("Banking Services", "incident.category");		
		if(index2 < 0)
		{
			scenario.write("Pass: 'Banking Services' option does not exist in the Category list");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Fail: 'Banking Services' option exist in the Category list");
		}
		//Once all your stuff done with this frame need to switch back to default
		driver.switchTo().defaultContent();
	}
	
	@Then("^Verify Resolution Notes$")
	public void verify_Resolution_Notes() throws Throwable {
		TrackAnIncident trackIncident = new TrackAnIncident(driver);
		trackIncident.NavigateToResolveCloseIncidentpage();
		WebElement resolutionNotes = driver.findElement(By.xpath("//*[@id=\"sand\"]/div[2]/div/p/b"));
		if(resolutionNotes.isDisplayed())
		{
			scenario.write("Pass: 'Resolution Notes' exist for Resloved and Closed Incidents");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Fail: 'Resolution Notes' does not exist for Resloved and Closed Incidents");
		}
	}
	
	@Then("^Verify Primary Assignment Group field is renamed correctly$")
	public void verify_Primary_Assignment_Group_field_is_renamed_correctly() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		PlatformGeneric pg = new PlatformGeneric(driver);
		//for(int i = 1; i <=3; i++)
		//{
		Thread.sleep(2000);
		String Application = celldata.GetData(FeatureName, testCasename, "Application");
		pg.SelectApplication(Application);
		if(pg.ApplicationsFieldChk_PrimaryAssignmentGroup())
		{
			scenario.write("Pass: 'Primary Assignment Group' field renamed successfully for application '" + Application + "'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes.));
		}
		else
		{
			scenario.write("Fail: 'Primary Assignment Group' field renaming failed for application '" + Application + "'");
		}
		//driver.navigate().back();
		//Thread.sleep(2000);
		//Application = "";
		//}
	}
	
	@Then("^Verify Service Delivery Lead field$")
	public void verify_Service_Delivery_Lead_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait = new WebDriverWait(driver, 20);
		PlatformGeneric pg = new PlatformGeneric(driver);
		String Application = celldata.GetData(FeatureName, testCasename, "Application");
		pg.SelectApplication(Application);
		if(pg.ApplicationsFieldChk_ServiceDeliveryLead(ImpersonateUser))
		{
			scenario.write("Pass: 'Service Delivery Lead' field exist for application '" + Application + "'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
		else
		{
			scenario.write("Fail: 'Service Delivery Lead' field not exist for application '" + Application + "'");
		}
	}
	
	@Then("^Create a Change$")
	public void create_a_Change() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		String ChangeNum = cmobj.CreateChange(FeatureName, testCasename);
		if (ChangeNum.contains("CHG")) {
			scenario.write("Pass: Successfully Create the Change:" + ChangeNum + " for Approval");
		}
		else
		{
			scenario.write("Fail: Failed to Create the 'Change Request'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
	}	
	
	@Then("^Fill Risk assessment form$")
	public void fill_Risk_assessment_form() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		if(cmobj.FillOutRiskAssessment(FeatureName, testCasename))	{
			scenario.write("Pass: Successfully Submitted Risk Assessment");
		}
		else
		{
			scenario.write("Fail: Failed to Submitted Risk Assessment");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
	}
	
	@Then("^Submit Change for approval$")
	public void submit_Change_for_approval() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		if(cmobj.RequestApproval(FeatureName, testCasename))	{
			scenario.write("Pass: Successfully Submitted the for Approval");
		}
		else
		{
			scenario.write("Fail: Failed to Submitted the 'Change Request' for Approval");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
	}
	
	@Then("^Approve the change request$")
	public void approve_the_change_request() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		if(cmobj.ApproveChangeRequest(FeatureName, testCasename)) {
			scenario.write("Pass: 'Change Request' approved successfully and ready for Implementation");
		}
		else {
			scenario.write("Fail: Failed to approve 'Change Request'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
	}

	@Then("^Implement and review the change request$")
	public void implement_and_review_the_change_request() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		if(cmobj.ImplementReviewChangeRequest(FeatureName, testCasename)) {
			scenario.write("Pass: 'Change Request' currently at 'Review' status and can be Closed");
		}
		else {
			scenario.write("Fail: Failed to move 'Change Request' to Review Status");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
	}

	@Then("^Close the change request$")
	public void close_the_change_request() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		ChangeManagement_SN cmobj = new ChangeManagement_SN(driver);
		if(cmobj.CloseChangeRequest(FeatureName, testCasename)) {
			scenario.write("Pass: 'Change Request' Closed Successfully");
		}
		else {
			scenario.write("Fail: Failed to Close the 'Change Request'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
	}
	
	@Then("^Verify inherited Roles$")
	public void verify_inherited_Roles() throws Throwable {
		wait = new WebDriverWait(driver, 20);
		PlatformGeneric platformobj = new PlatformGeneric(driver);
		String Role = celldata.GetData(FeatureName, testCasename, "Application");
		String InheritRole = celldata.GetData(FeatureName, testCasename, "InheritRole");
		if(platformobj.Search_Role(Role, InheritRole)) {
			scenario.write("Pass: Inherit role '" + InheritRole + "' exist for role type '" + Role +"'");
		}
		else {
			scenario.write("Fail: Inherit role '" + InheritRole + "' does not exist for role type '" + Role + "'");
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputTypes));
		}
		
	}
	
	@After
	@When("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
		driver.close();
		//String testResult = scenario.getStatus();
		//ExcelReader celldata = new ExcelReader();
		//celldata.SetData("QW_Scenarios", testCasename, "Result", testResult);
	}

}