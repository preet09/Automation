package utilities;

import org.openqa.selenium.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class GetScreenshot 
{
	
	static File screenshot = ((TakesScreenshot) BrowserAction.driver).getScreenshotAs(OutputType.FILE);
	

		public static void Screenshotpage(String path) throws IOException
		{
			File file=new File(path);
			FileUtils.copyFile(screenshot,file);
			LoggerReport.log.debug("Screenshot captured");
			
		}
		public static void Screenshotelement(By by,String path) throws IOException
		{
			
			WebElement ele =BrowserAction. driver.findElement(By.xpath("//div[@id='container']//div[@class='_218svP']"));
			BufferedImage  fullImg = ImageIO.read(screenshot);

			// Get the location of element on the page
			Point point = ele.getLocation();

			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
			    eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);

			// Copy the element screenshot to disk
			File screenshotLocation = new File("D:\\Screenshots\\sample2.jpeg");
			FileUtils.copyFile(screenshot, screenshotLocation);
			System.out.println("WebElement screenshot captured");
			BrowserAction.driver.close();
		}
		
	}



