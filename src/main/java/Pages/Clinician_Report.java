package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class Clinician_Report extends TestBase{

	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[10]/a")
	WebElement ClinicianReport_tab;
	@FindBy(xpath = "//*[@id=\"category\"]")
	WebElement Cliniciandropdown_select_tab;
	WebElement Cliniciandropdown_tab;
	@FindBy(xpath = "//input[@formcontrolname ='startDate']")
	WebElement StartingDate_tab;
	@FindBy(xpath = "//input[@formcontrolname ='endDate']")
	WebElement EndingDate_tab;
	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div/div/div/button")
	WebElement ClinicianViewReport_tab;
	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div/div/div/form/div/div[5]/ng-multiselect-dropdown/div")
	WebElement ServicedropDown_tab;
	WebElement ServicedropDown;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-clinician-reports/div[3]/div/div/ng-custom-table/div/div[2]/div/table/tbody")
	WebElement serviceErrorMessage;
	
	
	
	
	public Clinician_Report() {
		PageFactory.initElements(driver, this);
	}
	
public void ViewClinicianReport() throws InterruptedException{
		
	ClinicianReport_tab.click();
	Thread.sleep(3000);
		
		Select RecordsPerPage = new Select(driver.findElement(By.xpath("//*[@id=\"category\"]")));
		RecordsPerPage.selectByVisibleText("Jeeva clinic");
		RecordsPerPage.selectByIndex(3);
//		System.out.println("Jeeva clinic...");
		
		Cliniciandropdown_select_tab.click();
		Thread.sleep(3000);
		String xx = "Sachin";
		String clinicpath = "//input[@aria-label='" + xx  + "']";		
		Cliniciandropdown_tab = driver.findElement(By.xpath(clinicpath));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Cliniciandropdown_tab);
		 Thread.sleep(3000);
		
		 String sdate="1-January-2023";
			String edate="18-January-2023";
			StartingDate_tab.click();
			String splitter[] = sdate.split("-");
			String month_year = splitter[1];
			String day = splitter[0]; 
			selectDate(month_year,day); 
			Thread.sleep(3000);
			
			EndingDate_tab.click();
			
			String splitter1[] = edate.split("-");
			String month_year1 = splitter1[1];
			System.out.println(splitter1[0]);
			String day1 = splitter1[0]; 
			System.out.println(month_year1);
			System.out.println(day1);
			selectDate(month_year1,day1); 
			Thread.sleep(4000);
			ServicedropDown_tab.click();
			Thread.sleep(3000);
			String xx2 = "Exercise Based Rehabilitation - 45";
			String servicepath = "//input[@aria-label='" + xx2  + "']";		
			ServicedropDown = driver.findElement(By.xpath(servicepath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ServicedropDown);
			 Thread.sleep(3000);
			 ServicedropDown_tab.click();
				Thread.sleep(3000);
			ClinicianViewReport_tab.click();
			Thread.sleep(6000);
			List<WebElement> ClinicianReportList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-clinician-reports/div[3]/div/div/ng-custom-table/div/div[2]/div/table"));
//			System.out.println(UserReportList.get(0).getText());
			for(int i=0;i<ClinicianReportList.size();i++)
			{
				System.out.println("patient Details : "+ClinicianReportList.get(i).getText());
				
				if(serviceErrorMessage.getText().contains("No Data Available"))
				{
					System.out.println("No Clinician Reports so far...");
				}else {
					
					System.out.println("Clinician Reports is present");
				}
				
			}
		
		
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
