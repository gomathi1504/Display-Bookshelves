package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
// WebElements		
	@FindBy(id="search")
	WebElement  input_search;
	
	@FindBy(xpath="//li/a[text()=' Gift Cards ']")
	WebElement link_giftCards;
	
	
// Action methods	
	public void searchItem(String item) 
	{	
		input_search.sendKeys(item);;
		input_search.sendKeys(Keys.ENTER);
	}
	
	public void clickGiftCard() 
	{
		link_giftCards.click();
	}
	
}