package Pages;
//import java.util.ArrayList;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;


import Base.Clinician_data;

import Base.TestBase;

public class Clinician_disable extends TestBase {
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement Clinicians_tab1;	
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr[3]")
	WebElement Table_data1;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-clinicians/div[3]/div/div/div[3]/button[1]")
	WebElement DisableYes_button1;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div[1]/a")
	WebElement therapist_tab;

	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[1]/div[1]/input")
	WebElement emailc;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[2]/input")
	WebElement passwordc;

	@FindBy(xpath="/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div/button")
	WebElement login_btn;
	
	@FindBy(xpath="/html/body/app-dashboard/app-header/ul/li/a")
	WebElement image_tab;
	
//	@FindBy(xpath="/html/body/app-dashboard/app-header/ul/li/div/a[2]")
//	WebElement logout;
	
	
	WebElement disable;
	
public Clinician_disable () {
	PageFactory.initElements(driver, this);
	
}

public void DisableClinician(Clinician_data g) throws InterruptedException {
	Clinicians_tab1.click();
	Thread.sleep(3000);  
	
	List<WebElement> CustList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr"));
	
	for(int i=0;i<CustList.size();i++){
		try {
	    String ActCustName = CustList.get(i).getText();
//	    System.out.println(ActCustName);

	    Thread.sleep(1000);
	    if(ActCustName.contains(g.Full_Name)){
	    	System.out.println(ActCustName);
//	    	System.out.println(i);
	    	
	    	 disable=driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[3]"));
	    	 Thread.sleep(3000);
	    	 
	   	    }
		}
		catch(StaleElementReferenceException s) {
			List<WebElement> CustList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr"));
//			System.out.println("@"+CustList1.get(i).getText());
			 String ActCustName = CustList1.get(i).getText();
//			 System.out.println(f.Full_Name);
			if(ActCustName.contains(g.Full_Name)){
				System.out.println(ActCustName);
//				System.out.println(i);				
	    	 
		    	 disable=driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinicians/ng-custom-table/div/div[2]/div/table/tbody/tr["+(i+1)+"]/td[6]/a[3]"));
		    	Thread.sleep(3000);
		    	
		    }
		}
	} 

	disable.click();
	Thread.sleep(3000);
	DisableYes_button1.click();
	Thread.sleep(5000);
	image_tab.click();
	Thread.sleep(3000);
//	logout.click();	
	
	WebElement button = driver.findElement(By.xpath("/html/body/app-dashboard/app-header/ul/li/div/a[2]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", button);
	
	Thread.sleep(3000);
	
}


public void login(String emailval, String pwd) throws InterruptedException  {
	therapist_tab.click();
	Thread.sleep(3000);
	emailc.sendKeys(emailval);
	Thread.sleep(3000);
	passwordc.sendKeys(pwd);
	Thread.sleep(3000);
	login_btn.click();
	Thread.sleep(5000);
	
}

}