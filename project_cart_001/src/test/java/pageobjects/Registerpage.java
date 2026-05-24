package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registerpage extends Basepage
{
//constructor
	public Registerpage(WebDriver driver)
	{
	super(driver);	
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement Firstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement lastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement Email;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement telphone;

@FindBy(xpath="//input[@id='input-password']")
WebElement password;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement conpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement agree;

@FindBy(xpath="//input[@value='Continue']")
WebElement continuee;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement message;

public void firstname(String fname)
{
	Firstname.sendKeys(fname);
}

public void lastnamee(String lname)
{
	lastname.sendKeys(lname);
}
public void Email(String email)
{
	Email.sendKeys(email);
}
public void telephone(String telnum)
{
	telphone.sendKeys(telnum);
}
public void password(String pname)
{
	password.sendKeys(pname);
}
public void conpassword(String cpname)
{
	conpassword.sendKeys(cpname);
}
public void agree()
{
	agree.click();
}
public void continuee()
{
	continuee.click();
}

public String getmessages()
{
	try
	{
	return(message.getText());
	}
	catch (Exception e)
	{
		return (e.getMessage());
	}
}
}
