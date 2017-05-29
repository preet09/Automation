package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class CommonPage 
{
	 BrowserAction oAction;
      public boolean SetUp() throws IOException
{
         oAction = new BrowserAction();
         return oAction.SetUp();            
}
	/*    public boolean SetUp() throws IOException
	    {
	    	String browser=PropertyReader.GetValue("browser");
	    	try
	    	{
	    		if(browser.equals("ff"))
	    			driver=new FirefoxDriver();
	    		
	    		else if(browser.equals("chrome"))
	    		{
	    			System.setProperty("webdriver.chrome.driver", "IEDriverServer.exe");
	    			driver=new InternetExplorerDriver();
	    		}
	    		else if(browser.equals("ie"))
	    		{
	    			
	    			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    			driver=new ChromeDriver();
	    		}
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		BrowserAction.ErrorMessages.append("Browser not found");
	    		return false;
	    		
	    	}
	    }*/
	 
	public boolean Verify_Header() throws IOException
	{
		boolean isresult;
		String userurl = PropertyReader.GetValue("homepageurl");
		isresult = oAction.NavigateToURL(userurl, "MSN page");
		LoggerReport.log.debug("Navigated to msn site");
		List<Boolean> status = new ArrayList<Boolean>();
         if(isresult)
         {
         //  Verify Items
         isresult = oAction.IsObjectPresent(By.xpath("//header[@id='header-common']/h1/a[1]"), "MSN logo");
         status.add(isresult);
         }
         return status.contains(false) ? false : true;
         
	  
    }        

	
	
	public void TakeScreenshot(String testcasename)
	{
		System.out.println("Take Screenshot");
		
	}
    public void TestCleanUp()
    {
    	oAction.CleanUp();
    	
    }
}
