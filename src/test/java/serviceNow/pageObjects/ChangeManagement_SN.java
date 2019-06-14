package serviceNow.pageObjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import serviceNow.genericObjects.ExcelReader;

public class ChangeManagement_SN {
	
	WebDriver driver;
	ExcelReader dataReader;
	WebDriverWait wait;

	public ChangeManagement_SN(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Normal")
	WebElement normal;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Bank-Normal:") 
	WebElement banknormal;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Standard:") 
	WebElement standard;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Bank-Standard:") 
	WebElement bankStandard;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Emergency:") 
	WebElement emergency;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Bank-Emergency:") 
	WebElement bankemergency;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Expedited:") 
	WebElement expedited;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Bank-Expedited:") 
	WebElement bankexpedited;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Latent ") 
	WebElement latent;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Bank-Latent:") 
	WebElement banklatent;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="No Impact:") 
	WebElement noimpact;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Bank-No Impact:") 
	WebElement banknoimpact;
	
	@FindBy(how=How.ID, using="change_request.category") 
	WebElement category;
	
	@FindBy(how=How.ID, using="change_request.u_subcategory") 
	WebElement subcategory;
	
	@FindBy(how=How.ID, using="sys_display.change_request.cmdb_ci") 
	WebElement ci;
	
	@FindBy(how=How.ID, using="sys_display.change_request.business_service")
	WebElement businessservice;
	
	@FindBy(how=How.ID, using="change_request.u_project_or_non_project")
	WebElement projectbau;
	
	@FindBy(how=How.ID, using="sys_display.change_request.assignment_group")
	WebElement assignmentgroup;
	
	@FindBy(how=How.ID, using="lookup.change_request.assignment_group")
	WebElement assignmentgrouplookup;
	
	@FindBy(how=How.ID, using="lookup.change_request.assigned_to")
	WebElement assignedtosearchbtn;
	
	@FindBy(how=How.ID, using="lookup.change_request.assigned_to")
	WebElement assignedtolookup;
		
