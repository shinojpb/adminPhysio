package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.Color;
//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Services_data;
//import Base.Clinics_data;
import Base.TestBase;

public class Services extends TestBase{
	
//	private static final int i = 0;

	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a/app-sidebar-nav-link-content")
	WebElement Services_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-services/div[1]/div/div[2]/button")
	WebElement Services_Add_button;
	
	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[2]/form/div[1]/div[1]/div[1]/input")
	WebElement Duration_tab;
	
	public static @FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[2]/form/div[1]/div[1]/div[3]/div/input")
	WebElement Price_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[2]/form/div[2]/div")
	WebElement div_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[2]/form/div[1]/div[2]/div[1]/select")
	WebElement Service_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[2]/form/div[1]/div[2]/div[1]/select/option[8]")
	WebElement Managae_service_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[3]/div/div/div[2]/form/div/div/div[2]/input")
	WebElement Add_New_Service_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[2]/form/div[2]/div/div/button")
	WebElement Service_save_tab;
	
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[3]/div/div/div[2]/div/div/div/button[2]")
	WebElement ManageService_save_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[3]/div/div/div[2]/form/div/div/div[4]/input")
	WebElement Select_Color_tab;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[3]/div/div/div[2]/div/div")
	WebElement div1_tab;
	
//	WebElement Service_Edit_button_click;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-add-edit-services/div[1]/div/div[2]/button")
	WebElement Service_Back_button;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-services/div[3]/div/div/div[3]/button[1]")
	WebElement Service_EnableDisable_yes_btn;

	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[1]/div[1]/input")
	WebElement emailu;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[2]/input")
	WebElement passwordu;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div[2]/button")
	WebElement login_btn;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement User_book_appointment_btn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[3]/div[2]/div[2]/label/div")
	WebElement Duration_appointment_btn;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[3]/div[2]")
	WebElement serviceErrorMessage;
	public Services() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void AddServices(Services_data datas) throws InterruptedException {
		
		Services_tab.click();
//		Thread.sleep(3000);
		Services_Add_button.click();
//		Thread.sleep(3000);
		Duration_tab.sendKeys(datas.Duration);
//		Thread.sleep(3000);
		Price_tab.sendKeys(datas.Price);
//		Thread.sleep(3000);
		div_tab.click();
//		Thread.sleep(3000);
		Service_tab.click();
		Thread.sleep(3000);
		Managae_service_tab.click();
		Thread.sleep(5000);
		Add_New_Service_tab.sendKeys(datas.Add_New_Service);
		Thread.sleep(3000);	
		Select_Color_tab.click();
		Thread.sleep(3000);	
		Select_Color_tab.sendKeys("#E7184C");
		Thread.sleep(3000);
		div1_tab.click();
		Thread.sleep(3000);
		ManageService_save_tab.click();
		Thread.sleep(3000);
		
		
		
		
//		Select_Color_tab.isSelected();
		
		
	}
	
	public void AddServices2(String v) throws InterruptedException {
		
		Services_tab.click();
		Thread.sleep(3000);
		
		List<WebElement> ServiceList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-services/ng-custom-table/div/div[2]/div/table/tbody/tr"));
		for(int i=0;i<ServiceList.size();i++){
			 String ActServiceName = ServiceList.get(i).getText();	
			    Thread.sleep(3000);
			
			    if(ActServiceName.contains(v))
			    {
			    	
			    	
			    	WebElement Service_Edit_button_click;
					 Service_Edit_button_click = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-services/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[4]/a[1]"));
					 Service_Edit_button_click.click();
					 //ViewClinics(views);
					 Thread.sleep(5000);	    	
//			    	Service_Back_button.click();  	
			    	    break; 
			   	    }
			
		}
	
	
}
	public void EditViewServices(String views1) throws InterruptedException {
		
		//views1 = new Services_data();	
		List<WebElement> serviceDropdownList = driver.findElements(By.xpath("//*[@id=\"category\"]/option"));
		for(int i=0;i<serviceDropdownList.size();i++){
		
			String ActServiceListName = serviceDropdownList.get(i).getText();
			
		
			if(ActServiceListName.contains(views1)){
				System.out.println("Service : Present");
				break;
			}
		}
//		if (Services.Add_New_Service_tab.getAttribute("value").contains(prop_services.getProperty("Add_New_Service")))
//		{
//	System.out.println("Service : Present");
	if (Services.Duration_tab.getAttribute("value").contains(prop_services.getProperty("Duration")))
	{
System.out.println("Duration : Present");
if (Services.Price_tab.getAttribute("value").contains(prop_services.getProperty("Price")))
{
System.out.println("Price : Present");
		
	}
else
{
	System.out.println("Error in Price");
}
	
}else
{
	System.out.println("Error in Duration");
}
//		}
//		else
//		{
//			System.out.println("Error in Service");
//		}
	}
	
