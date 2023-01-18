package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInitialization {
	
	
	public static WebDriver driver;
	
	@Parameters("Browser")
	@BeforeTest
	public void setBrowser(String br)
	{
	
		if(br.equals("EdgeDriver"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(br.equals("ChromeDriver")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
     SeleniumFunctions.getApplicationURL();
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();
		
	}
	
	

}
