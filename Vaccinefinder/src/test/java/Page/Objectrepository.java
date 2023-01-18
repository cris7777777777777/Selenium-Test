package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Core.SeleniumFunctions;


public class Objectrepository extends SeleniumFunctions

{
	
	public By EleAboutButton = By.xpath("//span[text()= 'About']");
	public By DDState = By.name("selectState"); 
	public By DDDistrict = By.name("selectedDistrict"); 
	public By ElePaidElement = By.xpath("//button[text()='Free']/ancestor::div[@class='col-md-12']//button[3]");
	public By EleFreeElement = By.xpath("//button[text()='Free']/ancestor::div[@class='col-md-12']//button[3]");
	
	
	public WebElement getElementByXpathContainsText(String name)
    {
    return driver.findElement(By.xpath("//h4[contains(text(),'"+name+"')]//../canvas"));
    }
	
	public WebElement getFilterAllElementByXpathContainsText(String All)
    {
    return driver.findElement(By.xpath("//button[text()='"+ All +"']/ancestor::div[@class='col-md-12']//button[1]"));
    }
	
	/*public WebElement getFilterElementByXpathContainsText(int Ele)
    {
    return driver.findElement(By.xpath("//button[text()='Free']/ancestor::div[@class='col-md-12']//button['+ Ele +']"));
    }*/
	//button[text()='Free']/ancestor::div[@class='col-md-12']//button[2]
	
	
	
	
	

}
