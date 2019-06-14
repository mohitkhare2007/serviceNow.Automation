package serviceNow.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage_SSP {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage_SSP(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@FindBy(how=How.ID, using="user_name") 
	WebElement userName;
	
	@FindBy(how=How.ID, using="user_password") 
	WebElement password;
	
	@FindBy(how=How.ID, using="sysverb_login") 
	WebElement loginButton;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user_info_dropdown\"]/div/span[1]")
	//@FindBy(how=How.ID, using="user_info_dropdown") 
	WebElement userDropdown;
	
	@FindBy(how=How.LINK_TEXT, using="Impersonate User")    //"/html/body/div[5]/div/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li[2]/a") 
	WebElement impersonateUser;

	@FindBy(how=How.ID, using="select2-chosen-2") 
	WebElement impersonateDropdown;

	@FindBy(how=How.ID, using="s2id_autogen2_search")
	WebElement impersonateInput;

	@FindBy(how=How.XPATH, using="//*[@id=\"select2-results-2\"]/li")
	WebElement selectUser;
	
	@FindBy(how=How.LINK_TEXT, using="history_tab")
	WebElement historytab;
	
	@FindBy(how=How.LINK_TEXT, using="allApps_tab")
	WebElement allAppstab;
	
	@FindBy(how=How.ID, using="filter")
	WebElement filter;
	
	@FindBy(how=How.CLASS_NAME, using="app-node sn-aside-group-title sn-aside-group-title_selectable sn-aside-group-title_nav sn-aside-group-title_hidden nav-application-overwrite nav-open-state")
	WebElement selfservice;
	
	public void NavigateToHomePage(String UserName, String Password) throws InterruptedException
	{
		userName.sendKeys(UserName);
		password.sendKeys(Password);
		//Thread.sleep(1000);
		loginButton.click();
	}

	public void ImpersonateUser(String ImpersonateUser) throws InterruptedException
	{
		wait = new WebDriverWait(driver, 20);
		Thread.sleep(1000);
		userDropdown.click();
		Thread.sleep(1000);
		impersonateUser.click();
		Thread.sleep(2000);
		impersonateDropdown.click();
		Thread.sleep(2000);
		impersonateInput.sendKeys(ImpersonateUser);
		Thread.sleep(2000);
		selectUser.click();
		Thread.sleep(2000);
		/*historytab.click();
		allAppstab.click();
		if (driver.findElement(By.linkText("Self-Service")).isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Homepage")));
		}
		else {
			historytab.click();
			wait.until(ExpectedConditions.elementToBeClickable(filter));
			allAppstab.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("selfservice")));
		}*/
	}
}