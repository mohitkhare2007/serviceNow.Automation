package serviceNow.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackAnIncident {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public TrackAnIncident(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.LINK_TEXT, using="Track an Incident") 
	WebElement trackIncident;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Resolved/Closed") 
	WebElement closeIncident;
	
	@FindBy(how=How.XPATH, using="/html/body/div/section/main/div[1]/div/sp-page-row/div/div/span/div/div/div/div[2]/div[3]/div/div/div/div[2]/table/tbody/tr[1]/td[7]")
	WebElement incidentTable;
	
	public void NavigateToResolveCloseIncidentpage() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 60);
		trackIncident.click();
		wait.until(ExpectedConditions.elementToBeClickable(closeIncident));
		closeIncident.click();
		wait.until(ExpectedConditions.elementToBeClickable(incidentTable));
		Thread.sleep(1000);
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", incidentTable);
		//((JavascriptExecutor)driver).executeScript("$('#incidentTable').click();");
		incidentTable.click();
		wait.until(ExpectedConditions.elementToBeClickable(trackIncident));
	}
}
