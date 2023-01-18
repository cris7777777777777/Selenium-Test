package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page.VFhomepage;

public class TestCase extends VFhomepage {
	
	//TC1- Verify whether the title of the page is correct as expected
	@Test(priority=3,enabled=false)
	public void VFTC1() 
	{
		implicitWaitDriver(30);
		Assert.assertEquals(getTitleOfPage(),Homepagetitle,getTitleOfPage()+"is incorrect");
	}
	
	@Test(priority=2,enabled=false)
	public void VFTC2() 
	{
	verifyDropdownValues();
	}
	
	@Test(priority=3,enabled=false)
	public void VFTC3() 
	{
		verifyVaccineCentersCount();
	}
	
	@Test(priority=1,enabled=true)
	public void VFTC4() 
	{
		verifyfilterFunctionality();
	}
	
	
	
	@Test(priority=5,enabled=false)
	public void VFTC5() 
	{
		verifyAlertButton();
	}
	
	

}
