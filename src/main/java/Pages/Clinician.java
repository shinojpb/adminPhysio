package Pages;
//import java.util.ArrayList;
//import java.util.List;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import Base.Clinician_data;

import Base.TestBase;

public class Clinician extends TestBase {
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement Clinicians_tab;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-clinicians/div[1]/div/div[2]/button/b")
	WebElement Add_button;
	
	public static @FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[1]/div[1]/input")
	WebElement Fullname;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[1]/ng-multiselect-dropdown/div")
	WebElement Specialization;
	//@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[1]/ng-multiselect-dropdown/div//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]")
	WebElement Spec_dropdown;
	
	public static @FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[1]/div[3]/input")
	WebElement ACC_No;
	
	public static @FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[3]/input")
	WebElement Vendor_No;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[1]/div[5]/div/div[1]/div/input")
	WebElement Date_of_Birth;
	
	public static @FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[5]/input")
	WebElement Provider_Id;
	
	public static @FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[1]/div[8]/div/input")
	WebElement Experience;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[7]/ng-multiselect-dropdown/div")
	WebElement Clinic_Name;
	
	WebElement ClinicName_Dropdown;
	
	public static @FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[1]/div[10]/input")
	WebElement Email_Id;
	
	public static @FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/form/div/div[2]/div[9]/input")
	WebElement Secondary_Email_Id;
	
//	@FindBy(xpath = "//*[@id=\"GenderRadio1\"]")
//	WebElement Gender;
	
	//WebElement Gender = driver.findElement(By.id("GenderRadio1"));
	
	WebElement Gender;
	
	public static @FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement Mobile_Number;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-clinician/div[2]/div/div/div/button")
	WebElement save_button;
	
	public Clinician() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void AddClinician(Clinician_data c) throws InterruptedException {
		Clinicians_tab.click();
//		Thread.sleep(3000);
		Add_button.click();
//		Thread.sleep(3000);
		Fullname.sendKeys(c.Full_Name);
//		Thread.sleep(3000);
		Specialization.click();
		//Specialization.sendKeys("Therapist");
		Thread.sleep(3000);
		String[] specsarr = c.Specialization.split(","); 
		for (String spec : specsarr) 
        {
			String specxpath = "//input[@aria-label='" + spec  + "']";		
			 Spec_dropdown = driver.findElement(By.xpath(specxpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);
			Thread.sleep(1000);
        }
		Specialization.click();
//		Thread.sleep(3000);
		ACC_No.sendKeys(c.ACC_No);
//		Thread.sleep(3000);
		Vendor_No.sendKeys(c.Vendor_No);
//		Thread.sleep(3000);
		Date_of_Birth.sendKeys(c.DOB);
//		Thread.sleep(3000);
		Provider_Id.sendKeys(c.Provider_Id);
//		Thread.sleep(3000);
		Experience.sendKeys(c.Experience);
//		Thread.sleep(3000);
		Clinic_Name.click();
//		Thread.sleep(2000);
		
//		String xx = "Balmoral Medical Centre";
		String[] clinicsarr = c.Clinic_Name.split(","); 
		for (String clini : clinicsarr) {
			String clinicpath = "//input[@aria-label='" + clini  + "']";		
			ClinicName_Dropdown = driver.findElement(By.xpath(clinicpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ClinicName_Dropdown);
			 Thread.sleep(3000);
		}
		
		 Clinic_Name.click();
		 Thread.sleep(2000);
//		 Clinic_Name.sendKeys("24cliinics");
//		 Thread.sleep(3000);
		 Email_Id.sendKeys(c.Email_id);
//		 Thread.sleep(3000);
		 Secondary_Email_Id.sendKeys(c.Secondary_Email);
//		 Thread.sleep(3000);
		 String genderId = "GenderRadio" + c.Gender;
		 Gender = driver.findElement(By.id(genderId));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Gender);
//		 driver.findElement(By.id("GenderRadio2")).click();
		//*[@id="GenderRadio1"]
//		 WebElement Gender = driver.findElement(By.id("yesRadio")).click(); driver.findElement(By.id(genderId));
//		 Gender.click();
		 Thread.sleep(3000);
		 Mobile_Number.sendKeys(c.Mobile_Number);
//		 Thread.sleep(4000);
		 save_button.click();
		 Thread.sleep(2000);

		
	}
	

}