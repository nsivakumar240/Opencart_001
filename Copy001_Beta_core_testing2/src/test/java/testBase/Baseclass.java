package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void teardown()
	{
		//driver.quit();
	}
public String randomAlphabetic()
{
String RAlpha=RandomStringUtils.randomAlphabetic(5);	
return RAlpha;
}
public String randomnum()
{
String RNum=RandomStringUtils.randomNumeric(9);
return RNum;
}

public String randomAlphanNum()
{
	String RAlpha1=RandomStringUtils.randomAlphabetic(5);	
	String RNum2=RandomStringUtils.randomNumeric(9);
	return (RAlpha1+"@"+RNum2);
}
}
