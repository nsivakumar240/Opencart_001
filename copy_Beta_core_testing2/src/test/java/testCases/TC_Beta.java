package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Registrationage;

public class TC_Beta {
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void TCstart()
	{
	Homepage hp=new Homepage(driver);	
	hp.accountreg();
	hp.reg();
	Registrationage rg=new Registrationage(driver);
    rg.firstname("siva");
    rg.lastnamee("kumar");
    rg.Email("dellls@gmail.com");
    rg.telephone("9090908989");
    rg.password("123321");
    rg.conpassword("123321");
    rg.agree();
    rg.continuee();
    rg.getmessages();
    
    System.out.println(rg.getmessages());
	}
	

}
