package logo.module;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import logo.log.SelLogger;

public class FileExcel
{
	private static final SelLogger logger = SelLogger.getLogger(FileExcel.class);
	
	public String username()                             
	{
	   try 
       {  
           String fileName = "./test.xls";               
           File file = new File(fileName);                                                     
           Workbook wb = Workbook.getWorkbook(file);                                  
           Sheet sheet = wb.getSheet(0);                                                     
           Cell cell = sheet.getCell(0, 0);              
           String username = cell.getContents();         
           return username;  
        } catch (BiffException e)                        
        {  
           e.printStackTrace();  
        } catch (IOException e) 
        {  
           e.printStackTrace();  
        }
	   return null;  
	}
	
	public String password()                             
	{
	   try 
       {  
           String fileName = "./test.xls";               
           File file = new File(fileName);                                                  
           Workbook wb = Workbook.getWorkbook(file);                                           
           Sheet sheet = wb.getSheet(0);                                                
           Cell cell = sheet.getCell(1, 0);             
           String password = cell.getContents();        
           return password;     
        } catch (BiffException e)                       
        {  
           e.printStackTrace();  
        } catch (IOException e) 
        {  
           e.printStackTrace();  
        }
	   return null;  
	}
}
