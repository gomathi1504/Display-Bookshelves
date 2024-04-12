package factory;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObjects.GiftCardPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties property;
	public static FileInputStream file;
	public static Logger logger;
	public static HomePage homeObj;
	public static GiftCardPage giftCardPageObj;
	public static ProductPage productPageObj;
	
	public static void initializeBrowser() throws MalformedURLException 
	{		
		property = new Properties();
		try 
		{
			file = new FileInputStream("C:\\Users\\2318582\\eclipse-workspace\\HackathonCucumber\\src\\test\\resources\\config.properties");
			property.load(file);
		}
		catch(Exception e) 
		{
			System.out.println("file not found");
		}
				
		if(property.getProperty("execution_env").equalsIgnoreCase("remote"))
		{			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if (property.getProperty("os").equalsIgnoreCase("windows")) 
			{
			    capabilities.setPlatform(Platform.WIN11);
			} 
			else if (property.getProperty("os").equalsIgnoreCase("mac")) 
			{
			    capabilities.setPlatform(Platform.MAC);
			} 
			else 
			{
				System.out.println("No matching OS..");
			}
			//browser
			switch (property.getProperty("browser").toLowerCase()) 
			{
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			 }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}		
		else if(property.getProperty("execution_env").equalsIgnoreCase("local"))
		{				
			switch(property.getProperty("browser").toLowerCase()) 
			{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
			}
		}
		//Adding implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
