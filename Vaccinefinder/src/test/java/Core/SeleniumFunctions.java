package Core;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList.Member2.Item;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import Test.TestData;

public class SeleniumFunctions extends BrowserInitialization {
	
	
	public static void getApplicationURL()
	{
		driver.get(Page.TestData.url);
		driver.manage().window().maximize();
	}
	
	Properties property = new Properties();
	public WebElement element;
	
	public WebElement findElement(By path)  {
		WebElement element;
		element = driver.findElement(path);
		return element;
	}
	
	public void insertTextIntoTextBox(WebElement pathOfTextFields, String texts)  {
		pathOfTextFields.sendKeys(texts);
	}
	
	/*public String userDataProperty(String key_of_value) throws Exception {
		FileReader reader = new FileReader("C:\\Users\\HP\\eclipse-workspace\\Oricoms\\Oricoms\\Oricoms\\Properties\\UserData.properties");
		property.load(reader);
		String value = property.getProperty(key_of_value);
		return value;
	}*/
	
	public String locatorProperties(String key_of_value){
		FileReader reader;
		String value=null;		
		try {
		reader = new FileReader("C:\\Users\\HP\\ec space new\\Vaccinefinder\\Properties");
		property.load(reader);	
		value = property.getProperty(key_of_value);
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		return value;
	}
	
	public void clickElementWebelement(WebElement elementToClick) {
		elementToClick.click();
	}
	
	public void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();		
	}
	
	public void getCurrentUrl() {
		driver.getCurrentUrl();		
	}
	
	/*public void waitingForElementclickable(WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(elementToWait));		
	}
	
	public void waitingForElementAppear(WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(elementToWait));
	}
	
	public void waitingForElementDisappear(WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(elementToWait));
	}*/
	
	public String getTitleFromTextBox(WebElement element) {
		String title = element.getAttribute("value");
		return title;		
	}
	
	public void scrollIntoViewPixel(int xValue, int yValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+xValue+","+yValue+")");
	}
	
	public void selectDropDown(WebElement element, String option) {
		Select selectvalue = new Select(element);
		selectvalue.deselectByVisibleText(option);
	}
	
	public String getDefaultSelectedOption(WebElement element) {
		Select selectvalue = new Select(element);
		WebElement op = selectvalue.getFirstSelectedOption();
		String om = op.getText();
		return om;
	}
	
	
	public String pageUrl() {
		String urlOfPage = driver.getCurrentUrl();
		return urlOfPage;
	}
	
	public void scrollIntoViewElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	@SuppressWarnings("deprecation")
	public void implicitWaitDriver(int time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	
	public String getTitleOfPage() {
		String actualtitle = driver.getTitle();
		return actualtitle; 
	}
	
	public String getTextOfElement(WebElement element) 
	{	
		String actualTextpath2=  element.getText();
		return actualTextpath2;
	}
	
	public boolean isAlertPresentornot()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	public String anyItem(List<String>list)
	{
		Random random = new Random();		
		int index = random.nextInt(list.size());
		return list.get(index);
		
	}
	
	public WebElement getRandomFromArray(WebElement[] listt)
	{
		Random random = new Random();		
		int index = random.nextInt(listt.length);
		return listt[index];
		
	}
	
	
	

}
