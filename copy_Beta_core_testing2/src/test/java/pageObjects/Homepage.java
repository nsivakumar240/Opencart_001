package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	
	public Homepage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Accountlink;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerlink;

	public void accountreg()
	{
	Accountlink.click();
	}
	
	public void reg()
	{
	registerlink.click();
	}
	
}
