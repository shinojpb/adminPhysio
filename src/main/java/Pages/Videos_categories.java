package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Clinics_data;
//import Base.Videos_data;
import Base.TestBase;
import Base.Videos_data;
import Base.Videos_libraries_data;

public class Videos_categories extends TestBase {

	private static final int i = 0;

	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[8]/a")
	WebElement VideoCategories_tab;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-category/div[1]/div/div[2]/button")
	WebElement VideoCategories_add_tab;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-category/form/div[2]/div/div[1]/div/div[1]/div[1]/div/div/input")
	WebElement Category_tab;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-category/form/div[2]/div/div[1]/div/div[2]/div[1]/textarea")
	WebElement Description_tab;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-category/form/div[2]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/input")
	WebElement Sub_CategoryName1_tab;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-category/form/div[2]/div/div[1]/div/div[3]/button")
	WebElement Add_subCategory_tab;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-category/form/div[2]/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/input")
	WebElement Sub_CategoryName2_tab;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-category/form/div[2]/div/div[2]/div/div/div[1]/div/div[1]")
	WebElement Addimage_btn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-category/form/div[2]/div/div[3]/button")
	WebElement Videocategory_save_btn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-category/div[2]/div/div/div[2]/div[16]/div/div/div/div[2]")
	WebElement Videocategory_edit_btn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-category/div[2]/div/div/div[2]/div[16]/div/div/div/div[2]/i[3]")
	WebElement Videocategory_enableDisable_btn;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[7]/a")
	WebElement VideoLibraries_btn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-video-libraries/div[1]/div/div[2]/button")
	WebElement VideoLibraries_Add_btn;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/ng-multiselect-dropdown/div")
	WebElement CategoryDropDown_box;
	public static WebElement CategoryDropDown;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[1]/div/div[3]/div[1]/ng-multiselect-dropdown/div")
	WebElement sub_CategoryDropDown_box;
	public static WebElement sub_CategoryDropDown;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")
	WebElement ExerciseLibrary_tab;
	
	@FindBy(xpath = "//*[@id=\"headingOne\"]/h2/button")
	WebElement videoCategory_btn;
	
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[1]/div/div[1]/div[1]/input")
	WebElement Title_field;
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[1]/div/div[4]/div[1]/input")
	WebElement Short_Description_field;
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[1]/div/div[5]/div[1]/textarea")
	WebElement Description_field;
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[2]/fieldset/div/div[1]/div[1]/input")
	WebElement Heading_field;
	public static@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[2]/fieldset/div/div[2]/div[1]/textarea")
	WebElement Content_field;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[2]/div[1]/div[1]/div/div[2]/p")
	WebElement Thumbnail;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/input")
	WebElement Video;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[3]/button")
	WebElement Submit;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-video-libraries/div[2]/div/div/div[2]/div[102]/div/div/div[2]/div/div[2]/button[1]")
	WebElement VideoLibraryEdit_btn;
	@FindBy(xpath = "//*[@id=\"container\"]/div/app-video-libraries/div[4]/button")
	WebElement loadMore_btn;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")
	WebElement ExerciseLibrary_check_tab1;
	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div/div/div/div[16]/div[1]/img")
	WebElement Videocategory_img_tab;	
	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div/div/div[2]/div/div[1]/figure/div[1]/img")
	WebElement Libraryname;	
	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div/div/div[2]/div/div[1]/div/div[2]/div")
	WebElement serviceErrorMessages;
	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[1]/div[1]/input")
	WebElement emailu;	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[2]/input")
	WebElement passwordu;	
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div[2]/button")
	WebElement login_btn;
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[8]/a")
	WebElement User_exerciseLibrary_tab;
	@FindBy(xpath="/html/body/app-dashboard/app-header/ul/li/a/img")
	WebElement image_tab;
	
