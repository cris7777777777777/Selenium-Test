package Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VFhomepage extends TestData {
	
	//VFTC2 - Verify whether state and district dropdown having the exact default values
	// Expected - State:Kerala District:Alapuzha
	public void verifyDropdownValues()
	{
		implicitWaitDriver(30);
		WebElement DefaultStates = findElement(DDState);
		WebElement DefaultDistricts = findElement(DDDistrict);
		Assert.assertEquals(getDefaultSelectedOption(DefaultStates),DefaultState ,"Incorrect state default value");
		Assert.assertEquals(getDefaultSelectedOption(DefaultDistricts),DefaultDistrict ,"Incorrect district default value");
	}
	
	//VFTC3- Verify the default count for the number of vaccine centers for the default districts and states
	//Expected - 5 vaccine centers(Kerala,Alapuzha)
	public void verifyVaccineCentersCount()
	{
     List<WebElement> tags = driver.findElements(By.tagName("a"));
     //retrieving the number of links
     for(int i=0;i<tags.size();i++)
     {
    	 String CowinTag = tags.get(i).getText(); 
    	 if(CowinTag==CowinLink)
    	 {
    		 int VaccinationCentersCount = tags.size();
    		 Assert.assertEquals(VaccinationCentersCount,"5","failed");
    	 }
     }
	}
	
	//VFTC3- Verify whether data filters in the home pages are working as expected
	//	
	public void verifyfilterFunctionality()
	{
	
		randomDropdownValGenerator(DDState);
		randomDropdownValGenerator(DDDistrict);
		implicitWaitDriver(70);
		
		//List<WebElement> checks =  driver.findElements(By.xpath("//button[text()='COVAXIN']/ancestor::div[@class='col-md-12']"));
		// click the 3rd checkbox
		//checks.get(2).click();
	    //WebElement[] listt = {getFilterElementByXpathContainsText("2"),getFilterElementByXpathContainsText("3")};
		//WebElement op = getRandomFromArray(listt);
		implicitWaitDriver(70);
		WebElement ee = findElement(ElePaidElement);
		clickElementWebelement(ee);
		
		implicitWaitDriver(70);
	}
	
	//method to generate random dropdown values from the select dropdown
	public  void randomDropdownValGenerator(By getRandom)
	{
		WebElement getRandomVal = findElement(getRandom);
		Select sel = new Select(getRandomVal);
		List<WebElement> allOptions = sel.getOptions();
		List<String> stringList = new ArrayList<String>();
		for(WebElement element :allOptions)
		{
			stringList.add(element.getText().toString());
		}
		String a = anyItem(stringList);
		//Select sel1 = new Select(getRandomVal);
		sel.selectByVisibleText(a);
		
		/*for(int k=0;k<=allOptions.size();k++)
		{
			List<String> stringOptions = allOptions.add(get(k).getText());
		}*/
				
	}
	
		
	
	
	
	//VFTC4- Verify the functionality of 'about' button on the top right corner of the home page
	//Expected - when the user clicks on about button the corresponding alert should displayed
	public void verifyAlertButton()
	{
		implicitWaitDriver(50);
		WebElement aboutButtonElement = findElement(EleAboutButton);       
		clickElementWebelement(aboutButtonElement);
		
		if(isAlertPresentornot()==true)
		{
			Alert Aboutalert = driver.switchTo().alert();
			implicitWaitDriver(50);
			Aboutalert.accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
				
				
	}
	
	
}
