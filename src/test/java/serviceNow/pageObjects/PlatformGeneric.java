package serviceNow.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlatformGeneric {

	WebDriver driver;
	WebDriverWait wait;
	
	public PlatformGeneric(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="filter") 
	WebElement filternavigation;
	
	@FindBy(how=How.LINK_TEXT, using="Dashboard")
	WebElement DashboardBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"label.cmdb_ci_appl.assignment_group\"]/label/span[2]") 
	WebElement PrimaryAssignmentGroupLabel;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sys_display.cmdb_ci_appl.u_service_delivery_lead\"]") 
	WebElement ServiceDeliveryLead;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"hdr_sys_user_role\"]/th[2]/button") 
	WebElement RoleSearchToggle;
	
	@FindBy(how=How.ID, using="sys_user_role_table_header_search_control") 
	WebElement RoleName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sys_user_role_table\"]/tbody/tr/td[3]/a") 
	WebElement RoleLink;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sys_user_role.sys_user_role_contains.role_table\"]/tbody/tr/td[3]/a") 
	WebElement InheritRoles;
	
		
	public void PlatformNavigation(String FilterNavigation, String MenuItem) throws InterruptedException
	{
		wait = new WebDriverWait(driver, 60);
		Thread.sleep(2500);
		filternavigation.sendKeys(FilterNavigation);
		Thread.sleep(1500);
		driver.findElement(By.linkText(MenuItem)).click();
		//Thread.sleep(10000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
	}
	
	public void SelectApplication(String Application) throws InterruptedException
	{
		wait = new WebDriverWait(driver, 20);
		WebElement appLink = driver.findElement(By.linkText(Application));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appLink);
		Thread.sleep(2000);
	}
	
	public boolean ApplicationsFieldChk_PrimaryAssignmentGroup() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 60);
		if(PrimaryAssignmentGroupLabel.isDisplayed() || PrimaryAssignmentGroupLabel.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean ApplicationsFieldChk_ServiceDeliveryLead(String eMailID) throws InterruptedException
	{
		wait = new WebDriverWait(driver, 60);
		if(ServiceDeliveryLead.isDisplayed()) {
			if(ServiceDeliveryLead.isEnabled()) {
				//if(eMailID.contains("@mysainsburys.co.uk")) {
				return false;
			}
			/*else
				return true;
			}*/
			else if(!ServiceDeliveryLead.isEnabled()) {
				//if(eMailID.contains("@mysainsburys.co.uk")) {
				return true;
			}
			else {
				return false;
			}
			/*else {
				return false;
			}*/
		}
		else {
			return false;
		}
	}

	public boolean Search_Role(String Role, String InheritRole) throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		
		if (!RoleName.isDisplayed()) {
			RoleSearchToggle.click();
		}
		
		RoleName.sendKeys(Role);
		RoleName.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(RoleLink));
		RoleLink.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(InheritRoles));
		String currentrole = InheritRoles.getText();
		
		if (InheritRole.equalsIgnoreCase(currentrole)) {
			return true;
		}
		else {
			return false;
		}
		
	}

}