	public void EnableDisableServices(Services_data ed_btn) throws InterruptedException {
		
		Services_tab.click();
		Thread.sleep(3000);
		
		List<WebElement> ServiceList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-services/ng-custom-table/div/div[2]/div/table/tbody/tr"));
		for(int i=0;i<ServiceList.size();i++){
			 String ActServiceName = ServiceList.get(i).getText();	
			    Thread.sleep(3000);
			
			    if(ActServiceName.contains("Spinal Therapy"))
			    {
			    	
			    	
			    	WebElement Service_EnableDisable_btn;
			    	Service_EnableDisable_btn = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-services/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[4]/a[3]"));
			    	Service_EnableDisable_btn.click();					
					 Thread.sleep(3000);	    	
//			      	
			    	    break; 
			   	    }
			
		}
	
		Service_EnableDisable_yes_btn.click();
		Thread.sleep(3000);
		System.out.println("Enable_Disable button clicked");
		
		
	}
	
	public void login(String emailval, String pwd, String val, String val2) throws InterruptedException  {
		emailu.sendKeys(emailval);
		Thread.sleep(3000);
		passwordu.sendKeys(pwd);
		Thread.sleep(3000);
		login_btn.click();
		Thread.sleep(5000);
		User_book_appointment_btn.click();
		Thread.sleep(5000);
		
		List<WebElement> ClinicsLocationList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[2]/div"));
		for(int i=0;i<ClinicsLocationList.size();i++){
		
		    Thread.sleep(5000);
		   
		  
		    try {
		    if(ClinicsLocationList.get(i).getText().contains(val))
		    {
		    	System.out.println("location checking...");
		    	ClinicsLocationList.get(i).click();
		    	Thread.sleep(3000);
		    	System.out.println("location clicked...");
		    	
		    	break;
		    	
		    }
		    }catch(StaleElementReferenceException s)
		    {
		    	List<WebElement> ClinicsLocationList1 = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[2]/div"));
		    	
		    	if(ClinicsLocationList1.get(i).getText().contains(val))
			    {
			    	System.out.println("location checking...");
			    	ClinicsLocationList1.get(i).click();
			    	Thread.sleep(3000);
			    	System.out.println("location clicked...");
			    	
			    	break;
			    	
			    }
		    }
			
			
		}
		
		List<WebElement> ClinicsServicesList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[3]/div/div"));
//		System.out.println("service list : " + ClinicsServicesList);
		for(int i=0;i<ClinicsServicesList.size();i++){
			
			if(ClinicsServicesList.get(i).getText().contains(val2)) {
				ClinicsServicesList.get(i).click();
				Thread.sleep(3000);
				System.out.println("Service is Present");	
			
				if(serviceErrorMessage.getText().contains("No Duration Available for this Service"))
				{
					System.out.println("Service Disabled");
				}else {
					
					System.out.println("Service Enabled");
				}
			}
			
		}
		
		
	}
	
}
