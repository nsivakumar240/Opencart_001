package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationpage;
import pageObjects.Homepage;

public class TC001{
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
@AfterClass
public void teardown(){
	
}
@Test
public void Tcstart() throws InterruptedException {
Homepage hp=new Homepage(driver);	
hp.Usernames("Admin");
hp.passwordd("admin123");
hp.login();
Thread.sleep(10);
AccountRegistrationpage ac=new AccountRegistrationpage(driver);
}

}
