package logo.module;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import logo.log.SelLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublicModule
{
	private static final SelLogger logger = SelLogger.getLogger(PublicModule.class);
	
	public void waitForPageLoadByID(final String ID, WebDriver browser)                
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(browser, 10);                      
			wait.until(new ExpectedCondition<WebElement>()
			{
				public WebElement apply(WebDriver d)
				{
					return d.findElement(By.id(ID));
				}
			});
			if (null == wait)
			{
				this.CaptureScreenshot(Thread.currentThread().getId() + "ID",browser);  
				browser.quit();                                                         
			}

		} catch (Exception e)
		{
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId() + "ID", browser);    
			browser.quit();
		}

	}
	
	public  void waitForPageLoadBylinkText(final String ID, WebDriver browser)         
    {
		try
		{
		 WebDriverWait wait = new WebDriverWait(browser,10);                           
	     wait.until(new ExpectedCondition<WebElement>(){  
	            public WebElement apply(WebDriver d) {  
	                return d.findElement(By.linkText(ID));  
	            }});
	     if (null == wait)
			{
				this.CaptureScreenshot(Thread.currentThread().getId() + "ID",browser); 
				browser.quit();
			} 
		} catch (Exception e)
		{
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId() + "ID", browser);   
			browser.quit();
		}
    }
	
	  public boolean switchToWindow_Title(WebDriver driver, String windowTitle) {      
	    boolean flag = false;
	    try {
	      String currentHandle = driver.getWindowHandle();                            
	      Set<String> handles = driver.getWindowHandles();
	      for (String s : handles) {
	        if (s.equals(currentHandle))
	          continue;
	        else {
	          driver.switchTo().window(s);
	          if (driver.getTitle().contains(windowTitle)) {                         
	            break;
	          } else
	            continue;
	        }
	      }
	    } catch (NoSuchWindowException e) {
	      System.out.println("Window: " + windowTitle + " cound not find!!!"        
	          + e.fillInStackTrace());
	      flag = false;
	    }
	    return flag;
	  }
	
	  public boolean switchToWindow_Url(WebDriver driver, String windowUrl) {      
	    boolean flag = false;
	    try {
	      String currentHandle = driver.getWindowHandle();                         
	      Set<String> handles = driver.getWindowHandles();
	      for (String s : handles) {
	        if (s.equals(currentHandle))
	          continue;
	        else {
	          driver.switchTo().window(s);
	          if (driver.getCurrentUrl().contains(windowUrl)) {                  
	            flag = true;
	            break;
	          } else
	            continue;
	        }
	      }
	    } catch (NoSuchWindowException e) {
	      System.out.println("Window: " + windowUrl + " cound not find!!!"       
	          + e.fillInStackTrace());
	      flag = false;
	    }
	    return flag;
	  }
	  
	public void CaptureScreenshot(String fileName, WebDriver driver)             
	{
		String dirName = "test-output/screenshot";                               
		if (!(new File(dirName).isDirectory()))
		{
			new File(dirName).mkdir();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");          
		String time = sdf.format(new Date());
		TakesScreenshot tsDriver = (TakesScreenshot) driver;
		File image = new File(dirName + File.separator + time + "_" + fileName + ".png");  
		tsDriver.getScreenshotAs(OutputType.FILE).renameTo(image);
	}

}
