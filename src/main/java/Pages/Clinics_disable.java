package Pages;
//import java.util.ArrayList;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;


//import Base.Clinician_data;
import Base.Clinics_data;
import Base.TestBase;

public class Clinics_disable extends TestBase {
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement Clinics_tab;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody")
	WebElement Table_data;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinics/div[3]/div/div/div[3]/button[1]")
	WebElement DisableYes_button1;
	
	WebElement disable1;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement Clinicians_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinicians/div[1]/div/div[2]/button")
	WebElement Clinician_Add_button;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinics/div[1]/div/div[2]/button")
	WebElement Add_button;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[1]/div[3]/button")
	WebElement Rooms_add;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[1]/div[3]/div[4]/div[2]/i")
	WebElement Rooms_delete;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[7]/ng-multiselect-dropdown/div")
	WebElement Clinic_Name;
	
	WebElement ClinicName_Dropdown;
	
//	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div[1]/a")
//	WebElement therapist_tab;
//
//	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[1]/div[1]/input")
//	WebElement emailc;
//	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[2]/input")
//	WebElement passwordc;
//
//	@FindBy(xpath="/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div/button")
//	WebElement login_btn;
	
	@FindBy(xpath="/html/body/app-dashboard/app-header/ul/li/a/img")
	WebElement image_tab;
	
//	@FindBy(xpath="/html/body/app-dashboard/app-header/ul/li/div/a[2]")
//	WebElement logout;
	
	
	
public Clinics_disable () {
	PageFactory.initElements(driver, this);
	
}

public void DisableClinics(Clinics_data disc) throws InterruptedException {
	Clinics_tab.click();
	Thread.sleep(3000);  
	
	List<WebElement> ClinicsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr"));
	
	for(int i=0;i<ClinicsList.size();i++){
		try {
	    String ActClinicName = ClinicsList.get(i).getText();
//	    System.out.println(ActCustName);

	    Thread.sleep(1000);
	    if(ActClinicName.contains(disc.Clinic_Name)){
	    	System.out.println(ActClinicName);
//	    	System.out.println(i);
	    	
	    	 disable1=driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[3]"));
	    	 Thread.sleep(3000);
	    	 
	   	    }
		}
		catch(StaleElementReferenceException s) {
			List<WebElement> ClinicsList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr"));
//			System.out.println("@"+CustList1.get(i).getText());
			 String ActClinicName = ClinicsList1.get(i).getText();
//			 System.out.println(f.Full_Name);
			if(ActClinicName.contains(disc.Clinic_Name)){
				System.out.println(ActClinicName);
//				System.out.println(i);				
	    	 
		    	 disable1=driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinics/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[3]"));
		    	Thread.sleep(3000);
		    	
		    }
		}
	} 

	disable1.click();
	Thread.sleep(3000);
	DisableYes_button1.click();
	Thread.sleep(5000);
	image_tab.click();
	Thread.sleep(3000);
//	logout.click();	
	
	WebElement button = driver.findElement(By.xpath("/html/body/app-dashboard/app-header/ul/li/div/a[2]/i"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", button);
	
	Thread.sleep(3000);
	
}
//(Clinics_data disc1)
public void DisableClinics1() throws InterruptedException {
	Clinicians_tab.click();
	Thread.sleep(3000);
	Clinician_Add_button.click();
	Thread.sleep(3000);
	Clinic_Name.click();
	Thread.sleep(3000);
	
	
	String c = "Jeeva clinic";
	List<WebElement> clinicList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-add-clinician/div[2]/form/div/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]"));
	for(int i=0;i<clinicList.size();i++) {
		if(clinicList.get(i).getText().contains(c)) {
			System.out.println("clinic is  present");
			
		}
		else {
			System.out.println("clinic is  Absent");
		}
		
	}
}

public void RoomsClinics() throws InterruptedException {
	Clinics_tab.click();
	Thread.sleep(3000);  
	Add_button.click();
	Thread.sleep(3000);
	Rooms_add.click();
	Thread.sleep(3000);
	Rooms_add.click();
	Thread.sleep(3000);
	Rooms_delete.click();
	Thread.sleep(3000);
	Rooms_add.click();
	Thread.sleep(3000);
	
	
	
	
	
	//List <WebElement> Roomlist = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div"));
	List <WebElement> Roomlist = driver.findElements(By.xpath("//input[@formcontrolname='roomName']"));
	
	
	System.out.println("No of Rooms added : " + Roomlist.size());
	String RoomsAdded = Integer.toString(Roomlist.size());
	
	WebElement Roomcount = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[1]/div[3]/div[1]/label[2]"));
	String[] Roomcounts = Roomcount.getText().split("No of Rooms - ");
	System.out.println("Rooms count : " + Roomcounts[1]);
	
	if(RoomsAdded.equals(Roomcounts[1])) {
		System.out.println("Room count Matched");		
	}
	else
	{
		System.out.println("Room count not Matched");
	}


	
}

}