	public Videos_categories() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddVideoCategories(Videos_data img) throws InterruptedException, Exception {
		
		VideoCategories_tab.click();
		Thread.sleep(3000);
		VideoCategories_add_tab.click();
		Thread.sleep(3000);
		Category_tab.sendKeys(img.Category);
		Thread.sleep(3000);
		Description_tab.sendKeys(img.Description);
		Thread.sleep(3000);
		Sub_CategoryName1_tab.sendKeys(img.Sub_Category_Name1);
		Thread.sleep(3000);
		Add_subCategory_tab.click();
		Thread.sleep(3000);
		Sub_CategoryName2_tab.sendKeys(img.Sub_Category_Name2);
		Thread.sleep(3000);
		
		Addimage_btn.click();
		Thread.sleep(3000);	
		
		Robot rb = new Robot();
		 
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("C:\\SHINOJ\\Images\\DoctorVijay.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    
		Thread.sleep(10000);
	    Videocategory_save_btn.click();
        Thread.sleep(3000);	
	}
	
	public void EditVideoCategories(Videos_data editimage) throws InterruptedException{
		VideoCategories_tab.click();
		Thread.sleep(3000);
		List<WebElement>VideoCategoriesList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-category/div[2]/div/div/div[2]/div"));
		for(int i=0;i<VideoCategoriesList.size();i++){
			
			String Categorieslist = VideoCategoriesList.get(i).getText();
//			System.out.println("lists name : " + Categorieslist);
			if(Categorieslist.contains(editimage.Category)){
				System.out.println("Category : Present");
				Videocategory_edit_btn.click();
				Thread.sleep(3000);
				System.out.println("Category Edit button clicked...");
				break;
			}
		}
//		if (Videos_categories.Category_tab.getAttribute("value").contains(prop_Video_categories.getProperty("Category")))
//		{
//	System.out.println("Category : Present");
	if (Videos_categories.Description_tab.getAttribute("value").contains(prop_Video_categories.getProperty("Description")))
	{
System.out.println("Description : Present");
if (Videos_categories.Sub_CategoryName1_tab.getAttribute("value").contains(prop_Video_categories.getProperty("Sub_Category_Name1")))
{
System.out.println("Sub_CategoryName1 : Present");
if (Videos_categories.Sub_CategoryName2_tab.getAttribute("value").contains(prop_Video_categories.getProperty("Sub_Category_Name2")))
{
System.out.println("Sub_CategoryName2 : Present");
}else {
	System.out.println("Sub_CategoryName2 : Absent");
	
}
	}else {
		System.out.println("Sub_CategoryName1 : Absent");
		
	}	
}else {
	System.out.println("Description : Absent");
	
}
//		}
//		else {
//			System.out.println("Category : Absent");
//			
//		}
		
		
	}
	
	public void EnableDisableVideoCategories(Videos_data enableDisableimg) throws InterruptedException{
		VideoCategories_tab.click();
		Thread.sleep(3000);
		List<WebElement>VideoCategoriesList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-category/div[2]/div/div/div[2]/div"));
		for(int i=0;i<VideoCategoriesList.size();i++){
			
			String Categorieslist = VideoCategoriesList.get(i).getText();
//			System.out.println("lists name : " + Categorieslist);
			if(Categorieslist.contains(enableDisableimg.Category)){
				System.out.println("Category : Present");
				Videocategory_enableDisable_btn.click();
				Thread.sleep(3000);
				System.out.println("Category EnbleDisable button clicked...");
				break;
			}
		}
		
		
	}
	
	public void EnableDisableVideoCategoriesCheck(Videos_data list) throws InterruptedException{
		
		VideoLibraries_btn.click();
		Thread.sleep(3000);
		VideoLibraries_Add_btn.click();
		Thread.sleep(3000);
		CategoryDropDown_box.click();
		Thread.sleep(3000);
		List<WebElement>CategoriesList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-add-edit-video-libraries/form/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]"));
		for(int i=0;i<CategoriesList.size();i++){
			
			String Categorieslist = CategoriesList.get(i).getText();
//			System.out.println("lists name : " + Categorieslist);
			if(Categorieslist.contains(list.Category)){
				System.out.println("Video Category : Present");
				System.out.println("Enable Disable Problem");
				Thread.sleep(3000);
				break;
			}
		}
		
		
		}
	
