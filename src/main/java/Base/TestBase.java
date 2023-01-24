package Base;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Properties prop_clinician;
	public static Properties prop_Clinician_disable;
	public static Properties prop_Clinics;
	public static Properties prop_Clinics_disable;
	public static Properties prop_services;
	public static Properties prop_Video_categories;
	public static Properties Prop_User_Report;
//	public static Properties Prop_Appointments;
	
	

	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(ip);
			
			prop_clinician = new Properties();
			FileInputStream ip1 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/clinician_config.properties");
			prop_clinician.load(ip1);
			
			prop_Clinician_disable = new Properties();
			FileInputStream ip2 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/clinician_config.properties");
			prop_Clinician_disable.load(ip2);
			
			prop_Clinician_disable = new Properties();
			FileInputStream ip3 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/clinician_login_config.properties");
			prop_Clinician_disable.load(ip3);
			
			prop_Clinics = new Properties();
			FileInputStream ip4 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/clinics_config.properties");
			prop_Clinics.load(ip4);
			
			prop_Clinics_disable = new Properties();
			FileInputStream ip5 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/clinics_config.properties");
			prop_Clinics_disable.load(ip5);
			
			prop_services = new Properties();
			FileInputStream ip6 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/Services_config.properties");
			prop_services.load(ip6);
			
			prop_services = new Properties();
			FileInputStream ip7 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/user_login_config.properties");
			prop_services.load(ip7);
			
			prop_Video_categories = new Properties();
			FileInputStream ip8 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/Videos_config.properties");
			prop_Video_categories.load(ip8);
			
			prop_Video_categories = new Properties();
			FileInputStream ip9 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/Videos_libraries_config.properties");
			prop_Video_categories.load(ip9);
			
			prop_Video_categories = new Properties();
			FileInputStream ip10 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/user_login_config.properties");
			prop_Video_categories.load(ip10);
			
			Prop_User_Report = new Properties();
			FileInputStream ip11 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/UserReport_Export_config.properties");
			Prop_User_Report.load(ip11);
			
//			Prop_Appointments = new Properties();
//			FileInputStream ip12 = new FileInputStream(
//					System.getProperty("user.dir") + "/src/main/java/config/Appointments_config.properties");
//			Prop_Appointments.load(ip12);
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		  
		WebDriverManager.chromedriver().driverVersion("108.0.5359.99").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	
	 @AfterTest 
	 public void driver_method_close()
	 { 
		 driver.quit();
	 }
	 

	

}