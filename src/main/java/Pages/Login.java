package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Login extends TestBase {
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div[1]/a")
	WebElement therapist_tab;

	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[1]/div[1]/input")
	WebElement email;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[2]/input")
	WebElement password;

	@FindBy(xpath="/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div[1]/div/div/div/form/div[6]/div/button")
	WebElement login_btn;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public  void login(String emailval, String pwd) throws InterruptedException {
		therapist_tab.click();
		Thread.sleep(3000);
		email.sendKeys(emailval);
		Thread.sleep(3000);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		login_btn.click();
		Thread.sleep(5000);
		
	}
}