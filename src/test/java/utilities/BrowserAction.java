package utilities;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	 
	 public boolean  OnHover(By by,String logicalname)
		{ 
		 boolean isresult=false;
		 Actions act =new Actions(driver);
		 
		 
		 try
		{
			 if( driver.findElement(by)!=null)
			 {
			 act.moveToElement(driver.findElement(by)).perform();
				isresult=true;
			 }
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
	 
	 public boolean  HoverAndClick(By by,String logicalname)
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
	 

	 public boolean  MatchText(By by,String expected)
		{ 
		 boolean isresult=false;
		 String actual=driver.findElement(by).getText();
		 
		 try
		{
			if( actual.equals(expected))
				isresult=true;
			else
				ErrorMessages.append(actual+"doesnt match with "+expected);	
		}
		 catch(Exception e)
		 {
			 isresult=false;
			 ErrorMessages.append("Could not match elements");
			 
		 }
		 return isresult;	
		}
	 
	 public boolean  NavigateToNewTab(String logicalname)
		{ 
		 boolean isresult=false;
		 
		 try
		{
			 Set<String> handle=driver.getWindowHandles();
				for(String windows:handle)
				{
					driver.switchTo().window(windows);
				}
				isresult=true;
		}
		 catch(Exception e)
		 {
			 isresult=false;
			 ErrorMessages.append("Unable to switch to windows "+logicalname);
			 ErrorMessages.append(e.getMessage());	 
		 }
		 return isresult;	
		}
	 
	 public boolean  EnterData(By by,String keyword,String logicalname)
		{ 
		 boolean isresult=false;
		 try
		 {
			driver.findElement(by).click();
			driver.findElement(by).clear();
		    driver.findElement(by).sendKeys(keyword);
		    isresult=true;
		 }
		 catch(NoSuchElementException e)
		 {
			 isresult=false;
			 ErrorMessages.append("Element Not Found "+logicalname);
			 ErrorMessages.append(e.getMessage());
			 
		 }
		 catch(Exception e)
		 {
			 isresult=false;
			 ErrorMessages.append("Unable to enter data in "+logicalname);
			 ErrorMessages.append(e.getMessage());
		 }
		 return isresult;	
		}
	 
	 public boolean  Click(By by,String logicalname)
		{ 
		 boolean isresult=false;
		 
		 try
		{
			 driver.findElement(by).click();
			 isresult=true;
		}
		 
		 catch(NoSuchElementException e)
		 {
			 isresult=false;
			 ErrorMessages.append("Element Not Found "+logicalname);
			 ErrorMessages.append(e.getMessage());
			 
		 }
		 return isresult;	
		}
		 public boolean  WaitAndClick(By by,String logicalname)
			{ 
			 boolean isresult=false;
			 WebDriverWait wait=new WebDriverWait(driver,10);
			 try
			{
				 
                 wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
				 isresult=true;
			}
			 
			 catch(NoSuchElementException e)
			 {
				 isresult=false;
				 ErrorMessages.append("Element Not Found "+logicalname);
				 ErrorMessages.append(e.getMessage());
				 
			 }
		 catch(Exception e)
		 {
			 isresult=false;
			 ErrorMessages.append("Unable to perform click on "+logicalname);
          }
		 return isresult;	
		}
		 
		 public boolean  WaitForObject(By by,String logicalname)
			{ 
			 boolean isresult=false;
			 WebDriverWait wait=new WebDriverWait(driver,10);
			 try
			{
				 
              wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				 isresult=true;
			}
			 
			 catch(NoSuchElementException e)
			 {
				 isresult=false;
				 ErrorMessages.append("Element Not Found "+logicalname);
				 ErrorMessages.append(e.getMessage());
				 
			 }
		 catch(Exception e)
		 {
			 isresult=false;
			 ErrorMessages.append("Unable to perform click on "+logicalname);
       }
		 return isresult;	
		}
	 
	 public boolean  VerifyElementsCountNotNull(By by,String logicalname)
		{ 
		 boolean isresult=false;
		 
		 try
		{
			 List<WebElement> list=driver.findElements(by);
			 int size=list.size();
			 if(size>0)
				isresult=true;  	
		}
		 
		 catch(NoSuchElementException e)
		 {
			 isresult=false;
			 ErrorMessages.append("Element Not Found "+logicalname);
			 ErrorMessages.append(e.getMessage());
			 
		 }
		 catch(Exception e)
		 {
			 isresult=false;
			 ErrorMessages.append("Could not get elements for "+logicalname);
			 ErrorMessages.append(e.getMessage());
			 
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
