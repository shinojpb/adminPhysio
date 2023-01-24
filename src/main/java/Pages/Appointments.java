package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.Appointments_data;
import Base.TestBase;

public class Appointments extends TestBase{
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[5]/a")
	WebElement Appointments_tab;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/nav/div/a[3]")
	WebElement ClinicNav_tab;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[1]/div[6]/div/div[2]")
	WebElement week_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement Name_field;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[6]/select")
	WebElement Service_field;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[8]/select")
	WebElement Duration_field;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[13]/select")
	WebElement Clinic_Rooms_field;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[14]/select")
	WebElement Clinician_field;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[16]/textarea")
	WebElement Notes_field;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[3]/button[1]")
	WebElement Appo_create_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[3]/button[2]")
	WebElement Appo_cancel_btn;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[4]/div/div/button[1]")
	WebElement AppoDetails_Edit_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[3]/button[1]")
	WebElement AppoDetails_close_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[3]/button[2]")
	WebElement AppoDetails_update_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[13]/div/textarea")
	WebElement AppoDetails_notes_field;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[4]/div/div/button[2]")
	WebElement AppoDetails_Reschedule_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[10]/div[2]/div[1]/input")
	WebElement AppoDetails_Endtime_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[3]/button[1]")
	WebElement AppoDetailsR_close_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[3]/button[2]")
	WebElement AppoDetailsR_Reschedule_btn;
	
	
	public Appointments() {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickAppointments() throws InterruptedException{
		Appointments_tab.click();
		Thread.sleep(3000);
		List<WebElement> ClinicsNavOptions = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/nav/div"));
//		System.out.println(ClinicsNavOptions.get(0).getText());
		for(int i=0;i<ClinicsNavOptions.size();i++)
		{
//			System.out.println("Clinics Lists : "+ClinicsNavOptions.get(i).getText());
			if(ClinicsNavOptions.get(i).getText().contains("Jeeva clinic")) {
				
				System.out.println("Clinic present");
				ClinicNav_tab.click();
				Thread.sleep(3000);
				week_tab.click();
				Thread.sleep(3000);
				
				
			}else {
				System.out.println("Clinic not  present");
				
			}
		}
		
		List<WebElement> CallTimeOptions = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[1]"));
		for(int i=0;i<CallTimeOptions.size();i++)
		{
			System.out.println("CallTime Lists : "+CallTimeOptions.get(i).getText());
       if(CallTimeOptions.get(i).getText().contains("2 PM")) {
				
				System.out.println("Time present");
				Actions action = new Actions(driver);
				WebElement Time = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[2]/div[2]/div[10]/mwl-calendar-week-view-hour-segment["+(i+1)+"]/div"));
				Thread.sleep(5000);
				action.contextClick(Time).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				action.perform();
				Thread.sleep(5000);	
				

}
			
		}
		
		
		Name_field.sendKeys("Test");
		Thread.sleep(3000);	
		Name_field.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		Name_field.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Select RecordsPerPage = new Select(Service_field);
		RecordsPerPage.selectByVisibleText("Spinal Therapy");
		Thread.sleep(3000);
		Select Duration = new Select(Duration_field);
		Duration.selectByVisibleText("30");
		Thread.sleep(3000);
		Select Rooms = new Select(Clinic_Rooms_field);
		Rooms.selectByVisibleText("General Room");
		Thread.sleep(3000);
		Select Clinician = new Select(Clinician_field);
		Clinician.selectByVisibleText("Sachin");
		Thread.sleep(3000);
		Notes_field.sendKeys("This is for testing purpose...");
		Thread.sleep(3000);
		Appo_create_btn.click();
		Thread.sleep(3000);
//		Appo_cancel_btn.click();
//		Thread.sleep(3000);		
		
	}
	
	public void ViewAppointments() throws InterruptedException{
		Appointments_tab.click();
		Thread.sleep(3000);
		List<WebElement> ClinicsNavOptions2 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/nav/div"));
//		System.out.println(ClinicsNavOptions.get(0).getText());
		for(int i=0;i<ClinicsNavOptions2.size();i++)
		{
//			System.out.println("Clinics Lists : "+ClinicsNavOptions.get(i).getText());
			if(ClinicsNavOptions2.get(i).getText().contains("Jeeva clinic")) {
				
				System.out.println("Clinic present");
				ClinicNav_tab.click();
				Thread.sleep(3000);
				week_tab.click();
				Thread.sleep(3000);
				
				
			}else {
				System.out.println("Clinic not  present");
				
			}
		}
		
		List<WebElement> CallTimeOptions2 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[1]"));
		for(int i=0;i<CallTimeOptions2.size();i++)
		{
//			System.out.println("CallTime Lists : "+CallTimeOptions2.get(i).getText());
       if(CallTimeOptions2.get(i).getText().contains("2 PM")) {
				
//				System.out.println("Time present");
				Actions action = new Actions(driver);
				WebElement Time = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[2]/div[2]/div[10]/mwl-calendar-week-view-hour-segment["+(i+1)+"]/div"));
				Thread.sleep(5000);
				action.contextClick(Time).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				action.perform();
				Thread.sleep(5000);	
				List<WebElement> AppointmentDetailsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]"));
				System.out.println("details are : " + AppointmentDetailsList.get(i).getText());
	}
	
	
}
	}
	
