package logo.module;

import logo.log.SelLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class Login
{
	private static final SelLogger logger = SelLogger.getLogger(Login.class);
	private WebDriver driver;
	PublicModule p=new PublicModule();
	
	@FindBy(how = How.ID, using = "loginname")
	public static WebElement loginnameInputbox;                                    
	@FindBy(how = How.ID, using = "loginpwd")
	public static WebElement loginpwdInputbox;                                    
	@FindBy(how = How.ID, using = "btn-login")
	public static WebElement loginBtn;                                           
	@FindBy(how = How.LINK_TEXT, using = "退出")
	public static WebElement loginResult;                                        
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,120);
		PageFactory.initElements(finder, this);                                      
		driver.manage().window().maximize();

	}

	public String userName(String userNameTxt)
	{
		loginnameInputbox.clear();                                                 
		loginnameInputbox.sendKeys(userNameTxt);                                    
		return userNameTxt;
	}
	
	public String passWord(String userPwdTxt)
	{
		loginpwdInputbox.clear();                                                  
		loginpwdInputbox.sendKeys(userPwdTxt);                                    
		return userPwdTxt;
	}

	public void clickLoginButton()
	{
		p.waitForPageLoadByID("btn-login", driver);                              
		loginBtn.click();                                                        
	}

	public void checkResult()
	{
		 Assert.assertEquals(loginResult.isDisplayed(), true);                    //结果断言，根据link_text判断是否存在“退出”，存在则说明登录成功，否则用例失败
	}
}
