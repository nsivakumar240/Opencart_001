	//ChromeOptions options=new ChromeOptions();
	//options.addArguments("--incognito");
	//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	//driver=new ChromeDriver(options);
package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homepage extends BasePage
{
	//constructor
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	//locators
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement UserName;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbutton;
	
	
	//Actionsmethod
	
	public void Usernames(String Uname){
		UserName.sendKeys(Uname);
	}
	public void passwordd(String Pname){
		password.sendKeys(Pname);
	}
	public void login()
	{
		loginbutton.click();
	}

	}
	
	
	
	
	

	