	public void addVideoLibraries(Videos_libraries_data addLibrary) throws InterruptedException, Exception{
		
		VideoLibraries_btn.click();
		Thread.sleep(3000);
		VideoLibraries_Add_btn.click();
		Thread.sleep(3000);
		Title_field.sendKeys(addLibrary.Title);
		Thread.sleep(3000);
		CategoryDropDown_box.click();
		Thread.sleep(3000);
//		String xx = "Doctor";
		String categoryPath = "//input[@aria-label='" + addLibrary.Category  + "']";		
		CategoryDropDown = driver.findElement(By.xpath(categoryPath));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CategoryDropDown);
		 Thread.sleep(3000);
		 CategoryDropDown_box.click();
			Thread.sleep(3000);
			
			sub_CategoryDropDown_box.click();
			Thread.sleep(3000);
//			String xx1 = "Covid - Doctor";
			String categoryPath2 = "//input[@aria-label='" + addLibrary.Sub  + "']";		
			sub_CategoryDropDown = driver.findElement(By.xpath(categoryPath2));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sub_CategoryDropDown);
			 Thread.sleep(3000);
			 sub_CategoryDropDown_box.click();
				Thread.sleep(3000);
				
				Thumbnail.click();
				Thread.sleep(9000);
				Robot rb = new Robot();
				 
			    // copying File path to Clipboard
			    StringSelection str = new StringSelection("C:\\SHINOJ\\Images\\boy.jpg");
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			 
			     // press Contol+V for pasting
			     rb.keyPress(KeyEvent.VK_CONTROL);
			     rb.keyPress(KeyEvent.VK_V);
			 
			    // release Contol+V for pasting
			    rb.keyRelease(KeyEvent.VK_CONTROL);
			    rb.keyRelease(KeyEvent.VK_V);
			 
			    // for pressing and releasing Enter
			    rb.keyPress(KeyEvent.VK_ENTER);
			    rb.keyRelease(KeyEvent.VK_ENTER);			    
				Thread.sleep(10000);
				
				Video.sendKeys("C:\\SHINOJ\\Videos\\Sachin.mp4");
				Thread.sleep(10000);
				
				Short_Description_field.sendKeys(addLibrary.Short_Description);
				Thread.sleep(3000);
				Description_field.sendKeys(addLibrary.Description);
				Thread.sleep(3000);
				Heading_field.sendKeys(addLibrary.Heading);
				Thread.sleep(3000);
				Content_field.sendKeys(addLibrary.Content);
				Thread.sleep(3000);
