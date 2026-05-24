package taseBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeTest
	@Parameters({"os","browser"})
	public void setupURL(String os,String br) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
	
		logger=LogManager.getLogger(this.getClass());
		
	switch(br.toLowerCase())
	{
	case "chrome" : driver=new ChromeDriver(); break;
	case "edge" : driver=new EdgeDriver(); break;
	case "firefox" : driver=new FirefoxDriver(); break;
	default: System.out.println("invalid browser");
	return;
	
	}
	//driver=new ChromeDriver();	
	driver.manage().window().maximize();
	driver.get(p.getProperty("appURL")); //
//driver.get("https://tutorialsninja.com/demo/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterTest
	public void Teardown()
	{
	driver.quit();	
	}
	@SuppressWarnings("deprecation")
	public String Randomalp()
	{
		String Ralpha=RandomStringUtils.randomAlphabetic(5);
		return Ralpha;
	}

	public String RandomNum()
	{
		String Rnum=RandomStringUtils.randomNumeric(10);
		return Rnum;
	}
	public String rAlpNum()
	{
	    String alp=RandomStringUtils.randomAlphabetic(4);
	    String Num=RandomStringUtils.randomNumeric(4);
	    return(alp+"@"+Num);
	}
}
