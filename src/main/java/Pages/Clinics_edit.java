package Pages;
//import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;

//import Base.Clinician_data;
//import Base.Clinician_data;
//import org.openqa.selenium.WebDriver;
//import Base.Clinician_data;
import Base.Clinics_data;

import Base.TestBase;

public class Clinics_edit extends TestBase {
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement Clinics_tab;	
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody")
	WebElement Table_data;
	
	WebElement Edit_button_click;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[1]/div/div[2]/button")
	WebElement Back_button;
	
public Clinics_edit () {
	PageFactory.initElements(driver, this);
	
}

public void EditClinics(Clinics_data clinie) throws InterruptedException {
	Clinics_tab.click();
	Thread.sleep(3000);  
	
	List<WebElement> ClinicList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr"));
	//System.out.println("&"+CustList.size());
	for(int i=0;i<ClinicList.size();i++){
		try {
	    String ActClinicName = ClinicList.get(i).getText();
//	    System.out.println(ActClinicName);

	    Thread.sleep(1000);
	    if(ActClinicName.contains(clinie.Clinic_Name)){
	    	System.out.println(ActClinicName);
//	    	System.out.println(i);

			 Edit_button_click = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[1]"));
			 Edit_button_click.click();
//			 ViewClinics(clinie);
			 Thread.sleep(5000);	    	
//	    	Back_button.click();  	
	    	     break;	 
	   	    }
		}
		catch(StaleElementReferenceException s) {
			List<WebElement> ClinicList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr"));
			//System.out.println("&"+ClinicList1.size());
			 String ActClinicName = ClinicList1.get(i).getText();
//			 System.out.println(f.Full_Name);
			 Thread.sleep(1000);
			if(ActClinicName.contains(clinie.Clinic_Name)){
			//	System.out.println(ActClinicName);
//				System.out.println(i);
				
				 Edit_button_click = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[1]"));
				 Edit_button_click.click();
				 Thread.sleep(5000);
//				 Back_button.click();
				 break;	
		    	 		    	
		    }
		}
	} 
		
}

public void ViewClinics(Clinics_data viewc) throws InterruptedException {
	
	viewc = new Clinics_data();
	
	if (Clinics.ClinicName.getAttribute("value").contains(prop_Clinics.getProperty("Clinic_Name")))
	{
System.out.println("Clinic_Name : Present");
if (Clinics.RoomName1.getAttribute("value").contains((prop_Clinics.getProperty("Room_Name1"))))
{
System.out.println("Room_Name1 : Present");
if (Clinics.RoomName2.getAttribute("value").contains((prop_Clinics.getProperty("Room_Name2"))))
{
System.out.println("Room_Name2 : Present");
//if (Clinics.AddressLine1.getAttribute("value").contains((prop_Clinics.getProperty("Address_Line1")))) {
//	
//	System.out.println("Address_Line1 : Present");
	if (Clinics.AddressLine2.getAttribute("value").contains((prop_Clinics.getProperty("Address_Line2")))) {
		System.out.println("Address_Line2 : Present");
	}
	else
	{
		System.out.println("Error in Address_Line2");
	}
//}
//else
//{
//	System.out.println("Error in Address_Line1");
//}


}
else
{
	System.out.println("Error in Room_Name2");
}
}
else
{
	System.out.println("Error in Room_Name1");
}
	}
	else
	{
		System.out.println("Error in Clinic_Name");
	}
	Back_button.click();
	Thread.sleep(5000);
}



}
