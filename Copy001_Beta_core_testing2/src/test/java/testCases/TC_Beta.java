package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Registrationage;
import testBase.Baseclass;

public class TC_Beta extends Baseclass {
	
	@Test
	public void TCstart()
	{
	Homepage hp=new Homepage(driver);	
	hp.accountreg();
	hp.reg();
	Registrationage rg=new Registrationage(driver);
    rg.firstname(randomAlphabetic().toUpperCase());
    rg.lastnamee(randomAlphabetic().toUpperCase());
    rg.Email(randomAlphabetic()+"@gmail.com");
    rg.telephone(randomnum());
    String pass=randomAlphanNum();
    rg.password(pass);
    rg.conpassword(pass);
    rg.agree();
    rg.continuee();
    String mess=rg.getmessages();
    Assert.assertEquals(mess,"Your Account Has Been Created!");
    System.out.println(rg.getmessages());
	}
	

}
