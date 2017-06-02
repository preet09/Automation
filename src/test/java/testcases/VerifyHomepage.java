package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BrowserAction;
import utilities.CommonPage;
import utilities.GetScreenshot;
import utilities.LoggerReport;

@Test
public class VerifyHomepage 
{
	
	public boolean OverallStatus;
	public String StartTime;
	public String EndTime;
	public CommonPage pageCommon;
    
   @BeforeMethod
	public void setup()
	{
		OverallStatus = false;
        pageCommon = new CommonPage();
        Date dNow = new Date( );
        SimpleDateFormat ft = 
        new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        StartTime = ft.format(dNow);
        LoggerReport.Createlog();
        try {
			Assert.assertTrue(pageCommon.SetUp(), BrowserAction.ErrorMessages.toString());
		} catch (IOException e) {
			BrowserAction.ErrorMessages.append("IO exception");
		}
	}
	
	@Test
	public void Verify_Header() throws IOException
	{
		OverallStatus=pageCommon.Verify_Header();
	    Assert.assertTrue(OverallStatus,BrowserAction.ErrorMessages.toString());
	}
	
	@Test
	public void Search() throws IOException
	{
		OverallStatus=pageCommon.Search();
	    Assert.assertTrue(OverallStatus,BrowserAction.ErrorMessages.toString());
	}
	
	@AfterMethod
	public void teardown(Method testmethod) throws IOException
	{
		 Date dNow = new Date( );
	        SimpleDateFormat ft = 
	        new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	        EndTime= ft.format(dNow);
		String testname=testmethod.getName();
        if (!OverallStatus)
           GetScreenshot.Screenshotpage(System.getProperty("user.dir")+"\\src\\test\\java\\screenshots\\sample.jpeg");
        LoggerReport.FinaliseReport(OverallStatus, testname, StartTime, EndTime);
        pageCommon.TestCleanUp();
		
	}
}