//				Submit.click();
//				Thread.sleep(3000);		
		
	}
	
	public void editVideoLibraries() throws InterruptedException{
		
		VideoLibraries_btn.click();
		Thread.sleep(14000);
		boolean isTextPresent = true;
		while(isTextPresent){
			if (loadMore_btn.isDisplayed()) {
				 loadMore_btn.click();
  				Thread.sleep(6000);
  				List<WebElement>VideoLibrariesList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-video-libraries/div[2]/div/div/div[2]/div"));
  				
  				for(int i=0;i<VideoLibrariesList.size();i++){
  					
  					String LibrariesList = VideoLibrariesList.get(i).getText();
//  					System.out.println("lists name : " + LibrariesList);
  					if(LibrariesList.contains("Sachin")){
   						System.out.println("Library : Present");
   						JavascriptExecutor js = (JavascriptExecutor)driver;
   						js.executeScript("arguments[0].click();", VideoLibraryEdit_btn);
   						Thread.sleep(5000);
   						System.out.println("Library Edit button clicked...");
   						isTextPresent = false;
   						break;
   						
   					}
  				}   						
		}	
	}
}
	
	public void View_VideoLibraries() throws InterruptedException {
		
		if (Videos_categories.Title_field.getAttribute("value").contains(prop_Video_categories.getProperty("Title")))
		{
	System.out.println("Title : Present");
//	if (Videos_categories.sub_CategoryDropDown.getAttribute("value").contains(prop_Video_categories.getProperty("Sub")))
//	{
//System.out.println("Sub : Present");
	if (Videos_categories.Short_Description_field.getAttribute("value").contains(prop_Video_categories.getProperty("Short_Description")))
	{
System.out.println("Short_Description : Present");
if (Videos_categories.Description_field.getAttribute("value").contains(prop_Video_categories.getProperty("Description")))
{
System.out.println("Description : Present");
if (Videos_categories.Heading_field.getAttribute("value").contains(prop_Video_categories.getProperty("Heading")))
{
System.out.println("Heading : Present");
if (Videos_categories.Content_field.getAttribute("value").contains(prop_Video_categories.getProperty("Content")))
{
System.out.println("Content : Present");
}else {
	System.out.println("Content : Absent");
	
}
		}else {
			System.out.println("Heading : Absent");
			
		}
			
		
		
	}else {
		System.out.println("Description : Absent");
		
	}
		
		
}else {
	System.out.println("Short_Description : Absent");
	
}
//		}else {
//			System.out.println("Sub : Absent");
//			
//		}
	}else {
		System.out.println("Title : Absent");
		
	}
	}
	
	public void VideoLibraries_check_exerciseLibrary() throws InterruptedException {
		ExerciseLibrary_check_tab1.click();
		Thread.sleep(3000);
		
		List<WebElement>ExerciseLibraryList = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div/div"));
		for(int i=0;i<ExerciseLibraryList.size();i++){
			
			String ExerciseCategorieslist = ExerciseLibraryList.get(i).getText();			
//			System.out.println("lists name : " + ExerciseCategorieslist);
			if(ExerciseCategorieslist.contains("Doctor is god")){
				System.out.println("Video Category : Present");
			Videocategory_img_tab.click();
			Thread.sleep(5000);
			Libraryname.click();
			Thread.sleep(5000);
			System.out.println("Library : Present");
			String name = driver.findElement(By.xpath("//*[@id=\"container\"]/div/app-exercise-library-details/div[2]/div/div[3]/div[1]")).getText();
			System.out.println("Library Name Present: " + name);
			System.out.println("Hence video library is present....");
			Thread.sleep(5000);
				break;
			}
		}
		image_tab.click();
		Thread.sleep(3000);
		
		WebElement button = driver.findElement(By.xpath("/html/body/app-dashboard/app-header/ul/li/div/a[2]/i"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);
		
		Thread.sleep(3000);
			
		}
	
	public void login(String emailval, String pwd) throws InterruptedException  {
		emailu.sendKeys(emailval);
		Thread.sleep(3000);
		passwordu.sendKeys(pwd);
		Thread.sleep(3000);
		login_btn.click();
		Thread.sleep(5000);
		User_exerciseLibrary_tab.click();
		Thread.sleep(5000);
		
		List<WebElement>ExerciseLibraryList = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div/div"));
		for(int i=0;i<ExerciseLibraryList.size();i++){
			
			String ExerciseCategorieslist = ExerciseLibraryList.get(i).getText();			
//			System.out.println("lists name : " + ExerciseCategorieslist);
			if(ExerciseCategorieslist.contains("Doctor is god")){
				System.out.println("Video Category : Present in User");
			Videocategory_img_tab.click();
			Thread.sleep(5000);
			Libraryname.click();
			Thread.sleep(5000);
			System.out.println("Library : Present in User");
			String name2 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/app-exercise-library-details/div[2]/div/div[3]/div[1]")).getText();
			System.out.println("Library Name Present in User: " + name2);
			System.out.println("Hence video library is present in User....");
			Thread.sleep(5000);
				break;
			}
		}
		image_tab.click();
		Thread.sleep(3000);
		
		WebElement button = driver.findElement(By.xpath("/html/body/app-dashboard/app-header/ul/li/div/a[2]/i"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);
		
		Thread.sleep(3000);
	}
	
}
