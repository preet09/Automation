package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{

	public static String GetValue(String key) throws IOException
	{
		FileInputStream fis;
		
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
			Properties config=new Properties();
			config.load(fis);
			LoggerReport.log.debug("Config property loaded");
			String browse=config.getProperty(key);
			System.out.println(browse);
			return browse;
		
		
		
		
		
	}
}
