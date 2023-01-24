package Pages;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.TestBase;
import Base.Videos_data;

public class User_Report extends TestBase {

	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[9]/a")
	WebElement UserReport_tab;
	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/button")
	WebElement ViewReport_btn;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-view-user-report/button")
	WebElement Userreport_Export_btn;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-view-user-report/div/div/div[2]/a")
	WebElement Userreport_Back_btn;
	
	@FindBy(xpath = "//*[@id=\"headingTwo\"]/h5/button")
	WebElement OneSpecific_client_tab;
	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/div/div/div/div/form/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement SearchName_field;
	@FindBy(xpath = "//input[@formcontrolname ='startDate']")
	WebElement StartingDate_field;
	@FindBy(xpath = "//input[@formcontrolname ='endDate']")
	WebElement EndingDate_field;
	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/div/div/div/div/button")
	WebElement OneClient_ViewReport_btn;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-user-reports/app-user-report/div[2]/div/div/button")
	WebElement OneClient_Export_btn;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-user-reports/app-user-report/div[2]/div/div/div[2]/button")
	WebElement OneClient_Close_btn;
	
//	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[10]/a")
//	WebElement ClinicianReport_tab;
//	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div/div/div/form/div/div[2]/ng-multiselect-dropdown/div/div[2]")
//	WebElement Cliniciandropdown_select_tab;
//	WebElement Cliniciandropdown_tab;
	
	public User_Report() {
		PageFactory.initElements(driver, this);
	}
	
	public void ViewUserReport() throws InterruptedException{
		UserReport_tab.click();
		Thread.sleep(3000);
		ViewReport_btn.click();
		Thread.sleep(3000);
		List<WebElement>UsersList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-view-user-report/ng-custom-table/div/div[2]/div/table"));
		for(int i=0;i<UsersList.size();i++){
			
			String UserCategorieslist = UsersList.get(i).getText();
			System.out.println("lists name : " + UserCategorieslist);
		}
		
		Select RecordsPerPage = new Select(driver.findElement(By.xpath("//*[@id=\"container\"]/div/app-view-user-report/ng-custom-table/div/div[2]/ng-pagination-util/div/div[3]/select")));
		RecordsPerPage.selectByVisibleText("Show 5 Records Per Page");
		RecordsPerPage.selectByIndex(0);
		System.out.println("It Shows 5 Records Per Page...");
		
//		Userreport_Export_btn.click();
//		Thread.sleep(3000);
//		Userreport_Back_btn.click();
//		Thread.sleep(6000);
//		String URL = driver.getCurrentUrl();
//		Assert.assertEquals(URL, "http://182.76.66.74/physiotheraphy/admin/user-report" );
//		System.out.println("Back button is working properly...");
	}
	
	public void ViewUserReport_OnespecificClient() throws InterruptedException{
		UserReport_tab.click();
		Thread.sleep(3000);
		OneSpecific_client_tab.click();
		Thread.sleep(3000);
		SearchName_field.click();
		Thread.sleep(3000);
		SearchName_field.sendKeys("Tester");
		Thread.sleep(3000);
		SearchName_field.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		SearchName_field.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		String sdate="1-January-2023";
		String edate="18-January-2023";
		StartingDate_field.click();
		String splitter[] = sdate.split("-");
		String month_year = splitter[1];
		String day = splitter[0]; 
		selectDate(month_year,day); 
		Thread.sleep(3000);
		
		EndingDate_field.click();
		
		String splitter1[] = edate.split("-");
		String month_year1 = splitter1[1];
		System.out.println(splitter1[0]);
		String day1 = splitter1[0]; 
		System.out.println(month_year1);
		System.out.println(day1);
		selectDate(month_year1,day1); 
		Thread.sleep(4000);
		OneClient_ViewReport_btn.click();
		Thread.sleep(6000);
		List<WebElement> UserReportList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-user-reports/app-user-report/div[2]/div/div/ng-custom-table/div/div[2]/div/table"));
//		System.out.println(UserReportList.get(0).getText());
		for(int i=0;i<UserReportList.size();i++)
		{
			System.out.println("patient Details : "+UserReportList.get(i).getText());
			
		}
		
		OneClient_Export_btn.click();
		Thread.sleep(4000);
		OneClient_Close_btn.click();
		Thread.sleep(4000);
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
		
		
		
	
	

