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
	public By BtnReset = By.xpath("//button[@title='Reset Current Search']");
	public By EleCovidCases = By.xpath("//a[@href='/total-cases']");
	public By DDCovidState = By.name("selectedState"); 
	public By EleCertificateLink = By.xpath("//a[text()='Download Certificate']");
	public By EleCertificateAlertTitle = By.className("modal-title");
	public By LinkWhatsapp = By.xpath("//a[@href='https://api.whatsapp.com/send?phone=+919013151515']");
	public By EleWhatsappTitle = By.xpath("//img[@src='https://static.whatsapp.net/rsrc.php/v3/y7/r/DSxOAUB0raA.png']");
	public By LinkLinkedin = By.xpath("//a[@href='https://www.linkedin.com/in/athulnair/\']");
	public By EleLinkedinTitle = By.xpath("//*[@class='authwall-join-form__title']");
	
	
	public WebElement getElementByXpathContainsText(String name)
    {
    return driver.findElement(By.xpath("//h4[contains(text(),'"+name+"')]//../canvas"));
    }
	
	public WebElement getFilterAllElementByXpathContainsText(String All)
    {
    return driver.findElement(By.xpath("//button[text()='"+ All +"']/ancestor::div[@class='col-md-12']//button[1]"));
    }
	

	public WebElement getSlotsText(String text)
    {
    return driver.findElement(By.xpath("//button[text()='"+ All +"']/ancestor::div[@class='col-md-12']//button[1]"));
    }

	
	
	
	
	

}
