package utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoggerReport
{
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static int counter=1;
	public static void Createlog()
	{
		PropertyConfigurator.configure("D:\\workspace\\MSN\\src\\test\\resources\\Properties\\log4j.properties");
	}
	
	public static void FinaliseReport(boolean status, String testcase, String starttime, String endtime)
    {
		
		String pf=status?"Pass":"Fail";	
        try
        {

     	   File FILE_NAME=new File("D:\\workspace\\MSN\\src\\test\\java\\utilities\\TestReport.xlsx");
     	   XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Test Report");
            ArrayList<String> items=new ArrayList<String>();
            items.add(pf);
            items.add(testcase);
            items.add(starttime);	
            items.add(endtime);
            XSSFRow row1=sheet.createRow(0);
           row1.createCell(0).setCellValue("Status");
           row1.createCell(1).setCellValue("Test Case");
           row1.createCell(2).setCellValue("Start Time");
           row1.createCell(3).setCellValue("End Time");
           
           XSSFRow row2=sheet.createRow(counter);
           counter++;
         	   for(int j=0,k=0;j<4;j++,k++)
         	   {
         		   if(k<items.size())
                     row2.createCell(j).setCellValue(items.get(k));
                }
             FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
             workbook.write(fileOut);
             fileOut.flush();
             fileOut.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    }



