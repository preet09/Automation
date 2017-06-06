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
         
         isresult = oAction.OnHover(By.xpath("//*[@id='header-common']/h1/a[1]")," Refresh page");
         status.add(isresult);
         
         isresult = oAction.MatchText(By.xpath("//*[@id='header-common']/h1/a[1]/span"), "refresh page");
         status.add(isresult);
         
         
     
         }
         return status.contains(false) ? false : true;
    }        
	
	public boolean Search() throws IOException
	{
		boolean isresult;
		String userurl = PropertyReader.GetValue("homepageurl");
		isresult = oAction.NavigateToURL(userurl, "MSN page");
		LoggerReport.log.debug("Navigated to msn site");
		List<Boolean> status = new ArrayList<Boolean>();
        
		if(isresult)
		{
			
		isresult=oAction.EnterData(By.xpath("//*[@id='q']"),"P", "Searchbox");
		status.add(isresult);
		
		isresult=oAction.WaitForObject(By.xpath("//ul[@id='sa_ul']//li"), "List");
		status.add(isresult);
		
		isresult=oAction.VerifyElementsCountNotNull(By.xpath("//ul[@id='sa_ul']//li"),"SearchList");
		status.add(isresult);
		
		isresult=oAction.Click(By.xpath("//*[@id='srchfrm']/div[2]/button[1]"),"Searchbutton");
		status.add(isresult);

		isresult=oAction.NavigateToNewTab("Bing page");
		status.add(isresult);
		
		isresult=oAction.IsObjectPresent(By.xpath("//*[@id='b_header']"),"Bing Header");
		status.add(isresult);    
		}
         return status.contains(false) ? false : true;
         
  
    }        
	
	
	public boolean Verify_SignIn() throws IOException
	{
		boolean isresult;
		String userurl = PropertyReader.GetValue("homepageurl");
		isresult = oAction.NavigateToURL(userurl, "MSN page");
		LoggerReport.log.debug("Navigated to msn site");
		List<Boolean> status = new ArrayList<Boolean>();
        
		if(isresult)
		{
			
		isresult=oAction.Click(By.xpath("//*[@id='meCtrl']/a"), "SignIn Button");
		status.add(isresult);
		
		isresult=oAction.EnterData(By.xpath("//*[@id='i0116']"), "preetkamal387@outlook.com", "Email ID");
		
		isresult=oAction.Click(By.xpath("//*[@id='idSIButton9']"), "Next button");
		status.add(isresult);
		
		isresult=oAction.WaitForObject(By.xpath("//*[@id='i0118']"), "Password Section");
		status.add(isresult);

		isresult=oAction.EnterData(By.xpath("//*[@id='i0118']"), "september09*", "Password Entered");
		status.add(isresult);
		
		isresult=oAction.Click(By.xpath("//*[@id='idSIButton9']"),"Sign In Button");
		status.add(isresult); 
		
		isresult=oAction.MatchText(By.xpath("//*[@id='meCtrl']/div/div[1]"), "preet", "Username");
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
