package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page.VFhomepage;

public class TestCase extends VFhomepage {
	
	//TC1- Verify whether the title of the page is correct as expected
	@Test(priority=1,enabled=true)
	public void VFTC1() 
	{
		implicitWaitDriver(30);
		Assert.assertEquals(getTitleOfPage(),Homepagetitle,getTitleOfPage()+"is incorrect");
	}
	
	@Test(priority=2,enabled=true)
	public void VFTC2() 
	{
	verifyDropdownValues();
	}
	
	@Test(priority=3,enabled=true)
	public void VFTC3() 
	{
		verifyVaccineCentersCount();
	}
	
	@Test(priority=4,enabled=true)
	public void VFTC4() throws InterruptedException 
	{
		verifyResetButtonFunctionality();
	}
	

	@Test(priority=6,enabled=true)
	public void VFTC5() 
	{
		verifyCovidGraph();
	}
	
	@Test(priority=7,enabled=true)
	public void VFTC6() 
	{
		verifyDownloadCertifiucate();
	}
	
	@Test(priority=8,enabled=true)
	public void VFTC7() 
	{
		verifyAlertButton();
	}
	
	

}
