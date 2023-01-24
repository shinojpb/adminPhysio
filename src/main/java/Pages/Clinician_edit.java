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
//import org.openqa.selenium.WebDriver;

import Base.Clinician_data;

import Base.TestBase;

public class Clinician_edit extends TestBase {
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement Clinicians_tab;	
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr[3]")
	WebElement Table_data;
	
	WebElement Edit_button_click;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-clinician/div[1]/div/div[2]/button")
	WebElement Back_button;
	
public Clinician_edit () {
	PageFactory.initElements(driver, this);
	
}

public void EditClinician(Clinician_data f) throws InterruptedException {
	Clinicians_tab.click();
	Thread.sleep(3000);  
	
	List<WebElement> CustList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr"));
	//System.out.println("&"+CustList.size());
	for(int i=0;i<CustList.size();i++){
		try {
	    String ActCustName = CustList.get(i).getText();
	  //  System.out.println(ActCustName);

	    Thread.sleep(1000);
	    if(ActCustName.contains(f.Email_id)){
	    	System.out.println(ActCustName);
//	    	System.out.println(i);

			 Edit_button_click = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[1]"));
			 Edit_button_click.click();
			 ViewClinician(f);
			 Thread.sleep(5000);	    	
	    	//Back_button.click();  	
	    	     break;	 
	   	    }
		}
		catch(StaleElementReferenceException s) {
			List<WebElement> CustList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr"));
			//System.out.println("&"+CustList1.size());
			 String ActCustName = CustList1.get(i).getText();
//			 System.out.println(f.Full_Name);
			 Thread.sleep(1000);
			if(ActCustName.contains(f.Email_id)){
			//	System.out.println(ActCustName);
//				System.out.println(i);
				
				 Edit_button_click = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[1]"));
				 Edit_button_click.click();
				 Thread.sleep(5000);
				// Back_button.click();
				 break;	
		    	 		    	
		    }
		}
	} 
	
	
}

public void ViewClinician(Clinician_data view) throws InterruptedException {
	
	view=new Clinician_data();

	if (Clinician.Fullname.getAttribute("value").contains(prop_clinician.getProperty("Full_Name")))
			{
		System.out.println("Fullname : Present");
		if (Clinician.Provider_Id.getAttribute("value").contains(prop_clinician.getProperty("Provider_Id")))
		{
	System.out.println("Provider_Id : Present");
	if (Clinician.Email_Id.getAttribute("value").contains(prop_clinician.getProperty("Email_id")))
	{
		System.out.println("Email_Id : Present");
//		if (Clinician.Vendor_No.getAttribute("value").contains(prop_clinician.getProperty("Vendor_No"))) {
//			
//			System.out.println("Success4");
			if (Clinician.Secondary_Email_Id.getAttribute("value").contains(prop_clinician.getProperty("Secondary_Email"))) {
				System.out.println("Secondary_Email_Id : Present");
				if (Clinician.Experience.getAttribute("value").contains(prop_clinician.getProperty("Experience"))) {
					System.out.println("Experience : Present");
					if (Clinician.ACC_No.getAttribute("value").contains(prop_clinician.getProperty("ACC_No"))) {
						System.out.println("ACC_No : Present");
					}
					else
					{
						System.out.println("Error in ACC_No");
					}
				}
				else
				{
					System.out.println("Error in Experience");
				}
			}
			else
			{
				System.out.println("Error in Secondary_Email_Id");
			}
//		}
//		else
//		{
//			System.out.println("Error in Vendor_No");
//		}
	}
	else
	{
		System.out.println("Error in Email_Id");
	}
		}
		else
		{
			System.out.println("Error in Provider_Id");
		}
	
}
	else
	{
		System.out.println("Error in Fullname");
	}

}
}