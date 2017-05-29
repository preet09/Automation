package utilities;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerReport
{
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static void Createlog()
	{
		PropertyConfigurator.configure("D:\\workspace\\MSN\\src\\test\\resources\\Properties\\log4j.properties");
	}
	
	public static void FinaliseReport(boolean status, String testcase, String starttime, String endtime)
    {
		
		
		String pf=status?"Pass":"Fail";
		System.out.println("Status "+pf);
		System.out.println("Testcase "+testcase);
		System.out.println("Starttime "+starttime);
		System.out.println("Endtime "+endtime);
    }
}


