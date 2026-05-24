package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountRegistrationpage extends BasePage {

	public AccountRegistrationpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-stopwatch']")
	               //i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']
	WebElement dropp;
	
	public void admind(String sive){
		search.sendKeys(sive);
	}
		

		public void dds(){
			search.click();
		
		String title=driver.getTitle();
		System.out.println(title);

}}
