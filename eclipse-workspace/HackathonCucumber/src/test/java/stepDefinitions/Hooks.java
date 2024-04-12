package stepDefinitions;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{
	@Before
	public void setup() throws MalformedURLException 
	{		
		BaseClass.initializeBrowser();
		BaseClass.logger = LogManager.getLogger(this.getClass());		
		BaseClass.driver.get(BaseClass.property.getProperty("appURL"));
		BaseClass.driver.manage().window().maximize();	
	}
	
	@After
	public void close(Scenario scenario) 
	{
		TakesScreenshot ts=(TakesScreenshot) BaseClass.driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());
		BaseClass.driver.quit();
	}
}
