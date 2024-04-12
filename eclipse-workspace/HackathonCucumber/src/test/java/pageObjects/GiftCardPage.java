package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardPage extends BasePage 
{	
	public GiftCardPage(WebDriver driver) 
	{
		super(driver);
	}

	//WebElements	
	@FindBy(xpath="(//li[@class='_11b4v'])//h3")
	List<WebElement> link_occasions;
	
	@FindBy(id="ip_2251506436")
	WebElement input_amount;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement btn_next;
	
	@FindBy(xpath="//input[@id='ip_4036288348']")
	WebElement input_recName;
	
	@FindBy(xpath="//input[@id='ip_137656023']")
	public WebElement input_recEmail;
	
	@FindBy(xpath="//input[@id='ip_3177473671']")
	WebElement input_recMobile;
	
	@FindBy(xpath="//input[@id='ip_1082986083']")
	WebElement input_yourName;
	
	@FindBy(xpath="//input[@id='ip_4081352456']")
	public WebElement input_yourEmail;
	
	@FindBy(xpath="//input[@id='ip_2121573464']")
	WebElement input_yourMobile;
	
	@FindBy(xpath="//input[@id='ip_2194351474']")
	WebElement input_address;
	
	@FindBy(xpath="//input[@id='ip_567727260']")
	WebElement input_pincode;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement btn_confirm;
	
	@FindBy(xpath="//div[@class='_2wEGI']/h2")
	WebElement targetPage;
	
	//Action Methods	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public void selectOccasion(String occasion) 
	{
		for(WebElement e: link_occasions) 
		{
			if(e.getText().equalsIgnoreCase(occasion)) 
			{
				e.click();
				break;
			}
		}
	}
	
	public void resetAmount() 
	{
		input_amount.clear();
	}
	
	public void selectAmount(String amount) 
	{
		input_amount.sendKeys(amount);
	}
	
	public void clickNext() 
	{
		btn_next.click();
	}
	
	public void setRecieverName(String recName) 
	{
		input_recName.sendKeys(recName);
	}
    public void setRecieverEmail(String recEmail) 
    {
		input_recEmail.sendKeys(recEmail);
	}
    public void setRecieverMobile(String recMobile) 
    {
		input_recMobile.sendKeys(recMobile);
	}
	public void setYourName(String yourName) 
	{
		input_yourName.sendKeys(yourName);	
	}
	public void setYourEmail(String yourEmail) 
	{
		input_yourEmail.sendKeys(yourEmail);
	}
	public void setYourMobile(String yourMobile) 
	{
		input_yourMobile.sendKeys(yourMobile);
	}
	public void setAddress(String address) 
	{
		input_address.sendKeys(address);
	}
	public void setPincode(String pincode) 
	{
		input_pincode.sendKeys(pincode);
	}
	
	public void clickConfirm() 
	{
		btn_confirm.click();
	}
	
	public boolean isTargetPageDisplayed() 
	{	
		return targetPage.isDisplayed();
	}
	
	public void  scrollToTargetPage() 
	{
		js.executeScript("arguments[0].scrollIntoView()", targetPage);
	}
	
	public void resetAllInputs() 
	{
		input_recName.clear();
		input_recEmail.clear();
		input_recMobile.clear();
		input_yourName.clear();
		input_yourEmail.clear();
		input_yourMobile.clear();
		input_address.clear();
		input_pincode.clear();	
	}	
}
