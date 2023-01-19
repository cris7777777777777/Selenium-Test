package Page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VFhomepage extends VFCovidCasePage {
	
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
	
	//VFTC4- Verify whether reset button is working as expected
	//Expected = While click on reset button after selecting random states and district , it should be reset to default values	
	public void verifyResetButtonFunctionality() throws InterruptedException
	{
		
		    implicitWaitDriver(70);
			randomDropdownValGenerator(DDState);
			randomDropdownValGenerator(DDDistrict);
			implicitWaitDriver(50);
			WebElement ResetButton = findElement(BtnReset);
			clickElementWebelement(ResetButton);
			Thread.sleep(5000);
			WebElement DefaultStates1 = findElement(DDState);
			WebElement DefaultDistricts1 = findElement(DDDistrict);
			implicitWaitDriver(70);
			Assert.assertEquals(getDefaultSelectedOption(DefaultStates1),DefaultState ,"Reset button is not working");
			Assert.assertEquals(getDefaultSelectedOption(DefaultDistricts1),DefaultDistrict ,"Reset Button is not working");
			
			
	}
	
	
	
	//Method to generate random dropdown values from the select dropdown
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
		sel.selectByVisibleText(a);
				
	}
	
	
	
	
	
			
	
	
}
