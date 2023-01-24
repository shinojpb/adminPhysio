package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class Revenue_Report extends TestBase{
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[10]/a")
	WebElement ClinicianReport_tab;
	@FindBy(xpath = "//*[@id=\"headingTwo\"]/h5/button")
	WebElement RevenueReport_tab;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinician-reports/div[1]/div[2]/div/div[2]/div[2]/div/form/div/div[1]/select")
	WebElement ClinicLocations_tab;
	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/div/form/div/div[2]/ng-multiselect-dropdown/div")
	WebElement ClinicianLists_tab;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinician-reports/div[1]/div[2]/div/div[2]/div[2]/div/form/div/div[3]/div[1]/input")
	WebElement StartingDate;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinician-reports/div[1]/div[2]/div/div[2]/div[2]/div/form/div/div[4]/div[1]/input")
	WebElement EndingDate;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinician-reports/div[1]/div[2]/div/div[2]/div[2]/div/form/div/div[5]/ng-multiselect-dropdown/div")
	WebElement ServicesList;
	WebElement ServicesListDropdown;
	
	
	public Revenue_Report() {
		PageFactory.initElements(driver, this);
	}
	
	public void ViewRevenueReport() throws InterruptedException{
		
		ClinicianReport_tab.click();
		Thread.sleep(3000);
		RevenueReport_tab.click();
		Thread.sleep(3000);
		
		ClinicLocations_tab.click();
		Thread.sleep(3000);
		Select category = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-reports/div[1]/div[2]/div/div[2]/div[2]/div/form/div/div[1]/select")));
		category.selectByVisibleText("Jeeva clinic");
		category.selectByIndex(3);
		ClinicLocations_tab.click();
		Thread.sleep(3000);
		
		ClinicianLists_tab.click();
		Thread.sleep(3000);		
		List<WebElement> ClinicianOptions = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/form/div/div[2]/ng-multiselect-dropdown/div"));
//		System.out.println(UserReportList.get(0).getText());
		for(int i=0;i<ClinicianOptions.size();i++)
		{
			System.out.println("Clinician Lists : "+ClinicianOptions.get(i).getText());
			
			if(ClinicianOptions.get(i).getText().contains("No data available"))
			{
				System.out.println("No Clinician Lists so far...");
			}else {
				
				System.out.println("Clinician Lists is present...");
			}
			
		}
		ClinicianLists_tab.click();
		Thread.sleep(3000);		

		 String sdate="1-January-2023";
			String edate="18-January-2023";
			StartingDate.click();
			String splitter[] = sdate.split("-");
			String month_year = splitter[1];
			String day = splitter[0]; 
			selectDate(month_year,day); 
			Thread.sleep(3000);
			
			EndingDate.click();
			
			String splitter1[] = edate.split("-");
			String month_year1 = splitter1[1];
			System.out.println(splitter1[0]);
			String day1 = splitter1[0]; 
			System.out.println(month_year1);
			System.out.println(day1);
			selectDate(month_year1,day1); 
			Thread.sleep(4000);
			
			ServicesList.click();
			Thread.sleep(3000);	
			String xx = "Exercise-Based Rehabilitation - 30";
			String clinicpath = "//input[@aria-label='" + xx  + "']";		
			ServicesListDropdown = driver.findElement(By.xpath(clinicpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ServicesListDropdown);
			 Thread.sleep(3000);
			ServicesList.click();
			Thread.sleep(3000);	
		
		
		
	}
	public void selectDate(String month_year, String select_day) throws InterruptedException
	{ 
	List<WebElement> elements = driver.findElements(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]"));

	for (int i=0; i<elements.size();i++)
	{

	if(elements.get(i).getText().contains(month_year))
	{ 
	List<WebElement> days = driver.findElements(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr/td"));
	for (WebElement d:days)
	{ 
	if(d.getText().equals(select_day))
	{
	d.click();
	Thread.sleep(10000);
	break;
	}
	} 

	} 

	}

	}
	
}
