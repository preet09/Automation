package utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import testcases.Page;

public class BrowserAction extends Page
{
    
	public static StringBuilder ErrorMessages = new StringBuilder();
	public static WebDriver driver=null;
	
	public boolean SetUp() throws IOException
	{
		
		String browser=PropertyReader.GetValue("browser");
		System.out.println(browser);
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
    		else
    		{
    			ErrorMessages.append("Browser not defined in current browser "+browser);
    			return false;
    		}
    		
    		return true;
    	}
    	catch(Exception e)
    	{
    		BrowserAction.ErrorMessages.append(e.getMessage());
    		return false;
    		
    	}
	}
public boolean NavigateToURL(String url,String logicalname)
{
	try
	{
		driver.get(url);
		LoggerReport.log.debug("Open testsite url");
		return true;
	}
	catch(Exception e)
	{
		ErrorMessages.append("Could not navigate to url");
		 return false;
		
	}
	}
/*	 public boolean HoverAndClick(By mainItem, String mainItemLogicalName, By menuTable, By menuItemToClick, String menuItemLogName)
     {
     }
	 */
	 public boolean  IsObjectPresent(By by,String logicalname)
		{ 
		 boolean isresult=false;
		 try
		{
			if( driver.findElement(by)!=null)
				isresult=true;
			else
				ErrorMessages.append("Unable to find control "+logicalname);	
		}
		 catch(Exception e)
		 {
			 isresult=false;
			 ErrorMessages.append("Unable to find control "+logicalname);
			 
		 }
		 return isresult;
			
		}
	 
	 public boolean CleanUp() 
		{
		 try
		 {
			 
              driver.close();
              LoggerReport.log.debug("Browser closed");
              return true;
		 }
		 catch(Exception e)
		 {
			 ErrorMessages.append(e.getMessage());
			 return false;
		 }
              
        }
}