	public void EditAppointments() throws InterruptedException{
		Appointments_tab.click();
		Thread.sleep(3000);
		List<WebElement> ClinicsNavOptions3 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/nav/div"));
//		System.out.println(ClinicsNavOptions.get(0).getText());
		for(int i=0;i<ClinicsNavOptions3.size();i++)
		{
//			System.out.println("Clinics Lists : "+ClinicsNavOptions.get(i).getText());
			if(ClinicsNavOptions3.get(i).getText().contains("Jeeva clinic")) {
				
				System.out.println("Clinic present");
				ClinicNav_tab.click();
				Thread.sleep(3000);
				week_tab.click();
				Thread.sleep(3000);
				
				
			}else {
				System.out.println("Clinic not  present");
				
			}
		}
		
		List<WebElement> CallTimeOptions3 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[1]"));
		for(int i=0;i<CallTimeOptions3.size();i++)
		{
//			System.out.println("CallTime Lists : "+CallTimeOptions2.get(i).getText());
       if(CallTimeOptions3.get(i).getText().contains("2 PM")) {
				
//				System.out.println("Time present");
				Actions action = new Actions(driver);
				WebElement Time = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[2]/div[2]/div[10]/mwl-calendar-week-view-hour-segment["+(i+1)+"]/div"));
				Thread.sleep(5000);
				action.contextClick(Time).sendKeys(Keys.ARROW_DOWN);
				action.contextClick(Time).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				action.perform();
				Thread.sleep(5000);	
				
	}
	
	
}
		AppoDetails_Edit_btn.click();
		Thread.sleep(5000);
		AppoDetails_notes_field.clear();
		Thread.sleep(1000);
		AppoDetails_notes_field.sendKeys("This is for edit testing purpose...");
		Thread.sleep(3000);
//		AppoDetails_close_btn.click();
//		Thread.sleep(3000);
		AppoDetails_update_btn.click();
		Thread.sleep(3000);
		
		
	}
	
	public void RescheduleAppointments() throws InterruptedException{
		Appointments_tab.click();
		Thread.sleep(3000);
		List<WebElement> ClinicsNavOptions4 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/nav/div"));
//		System.out.println(ClinicsNavOptions.get(0).getText());
		for(int i=0;i<ClinicsNavOptions4.size();i++)
		{
//			System.out.println("Clinics Lists : "+ClinicsNavOptions.get(i).getText());
			if(ClinicsNavOptions4.get(i).getText().contains("Jeeva clinic")) {
				
				System.out.println("Clinic present");
				ClinicNav_tab.click();
				Thread.sleep(3000);
				week_tab.click();
				Thread.sleep(3000);
				
				
			}else {
				System.out.println("Clinic not  present");
				
			}
		}
		
		List<WebElement> CallTimeOptions4 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[1]"));
		for(int i=0;i<CallTimeOptions4.size();i++)
		{
//			System.out.println("CallTime Lists : "+CallTimeOptions2.get(i).getText());
       if(CallTimeOptions4.get(i).getText().contains("2 PM")) {
				
//				System.out.println("Time present");
				Actions action = new Actions(driver);
				WebElement Time = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[2]/div[2]/div[10]/mwl-calendar-week-view-hour-segment["+(i+1)+"]/div"));
				Thread.sleep(5000);
				action.contextClick(Time).sendKeys(Keys.ARROW_DOWN);
				action.contextClick(Time).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				action.perform();
				Thread.sleep(5000);	
				
	}
	
}
		AppoDetails_Reschedule_btn.click();
		Thread.sleep(3000);	
		AppoDetails_Endtime_btn.clear();
		AppoDetails_Endtime_btn.sendKeys("18:00");
		Thread.sleep(3000);	
		AppoDetailsR_close_btn.click();
		Thread.sleep(3000);	
//		AppoDetailsR_Reschedule_btn.click();
//		Thread.sleep(3000);	
		
		
	}
	
	public void GroupclassAppointments() throws InterruptedException{
		
			Appointments_tab.click();
			Thread.sleep(3000);
			List<WebElement> ClinicsNavOptions5 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/nav/div"));
//			System.out.println(ClinicsNavOptions.get(0).getText());
			for(int i=0;i<ClinicsNavOptions5.size();i++)
			{
//				System.out.println("Clinics Lists : "+ClinicsNavOptions.get(i).getText());
				if(ClinicsNavOptions5.get(i).getText().contains("Jeeva clinic")) {
					
					System.out.println("Clinic present");
					ClinicNav_tab.click();
					Thread.sleep(3000);
					week_tab.click();
					Thread.sleep(3000);
					
					
				}else {
					System.out.println("Clinic not  present");
					
				}
			}
			
			List<WebElement> CallTimeOptions5 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[1]"));
			for(int i=0;i<CallTimeOptions5.size();i++)
			{
//				System.out.println("CallTime Lists : "+CallTimeOptions2.get(i).getText());
	       if(CallTimeOptions5.get(i).getText().contains("2 PM")) {
					
//					System.out.println("Time present");
					Actions action = new Actions(driver);
					WebElement Time = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-calendar-week-view/div/div/div[2]/div[2]/div[15]/mwl-calendar-week-view-hour-segment[1]/div"));
					Thread.sleep(5000);
					action.contextClick(Time).sendKeys(Keys.ARROW_DOWN);
					action.contextClick(Time).sendKeys(Keys.ARROW_DOWN);
					action.contextClick(Time).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					action.perform();
					Thread.sleep(5000);	
					
		}
		
	}			
		
		
	}
	
	
	
	
}
