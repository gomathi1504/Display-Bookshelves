package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import factory.BaseClass;

import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductPage;

public class TC002_ValidatingSubMenuOfLivingStorage extends BaseClass {

	@When("the user clicks on the LivingStorage Option")
	public void the_user_clicks_on_the_living_storage_option() 
	{
		logger.info("******TC002_ValidatingSubMenuOfLivingStorage started*********");
		
		productPageObj = new ProductPage(driver);
		productPageObj.closePopup();
		productPageObj.clickLivingOptions();
		logger.info("Clicked living link in product page");
	}

	@Then("the user should able to see the submenu present under that option")
	public void the_user_should_able_to_see_the_submenu_present_under_that_option() throws InterruptedException 
	{   
		List<WebElement> livingOptionsList = productPageObj.getListUnderLivingOptions();
	    System.out.println("\nSubmenu under Living Option :");
		for(WebElement e: livingOptionsList) 
		{
			System.out.println(e.getAttribute("innerText"));
		}
		logger.info("Captured the submenu under living option");
		
		Thread.sleep(2000);
		
		if(livingOptionsList.size()==9) {
			logger.info(" ==>Test TC002_ValidatingSubMenuOfLivingStorage passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("  ==>Test TC002_ValidatingSubMenuOfLivingStorage failed");
			Assert.fail();
		}
		
		
	}
}
