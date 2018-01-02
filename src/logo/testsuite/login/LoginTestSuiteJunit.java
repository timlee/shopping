package logo.testsuite.login;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import logo.log.SelLogger;
import logo.module.BrowserDriver;
import logo.module.FacebookUrl;
import logo.module.FileExcel;
import logo.module.Login;
import logo.module.PublicModule;
import logo.module.SiteUrl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

public class LoginTestSuiteJunit
{
	private static final SelLogger logger = SelLogger.getLogger(LoginTestSuiteJunit.class);
	private WebDriver browser;                          
	private String indexUrl,memberUrl,baseitemURL;      
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	FileExcel f=new FileExcel();                      
	PublicModule p=new PublicModule();                
	BrowserDriver browserDriver =new BrowserDriver();  
	 
	SiteUrl siteUrl=new SiteUrl();                     
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
		browser = browserDriver.browser2();  
		indexUrl =  siteUrl.indexUrl();      
		memberUrl = siteUrl.memberUrl();     
		baseitemURL = siteUrl.itemUrl();     
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//浏览器超时等待为30秒
	}

	@After
	public void tearDown() throws Exception
	{
		browser.quit();                        //清理环境，并退出关闭浏览器
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString))
		{
			fail(verificationErrorString);
		}
	}
	
	@Test
	public void Login_TestCase_01()                
	{

		
		logger.log("login start...");              
		browser.get(memberUrl);                    
		Login login = new Login(browser);	       
		login.userName(f.username());              
	    login.passWord(f.password());              
		login.clickLoginButton();                  
	    try {                                      
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {          
	        e.printStackTrace();
	    }
        login.checkResult();	                  
        logger.log("...login end"+"\r\n");        
	}
	
//	@Test
//	public void Login_TestCase_02()                
//	{
//		
//		browser.get("http://www.facebook.com/");
//		browser.findElement(By.id("email")).clear();
//		browser.findElement(By.id("email")).sendKeys("youremail");
//		browser.findElement(By.id("pass")).clear();
//		browser.findElement(By.id("pass")).sendKeys("yourpassword");
//		browser.findElement(By.id("u_0_3")).click();
//	    try {
//	        assertEquals("Facebook", browser.getTitle());
//	      } catch (Error e) {
//	        verificationErrors.append(e.toString());
//	      }
//		
//                 
//	    try {                                      
//	        Thread.sleep(2000);
//	    } catch (InterruptedException e) {          
//	        e.printStackTrace();
//	    }	                  
//        logger.log("...login end"+"\r\n");        
//	}
}
