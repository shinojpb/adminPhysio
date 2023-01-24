package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
//import Base.Clinician_data;
import Base.Clinics_data;
import Base.TestBase;

public class Clinics extends TestBase {

	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement Clinics_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinics/div[1]/div/div[2]/button/i")
	WebElement Add_button;
	
	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[1]/div[1]/input")
	WebElement ClinicName;
	
	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[1]/div[3]/div[2]/div[1]/input")
	WebElement RoomName1;
	
	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[1]/div[3]/div[4]/div[1]/input")
	WebElement RoomName2;
	
	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[1]/div[3]/button")
	WebElement AddRooms;
	
	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[2]/div[1]/input")
	WebElement AddressLine1;

	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/form/div/div[2]/div[3]/input")
	WebElement AddressLine2;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-clinics/div[2]/div/div/div/button")
	WebElement Save_btn;

	
	public Clinics() {
		PageFactory.initElements(driver, this);
		
	}

	
	public void AddClinics(Clinics_data addc) throws InterruptedException {
		
		Clinics_tab.click();
		Thread.sleep(3000);
		Add_button.click();
		Thread.sleep(3000);
		ClinicName.sendKeys(addc.Clinic_Name);
		Thread.sleep(3000);
		RoomName1.sendKeys(addc.Room_Name1);
		Thread.sleep(3000);
		AddRooms.click();
		Thread.sleep(3000);
		RoomName2.sendKeys(addc.Room_Name2);
		Thread.sleep(3000);
		AddressLine1.click();
		Thread.sleep(3000);
		AddressLine1.sendKeys(addc.Address_Line1);
		Thread.sleep(3000);
		AddressLine1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		AddressLine1.click();
		Thread.sleep(3000);
		AddressLine1.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		AddressLine2.sendKeys(addc.Address_Line2);
		Thread.sleep(3000);
		
		Save_btn.click();
		Thread.sleep(3000);
		
		
	}
	
}
