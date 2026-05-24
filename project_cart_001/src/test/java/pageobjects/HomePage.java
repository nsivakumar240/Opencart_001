package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Basepage
{
	//constructor
public HomePage(WebDriver driver)
{
super(driver);	
}
//locator
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement MyAccount;
@FindBy(xpath="//a[normalize-space()='Register']")
WebElement Register;


//testmethod
public void Accountclick()
{
MyAccount.click();	
}
public void Register()
{
	Register.click();
}
}