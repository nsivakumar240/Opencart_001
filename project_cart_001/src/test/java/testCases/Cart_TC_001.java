package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.Registerpage;
import taseBase.BaseClass;

public class Cart_TC_001 extends BaseClass {

@Test
public void ActualTc()
{
logger.info("***Started****");
try
{
HomePage hp=new HomePage(driver);	
hp.Accountclick();
logger.info("my account");
hp.Register();
logger.info("reg");
Registerpage rg=new Registerpage(driver);
rg.firstname(Randomalp().toUpperCase());
rg.lastnamee(Randomalp().toUpperCase());
rg.Email(Randomalp()+"@gmail.com");
rg.telephone(RandomNum());
String pass=rAlpNum();
rg.password(pass);
rg.conpassword(pass);
rg.agree();
rg.continuee();
logger.info("excepted message");
String mess=rg.getmessages();
Assert.assertEquals(mess,"Your Account Has Been Created!");
}
catch(Exception e)
{
	logger.error("Test failed");
	logger.debug("Debug logs");
	Assert.fail();
	logger.info("finish");
}

}

}
