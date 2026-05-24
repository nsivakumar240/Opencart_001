package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends BasePage {

	public loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	WebElement Uname;
	@FindBy(xpath="//input[@name='password']")
	WebElement pw;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement clk;
	
	public void Username(String Usn)
	{
	Uname.sendKeys(Usn);	
	}
	public void password(String psw)
	{
		pw.sendKeys(psw);
	}
	
	public void clk1()
	{
	clk.click();
	}
	
}
