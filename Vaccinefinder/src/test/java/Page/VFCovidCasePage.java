package Page;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VFCovidCasePage extends TestData {
	
	   //VFTC5- Verify whether the covid graph is displayed against a selected states and district
	  //Expected - Covid graph should be displayed against Country , states and district
		public void verifyCovidGraph()
		{
			VFhomepage vfh = new VFhomepage();
			implicitWaitDriver(90);
			WebElement covidCasesLink = findElement(EleCovidCases);       
			clickElementWebelement(covidCasesLink); 
			driver.navigate().to(url +"/total-cases");
			
			implicitWaitDriver(50);
			//Verify the default values for the dropdown
			//Expected- State:Kerala District:Ernakulam
			WebElement DefaultStates = findElement(DDCovidState);
			WebElement DefaultDistricts = findElement(DDDistrict);
			Assert.assertEquals(getDefaultSelectedOption(DefaultStates),DefaultState ,"Incorrect state default value");
			Assert.assertEquals(getDefaultSelectedOption(DefaultDistricts),DefaultCovidDistrict,"Incorrect district default value");
			
			vfh.randomDropdownValGenerator(DDCovidState);
			vfh.randomDropdownValGenerator(DDDistrict);
			implicitWaitDriver(50);
			//Verify whether Covid graph for india is displayed or not
			WebElement Country = getElementByXpathContainsText("India");
			Assert.assertTrue(Country.isDisplayed(),"Covid graph for "+Country+"not found");
			
			//Verify whether covid graph for selected state is displayed or not
		    WebElement State = getElementByXpathContainsText("State");
		    Assert.assertTrue(State.isDisplayed(),"Covid graph for "+State+"not found");
		    
		   //Verify whether covid graph for selected district is displayed or not
		    WebElement District = getElementByXpathContainsText("District");
		    Assert.assertTrue(District.isDisplayed(),"Covid graph for "+District+"not found");
		    
		}
		
		//Verify whether the user is getting navigated to whatsapp sign in page while click on 'whatsapp' link from the Download Certificate alert
		//Expected - User should be navigated to Whatsapp page while click on 'whatsapp' link from the Download Certificate alert
		public void verifyDownloadCertifiucate()
		{
			WebElement DownloadCertificate = findElement(EleCertificateLink);       
			clickElementWebelement(DownloadCertificate);
			
			if(isAlertPresentornot()==true)
			{
				Alert Aboutalert = driver.switchTo().alert();
				implicitWaitDriver(50);
				Aboutalert.accept();
				WebElement CertificateTitle = findElement(EleCertificateAlertTitle);
				String Title = CertificateTitle.getText();
				Assert.assertEquals(Title,"Download Certificate in Whatsapp",Title+"not displayed");
				
				WebElement WhatsappLink = findElement(LinkWhatsapp);       
				clickElementWebelement(WhatsappLink);
				Set<String> WindowHandles = driver.getWindowHandles();
				Iterator<String> iterator = WindowHandles.iterator();
				String ParentWindow = iterator.next();
				String ChildWindow = iterator.next();
				driver.switchTo().window(ChildWindow);
				WebElement WhatsappTitle = findElement(EleWhatsappTitle);
				String Title2 = WhatsappTitle.getText();
				Assert.assertEquals(Title2,"Download Certificate in Whatsapp","User is not redirected to whatsapp home page");
				driver.switchTo().window(ParentWindow);
				Aboutalert.accept();
				driver.navigate().back();
				
				
				
			}
		}
		//VFTC7- Verify the functionality of 'about' button on the top right corner of the home page and also verify 
		//whether user is getting navigated to linkedin signup page while click on developer name link
		//Expected - when the user clicks on about button the corresponding alert should displayed and user should be able to click on name link and should
		//be redirected to linkedin signup page
		public void verifyAlertButton()
		{
			implicitWaitDriver(70);
			WebElement aboutButtonElement = findElement(EleAboutButton);       
			clickElementWebelement(aboutButtonElement);
			
			
			if(isAlertPresentornot()==true)
			{
				Alert Aboutalert = driver.switchTo().alert();
				implicitWaitDriver(50);
				Aboutalert.accept();
				WebElement LinkedinLink = findElement(LinkLinkedin);       
				clickElementWebelement(LinkedinLink);
				Set<String> WindowHandles = driver.getWindowHandles();
				Iterator<String> iterator = WindowHandles.iterator();
				String ParentWindow = iterator.next();
				String ChildWindow = iterator.next();
				driver.switchTo().window(ChildWindow);
				WebElement LinkedinTitle = findElement(EleLinkedinTitle);
				String Title3 = LinkedinTitle.getText();
				Assert.assertEquals(Title3,"Join LinkedIn","User is not redirected to linkedin as expected");
				driver.switchTo().window(ParentWindow);
				Aboutalert.dismiss();
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}

}
