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
	logger.info("**Start TC_Beta**");
	Homepage hp=new Homepage(driver);	
	hp.accountreg();
	logger.info("Account reg");
	hp.reg();
	logger.info("reg clicked");
	Registrationage rg=new Registrationage(driver);
    rg.firstname(randomAlphabetic().toUpperCase());
    logger.info("entered FN");
    rg.lastnamee(randomAlphabetic().toUpperCase());
    logger.info("entered LN");
    rg.Email(randomAlphabetic()+"@gmail.com");
    logger.info("entered Email");
    rg.telephone(randomnum());
    String pass=randomAlphanNum();
    rg.password(pass);
    rg.conpassword(pass);
    logger.info("entered PW");
    rg.agree();
    rg.continuee();
    logger.info("clicked continue");
    String mess=rg.getmessages();
    Assert.assertEquals(mess,"Your Account Has Been Created!");
    System.out.println(rg.getmessages());
    logger.info("**FinishTC_Beta**");
	}
	

}
