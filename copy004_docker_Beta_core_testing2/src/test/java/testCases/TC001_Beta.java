package testCases;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.loginpage;
import testBase.Baseclass;

public class TC001_Beta extends Baseclass  {

	@Test(groups= {"sanity","Master"})
	public void setup()
	{
		logger.info("**Started TC001_beta**");
		Homepage hp=new Homepage(driver);
		hp.accountreg();
		hp.login1();
		loginpage lp=new loginpage(driver);
		lp.Username(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.clk1();
	}
}
