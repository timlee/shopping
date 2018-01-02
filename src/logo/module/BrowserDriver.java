package logo.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDriver                                                        
{
	private WebDriver browser;                                                    
	
	public WebDriver browser()               
	{
	   browser = new FirefoxDriver();                                             
	   return browser;
	}
	
	public WebDriver browser1()
	{
	  System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe");    
      DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
      capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
      browser = new InternetExplorerDriver(capabilities);
      return browser;
	}
	
	public WebDriver browser2()
	{
	  System.setProperty("webdriver.ie.driver", ".\\lib\\chromedriver.exe");     
      DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
      capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
      browser = new ChromeDriver(capabilities);
      return browser;
	}
}