	@FindBy(how=How.ID, using="sys_display.change_request.assigned_to")
	WebElement assignedto;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"row_sys_user_216b6d52dbafbec04ae4f5461d961908\"]/td[3]")
	WebElement assignedtoname;
	
	@FindBy(how=How.ID, using="change_request.u_change_reason")
	WebElement changereason;
	
	@FindBy(how=How.ID, using="change_request.short_description")
	WebElement shortdescription;
	
	@FindBy(how=How.ID, using="change_request.description")
	WebElement description;
	
	@FindBy(how=How.ID, using="change_request.justification")
	WebElement justification;
	
	@FindBy(how=How.ID, using="change_request.implementation_plan")
	WebElement implementationplan;
	
	@FindBy(how=How.ID, using="change_request.risk_impact_analysis")
	WebElement riskimpactanalysis;
	
	@FindBy(how=How.ID, using="change_request.u_impact_analysis")
	WebElement impactanalysis;
	
	@FindBy(how=How.ID, using="change_request.test_plan")
	WebElement testing;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs2_section\"]/span[2]/span[1]")
	WebElement schedule;
	
	@FindBy(how=How.ID, using="change_request.start_date")
	WebElement chagestarttime;
	
	@FindBy(how=How.ID, using="change_request.end_date")
	WebElement chageendtime;
	
	@FindBy(how=How.ID, using="sysverb_update_and_stay")
	WebElement changesavebtn;
	
	@FindBy(how=How.ID, using="fill_assessment")
	WebElement fillassessment;
	
	@FindBy(how=How.ID, using="post_survey")
	WebElement riskasssubmit;
	
	@FindBy(how=How.ID, using="toggle_change_calendar")
	WebElement calendar;
		
	@FindBy(how=How.ID, using="execute_risk_calc")
	WebElement executeriskasssubmit;
	
	@FindBy(how=How.ID, using="sys_readonly.change_request.state")
	WebElement status;
		
	@FindBy(how=How.XPATH, using="//iframe[contains(@src,'survey_take.do'])]")
	WebElement riskassessmentframe;
	
	@FindBy(how=How.ID, using="sys_readonly.change_request.number")
	WebElement changenum;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs2_list\"]/span[2]/span/span[2]")
	WebElement approverlist;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody")
	WebElement approverlisttable;
		
	@FindBy(how=How.XPATH, using="//tr[starts-with(@id, 'row_change_request.sysapproval')]/td[4]")
	WebElement approvera;
	
	@FindBy(how=How.XPATH, using="//tr[starts-with(@id, 'row_change_request.sysapproval')]/td[3]")
	WebElement approverarequest;
		
	@FindBy(how=How.XPATH, using="/html/body/div[5]/div/div/header/div[1]/div/div[2]/div/div[4]/form/div/label/span")
	WebElement searchicon;
	
	@FindBy(how=How.ID, using="sysparm_search")
	WebElement searchtext;
	
	@FindBy(how=How.ID, using="approve")
	WebElement approve;
	
	@FindBy(how=How.ID, using="sysapproval_approver.state")
	WebElement state;
	
	@FindBy(how=How.ID, using="change_request.form_scroll")
	WebElement scroll;
	
	@FindBy(how=How.ID, using="state_model_move_to_implement")
	WebElement implement;
	
	@FindBy(how=How.ID, using="state_model_move_to_review")
	WebElement review;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs2_list\"]/span[1]/span/span[2]")
	WebElement tasklist;
	
	@FindBy(how=How.ID, using="lookup.change_task.assignment_group")
	WebElement taskassignmentgrp;
	
	@FindBy(how=How.ID, using="change_task.description")
	WebElement taskdesctiption;
	
	@FindBy(how=How.ID, using="change_task.u_change_closure_status")
	WebElement taskclosurestatus;
		
	@FindBy(how=How.ID, using="change_task_to_closed")
	WebElement closetask;
	
	@FindBy(how=How.ID, using="state_model_move_to_closed")
	WebElement close;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs2_section\"]/span[5]/span[1]/span[2]")
	WebElement closureinfo;
	
	@FindBy(how=How.ID, using="change_request.close_code")
	WebElement closurecode;

	@FindBy(how=How.ID, using="change_request.u_timing_reason")
	WebElement timingreason;
	
	@FindBy(how=How.ID, using="sys_display.change_request.u_manager_on_escalation")
	WebElement manageronescalation;
						
	public void SelectChangeType(String ChangeType) {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if(ChangeType.equalsIgnoreCase("Normal")) {
			normal.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));
		}
		
		if(ChangeType.equalsIgnoreCase("Bank Normal")) {
			banknormal.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Standard")) {
			standard.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Click time URL")));
			driver.findElement(By.partialLinkText("Click time URL")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));
		}
		
		if(ChangeType.equalsIgnoreCase("Bank Standard")) {
			bankStandard.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Emergency")) {
			emergency.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Bank Emergency")) {
			bankemergency.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Expedited")) {
			expedited.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Bank Expedited")) {
			bankexpedited.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Latent")) {
			latent.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Bank Latent")) {
			banklatent.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("No impact")) {
			noimpact.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Business Continuity")));
			driver.findElement(By.partialLinkText("Business Continuity")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));	
		}
		
		if(ChangeType.equalsIgnoreCase("Bank No impact")) {
			banknoimpact.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("change_request.type")));
		}
	}
	
	public int VerifyCategory(String iItem, String changeCategory) {
		int index; 
		Select category = new Select(driver.findElement(By.id(changeCategory)));
		//category.selectByValue(iItem);
		List<WebElement> options = category.getOptions();  
		//int index =	options.indexOf(iItem);
		index = -1;
	    for(int i=0;i<options.size();i++){
	        if(options.get(i).getText().equals(iItem)){
	            index = i;
	            break;
	        }
	    }
		return index;
	}
	
	public String CreateChange(String WorkBookname, String TCName) throws IOException, Exception {
		
		wait = new WebDriverWait(driver, 20);
		dataReader = new ExcelReader();
		//String Category = dataReader.GetData(WorkBookname, TCName, "Category");
		//String Subcategory = dataReader.GetData(WorkBookname, TCName, "Subcategory");
		String CI = dataReader.GetData(WorkBookname, TCName, "CI");
		String BusinessService = dataReader.GetData(WorkBookname, TCName, "BusinessService");
		String ProjectBAU = dataReader.GetData(WorkBookname, TCName, "ProjectBAU");
		//String AssignmentGroup = dataReader.GetData(WorkBookname, TCName, "AssignmentGroup");
		String AssignedTo = dataReader.GetData(WorkBookname, TCName, "AssignedTo");
		String ChangeReason = dataReader.GetData(WorkBookname, TCName, "ChangeReason");
		String ShortDescription = dataReader.GetData(WorkBookname, TCName, "ShortDescription");
		String Description = dataReader.GetData(WorkBookname, TCName, "Description");
		String Justification = dataReader.GetData(WorkBookname, TCName, "Justification");
		String ImplementationPlan = dataReader.GetData(WorkBookname, TCName, "ImplementationPlan");
		String RiskAnalysis = dataReader.GetData(WorkBookname, TCName, "RiskAnalysis");
		String ImpactAnalysis = dataReader.GetData(WorkBookname, TCName, "ImpactAnalysis");
		String Testing = dataReader.GetData(WorkBookname, TCName, "Testing");
		String ChangeType = dataReader.GetData(WorkBookname, TCName, "ChangeType");
		
		Select categorydd = new Select(category);
		//categorydd.selectByVisibleText(Category);
		categorydd.selectByIndex(1);
		//Thread.sleep(1000);
		
		ci.sendKeys(CI);
		if("Standard".equalsIgnoreCase(ChangeType)) {
			
		}
		else {
			assignmentgrouplookup.click();
			waitForNumberofWindowsToEqual(2);//this method is for wait
			Set<String> handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);
			String winHandle = (String) handles.iterator().next();
			if (winHandle!=firstWinHandle){
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
			}
			driver.findElement(By.xpath("//*[@id=\"treenode_0\"]/div/div/div/table/tbody/tr/td[3]/a")).click();
			//driver.findElement(By.xpath("//*[@id=\"treenode_0\"]/div/div/div/table/tbody/tr/td[4]/a")).click();
			driver.switchTo().window(firstWinHandle);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		}
		
		Select subcategorydd = new Select(subcategory);
		//subcategorydd.selectByVisibleText(Subcategory);
		subcategorydd.selectByIndex(1);
		
		if (AssignedTo != null) {
			//assignedto.sendKeys(AssignedTo);
			
			assignedtolookup.click();
			waitForNumberofWindowsToEqual(2);//this method is for wait
			Set<String> athandles = driver.getWindowHandles();
			String atfirstWinHandle = driver.getWindowHandle(); athandles.remove(atfirstWinHandle);
			String atwinHandle = (String) athandles.iterator().next();
			if (atwinHandle!=atfirstWinHandle){
				String atsecondWinHandle = atwinHandle; 
				//System.out.println(atsecondWinHandle);
				driver.switchTo().window(atsecondWinHandle);
			}
			driver.findElement(By.xpath("//*[@id=\"sys_user_table\"]/tbody/tr/td[3]/a")).click();
			driver.switchTo().window(atfirstWinHandle);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		}
		else {
			assignedtosearchbtn.click();
			assignedtoname.click();
		}
		businessservice.sendKeys(BusinessService);
		
		if(("Emergency".equalsIgnoreCase(ChangeType)) || ("Expedited".equalsIgnoreCase(ChangeType))) {
			String TimingReason = dataReader.GetData(WorkBookname, TCName, "TimingReason");
			String ManagerOnEscalation = dataReader.GetData(WorkBookname, TCName, "ManagerOnEscalation");
			
			manageronescalation.sendKeys(ManagerOnEscalation);
			Select timereason = new Select(timingreason);
			timereason.selectByVisibleText(TimingReason);	
		}
		
		Select projectbaudd = new Select(projectbau);
		projectbaudd.selectByVisibleText(ProjectBAU);
				
		Select changereasondd = new Select(changereason);
		changereasondd.selectByVisibleText(ChangeReason);
		
		if (ShortDescription != null) {
			shortdescription.sendKeys(ShortDescription);
		}
		else {
			shortdescription.sendKeys("Testing Change using Selenium");;
		}
		
		if (Description != null) {
			description.sendKeys (Description);
		}
		else {
			description.sendKeys("Testing Change using Selenium");;
		}
		
		if (Justification != null) {
			justification.sendKeys (Justification);
		}
		else {
			justification.sendKeys("Testing Change using Selenium");;
		}
		
		if (ImplementationPlan != null) {
			implementationplan.sendKeys (ImplementationPlan);
		}
		else {
			implementationplan.sendKeys("Testing Change using Selenium");;
		}
		
		if (RiskAnalysis != null) {
			riskimpactanalysis.sendKeys (RiskAnalysis);
		}
		else {
			riskimpactanalysis.sendKeys("Testing Change using Selenium");;
		}

		if (ImpactAnalysis != null) {
			impactanalysis.sendKeys (ImpactAnalysis);
		}
		else {
			impactanalysis.sendKeys("Testing Change using Selenium");;
		}
		
		if (Testing != null) {
			testing.sendKeys (Testing);
		}
		else {
			testing.sendKeys("Testing Change using Selenium");
		}
		
		schedule.click();
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		String date = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
		String starttime = "20:00:00";
		String endtime = "22:00:00";
		
		String changestarttime =  date + " " + starttime;
		String changeendtime = date + " " + endtime;
		
		chagestarttime.sendKeys(changestarttime);
		chageendtime.sendKeys(changeendtime);
		
		changesavebtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(calendar));
		String ChangeNumber = changenum.getAttribute("value");
		return ChangeNumber;
	}
	
	private void waitForNumberofWindowsToEqual(int i) {
		// TODO Auto-generated method stub
		
	}

	public boolean FillOutRiskAssessment(String WorkBookname, String TCName) throws IOException, InterruptedException {
		
		wait = new WebDriverWait(driver, 20);
		dataReader = new ExcelReader();
		String ReqAppBtn = null;
		fillassessment.click();
		
		Thread.sleep(2000);
		String ChangeType = dataReader.GetData(WorkBookname, TCName, "ChangeType");
		//int size = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.elementToBeClickable(riskasssubmit));
		riskasssubmit.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.elementToBeClickable(executeriskasssubmit));
		Thread.sleep(1000);
		WebElement RiskCal = driver.findElement(By.id("execute_risk_calc"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", RiskCal);
        if("Emergency".equalsIgnoreCase(ChangeType)) {//|| ("Expedited".equalsIgnoreCase(ChangeType))) {
			ReqAppBtn = "state_model_request_cab_approval";
		}
		else if ("Latent".equalsIgnoreCase(ChangeType)) {
			ReqAppBtn = "state_model_move_to_review";
		}
		else {
			ReqAppBtn = "state_model_request_assess_approval";
		}
		
		WebElement RequestApprovalBtn = driver.findElement(By.id(ReqAppBtn));
		wait.until(ExpectedConditions.elementToBeClickable(RequestApprovalBtn));
		return true;
	}
	
	public boolean RequestApproval(String WorkBookname, String TCName) throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 20);
		dataReader = new ExcelReader();
		String ReqAppBtn = null;
		String ChangeType = dataReader.GetData(WorkBookname, TCName, "ChangeType");
		
		if("Emergency".equalsIgnoreCase(ChangeType)) {//|| ("Expedited".equalsIgnoreCase(ChangeType))) {
			ReqAppBtn = "state_model_request_cab_approval";
		}
		else if ("Latent".equalsIgnoreCase(ChangeType)) {
			ReqAppBtn = "state_model_move_to_review";
		}
		else {
			ReqAppBtn = "state_model_request_assess_approval";
		}
		
		WebElement RequestApprovalBtn = driver.findElement(By.id(ReqAppBtn));
		wait.until(ExpectedConditions.elementToBeClickable(RequestApprovalBtn));
		RequestApprovalBtn.click();
		Thread.sleep(1000);
		String currentstatus = status.getAttribute("value");
		//String currentstatus = status.getText();
		if ("-5".equalsIgnoreCase(currentstatus)) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean ApproveChangeRequest(String WorkBookname, String TCName) throws InterruptedException, IOException {
		wait = new WebDriverWait(driver, 20);
		dataReader = new ExcelReader();
		LoginPage_SSP lp =new LoginPage_SSP(driver);
		boolean loopflag = true;
		wait.until(ExpectedConditions.elementToBeClickable(calendar));
		String ChangeNumber = changenum.getAttribute("value");
		//String ScheduledStatus = "-2";
		String ApprovarName1 = "";
		String ApprovarName2 = "";
		String currentstatus = "";
		while(loopflag) {
			approverlist.click();
			
			//driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_choice_actions\"]/select")).click();
			driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_expanded\"]/div[4]/div[1]/table/tbody/tr/td[2]/span[1]")).click();
			
			WebElement table = driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody"));
			List<WebElement> row = table.findElements(By.tagName("tr"));
			int tablerowcount = row.size();
			
			for(int i = 1; i <= tablerowcount; i++) {
				String requestlink = driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody/tr[" + i +"]/td[3]/a")).getText();
				if ("Requested".equalsIgnoreCase(requestlink)) {
					ApprovarName1 = driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody/tr[" + i +"]/td[4]")).getText();
					break;}
			}
			
			//Thread.sleep(2000);
			driver.switchTo().defaultContent();
			
			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
				//*[@id="elm1553804903958"]
				driver.findElement(By.xpath("/html/body/div[6]/div/button")).click();
			} catch (NoSuchElementException e) {
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
			
			lp.ImpersonateUser(ApprovarName1);
			Thread.sleep(2000);
			searchicon.click();
			Thread.sleep(1000);
			searchtext.sendKeys(ChangeNumber);
			searchtext.submit();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
			
			WebElement table2 = driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody"));
			List<WebElement> cntrow = table2.findElements(By.tagName("tr"));
			int approvertblrowcount = cntrow.size();
			
			for(int j = 1; j <= approvertblrowcount; j++) {
				ApprovarName2 = driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody/tr[" + j +"]/td[4]")).getText();
				//String requestlink = driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody/tr[" + j +"]/td[3]/a")).getText();
				if (ApprovarName1.equalsIgnoreCase(ApprovarName2)) {
					driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_table\"]/tbody/tr[" + j +"]/td[3]/a")).click();
					break;}
			}
			//approverarequest.click();
			wait.until(ExpectedConditions.elementToBeClickable(approve));
			
			Select statedd = new Select(state);
			statedd.selectByVisibleText("Approved");
			approve.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(calendar));
			currentstatus = status.getAttribute("value");
			//String currentstatus = status.getText();
			if ("-2".equalsIgnoreCase(currentstatus)) {
				loopflag = false;
				//Thread.sleep(1000);
			}
		}
		//Thread.sleep(1000);
		driver.switchTo().defaultContent();
		String ITILUser = dataReader.GetData(WorkBookname, TCName, "ImpersonateUser1");
		lp.ImpersonateUser(ITILUser);
		Thread.sleep(2000);
		searchicon.click();
		Thread.sleep(1000);
		searchtext.sendKeys(ChangeNumber);
		searchtext.submit();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		if ("-2".equalsIgnoreCase(currentstatus)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean ImplementReviewChangeRequest(String WorkBookname, String TCName) throws InterruptedException, IOException {
			
		wait = new WebDriverWait(driver, 20);
		dataReader = new ExcelReader();
		
		String ChangeType = dataReader.GetData(WorkBookname, TCName, "ChangeType");
		
		if("Latent".equalsIgnoreCase(ChangeType)) {
			wait.until(ExpectedConditions.elementToBeClickable(calendar));
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(implement));
			implement.click();
			if("Standard".equalsIgnoreCase(ChangeType)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.id("standard_change_move_to_review")));
			}
			else if("No impact".equalsIgnoreCase(ChangeType)) {
				Thread.sleep(1500);
				wait.until(ExpectedConditions.elementToBeClickable(calendar));
			}
			else {
				wait.until(ExpectedConditions.elementToBeClickable(review));
			}
		}	
		
		//String AssignmentGroup = dataReader.GetData(WorkBookname, TCName, "AssignmentGroup");
		String ChangeClosureStatus = dataReader.GetData(WorkBookname, TCName, "ChangeClosureStatus");
		
		tasklist.click();
		//String Task1;
		WebElement table = driver.findElement(By.xpath("//*[@id=\"change_request.change_task.change_request_table\"]/tbody"));
		List<WebElement> row = table.findElements(By.tagName("tr"));
		int tablerowcount = row.size();
		
		for(int i = 1; i <= tablerowcount; i++) {
			String taskstatus = driver.findElement(By.xpath("//*[@id=\"change_request.change_task.change_request_table\"]/tbody/tr[" + i +"]/td[5]")).getText();
			String taskdesc = driver.findElement(By.xpath("//*[@id=\"change_request.change_task.change_request_table\"]/tbody/tr[" + i +"]/td[4]")).getText();
			if ("Open".equalsIgnoreCase(taskstatus)) {
				driver.findElement(By.xpath("//*[@id=\"change_request.change_task.change_request_table\"]/tbody/tr[" + i +"]/td[3]/a")).click();
				if(("Latent".equalsIgnoreCase(ChangeType)) || ("Standard".equalsIgnoreCase(ChangeType))){
					
				}
				else {
					taskassignmentgrp.click();
					waitForNumberofWindowsToEqual(2);
					Set<String> handles = driver.getWindowHandles();
					String firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);
					//System.out.println(firstWinHandle);
					String winHandle = (String) handles.iterator().next();
					if (winHandle!=firstWinHandle){
						String secondWinHandle = winHandle;
						driver.switchTo().window(secondWinHandle);
					}
					driver.findElement(By.xpath("//*[@id=\"treenode_0\"]/div/div/div[1]/table/tbody/tr/td[3]/a")).click();
					//driver.switchTo().frame(0);
					driver.switchTo().window(firstWinHandle);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				}
				
				if("Post Implementation testing".equalsIgnoreCase(taskdesc)) {
					Select taskclosurestat = new Select(taskclosurestatus);
					taskclosurestat.selectByVisibleText(ChangeClosureStatus);
				}
				
				taskdesctiption.sendKeys("Testing Change management");
				closetask.click();
				wait.until(ExpectedConditions.elementToBeClickable(calendar));
				//approverlist.click();
				//driver.findElement(By.xpath("//*[@id=\"change_request.sysapproval_approver.sysapproval_expanded\"]/div[4]/div[1]/table/tbody/tr/td[2]/span[1]")).click();
				//break;
			}
		}
		
		if (ChangeClosureStatus.equalsIgnoreCase("Successful")) {
			//String ChangeNumber = changenum.getAttribute("value");
			driver.switchTo().defaultContent();
			searchtext.click();
			//searchtext.sendKeys(ChangeNumber);
			searchtext.submit();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		}
				
		String currentstatus = status.getAttribute("value");
		
		String StatusChangeTo;
		if (ChangeClosureStatus.equalsIgnoreCase("Successful")) {
			StatusChangeTo = "3";
		} else {
			StatusChangeTo = "0";
		}
				
		if (StatusChangeTo.equalsIgnoreCase(currentstatus)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean CloseChangeRequest(String WorkBookname, String TCName) throws InterruptedException, IOException {
		
		wait = new WebDriverWait(driver, 20);
		dataReader = new ExcelReader();
		LoginPage_SSP lp =new LoginPage_SSP(driver);
		String ChangeNumber = changenum.getAttribute("value");
		driver.switchTo().defaultContent();
		String ChangeManagerUser = dataReader.GetData(WorkBookname, TCName, "ImpersonateUser2");
		driver.switchTo().defaultContent();
		lp.ImpersonateUser(ChangeManagerUser);
		Thread.sleep(2000);
		searchicon.click();
		Thread.sleep(1000);
		searchtext.sendKeys(ChangeNumber);
		searchtext.submit();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		closureinfo.click();
		Select subcategorydd = new Select(closurecode);
		subcategorydd.selectByVisibleText("Successful");

		close.click();
		wait.until(ExpectedConditions.elementToBeClickable(calendar));
		Thread.sleep(1000);
		String currentstatus = status.getAttribute("value");
		if ("3".equalsIgnoreCase(currentstatus)) {
			return true;
		}
		else {
			return false;
		}
	}

}
