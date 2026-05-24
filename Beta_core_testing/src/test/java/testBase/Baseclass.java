package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {

    public WebDriver driver;
    public Properties p;
    public org.apache.logging.log4j.Logger logger;

    @BeforeClass(groups = {"sanity","Regression","Master"})
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException
    {
        logger = LogManager.getLogger(this.getClass());

        FileReader file =
                new FileReader("./src/test/resources/config.properties");

        p = new Properties();
        p.load(file);

        // REMOTE EXECUTION
        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            switch(br.toLowerCase())
            {
                case "chrome":

                    ChromeOptions chromeOptions = new ChromeOptions();

                    driver = new RemoteWebDriver(
                            new URL("http://192.168.29.28:4444"),
                            chromeOptions);

                    break;

                case "edge":

                    EdgeOptions edgeOptions = new EdgeOptions();

                    driver = new RemoteWebDriver(
                            new URL("http://192.168.29.28:4444"),
                            edgeOptions);

                    break;

                default:
                    System.out.println("No matching browser");
                    return;
            }
        }

        // LOCAL EXECUTION
        else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
            switch(br.toLowerCase())
            {
                case "chrome":

                    driver = new ChromeDriver();
                    break;

                case "edge":

                    driver = new EdgeDriver();
                    break;

                case "firefox":

                    driver = new FirefoxDriver();
                    break;

                default:

                    System.out.println("Invalid browser");
                    return;
            }
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("URL"));
    }

    @AfterClass(groups = {"sanity","Regression","Master"})
    public void teardown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

    public String randomAlphabetic()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomnum()
    {
        return RandomStringUtils.randomNumeric(9);
    }

    public String randomAlphanNum()
    {
        String RAlpha1 = RandomStringUtils.randomAlphabetic(5);
        String RNum2 = RandomStringUtils.randomNumeric(9);

        return (RAlpha1 + "@" + RNum2);
    }

    public String captureScreen(String tname) throws IOException
    {
        String timeStamp =
                new SimpleDateFormat("yyyyMMddhhmmss")
                        .format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;

        File sourceFile =
                ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath =
                System.getProperty("user.dir")
                        + "\\screenshots\\"
                        + tname + "_"
                        + timeStamp + ".png";

        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}