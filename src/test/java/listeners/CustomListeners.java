package listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testcases.Page;
import utilities.BrowserAction;
import utilities.CommonPage;

public class CustomListeners extends Page implements ITestListener
{
	public boolean OverallStatus;
	public String StartTime;
	public String EndTime;
	public CommonPage pageCommon;

	public void onStart(ITestContext arg0)
	{
		
		
		System.out.println("On start");
		
	}
	public void onFinish(ITestContext arg0)
	{
	
		
		
		System.out.println("On Finish");
	}

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
