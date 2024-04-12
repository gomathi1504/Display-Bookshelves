package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage 
{

	public ProductPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//WebElements	
	@FindBy(xpath="(//div[@class='popup-text text-center vert large-6 columns']/a)[1]")
	WebElement elmnt_popup;
	
	@FindBy(xpath="//li[@class='item' and @data-group='price']/div[@class='gname']")
	WebElement elmnt_price;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement elmnt_maxSlider;
	
	@FindBy(xpath="(//li[@data-group='category']//div)[1]")
	WebElement elmnt_category;
	
	@FindBy(xpath="//label[@for='filters_primary_category_Bookshelves']")
	WebElement optn_bookshelves;
	
	@FindBy(id="filters_availability_In_Stock_Only")
	WebElement optn_outOfStock;
	
	@FindBy(xpath="//span[text()='Recommended']")
	WebElement elmnt_sortBy;
	
	@FindBy(xpath="//li[text()='Price: High to Low']")
	WebElement optn_highToLow;
	
	@FindBy(xpath="//div[@class='product-title product-title-sofa-mattresses']/span")
	List<WebElement> txt_productName;
	
	@FindBy(xpath="//div[@class='price-number']/span")
	List<WebElement>txt_price;
	
	@FindBy(xpath="//figure[@class='header__topBar_logo']")
	WebElement link_homePage;
	
	@FindBy(xpath="//li/a[text()=' Gift Cards ']")
	WebElement link_giftCards;
	
	@FindBy(xpath="(//ul[@class='taxonslist'])[8]//a/span")
	List<WebElement> links_livingOptions;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']")
	WebElement elmnt_living;
	
	
	// Action methods	
	JavascriptExecutor js = (JavascriptExecutor)driver;	
	Actions act = new Actions(driver);
		
	public void clickLivingOptions() 
	{
		elmnt_living.click();
	}
	public List<WebElement> getListUnderLivingOptions() 
	{
		return links_livingOptions;
	}
	
	public void clickGiftCard() 
	{
		link_giftCards.click();
	}
	
	public void clickHomePageLink() 
	{
		act.sendKeys(Keys.PAGE_UP).perform();
		link_homePage.click();
	}
	
	public void closePopup() 
	{
		elmnt_popup.click();
	}
	
	public void clickPrice() 
	{
		elmnt_price.click();
	}
	
	public void setPrice() 
	{
		act.moveToElement(elmnt_maxSlider).click().dragAndDropBy(elmnt_maxSlider,  -211, 0).perform();
	}
	
	public void clickCategory() 
	{
		js.executeScript("arguments[0].click();", elmnt_category);
	}
	
	public void selectBookshelves() 
	{
		js.executeScript("arguments[0].click();", optn_bookshelves);
	}
	
	public void selectOutOfStock() 
	{
		js.executeScript("arguments[0].click();",optn_outOfStock);
	}
	
	public void clickSortBy() throws InterruptedException 
	{
		Thread.sleep(2000);
		act.sendKeys(Keys.PAGE_UP).perform();
		js.executeScript("arguments[0].click();", elmnt_sortBy);
	}
	
	public void selectHighToLow() 
	{
		js.executeScript("arguments[0].click();", optn_highToLow); 
	}
	
	public List<String> getProductNameAndPrice() {
		List<String> detailsOfProduct = new ArrayList<String>();
		
		for(int i=0;i<3;i++) {
			detailsOfProduct.add(txt_productName.get(i).getText()+" - "+txt_price.get(i).getText());
		}
		return detailsOfProduct;
	}

}