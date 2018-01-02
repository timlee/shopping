package logo.testsuite.login;

import logo.log.SelLogger;
import org.testng.annotations.Test;

public class LoginTestSuiteTestng
{
	private static final SelLogger logger = SelLogger.getLogger(LoginTestSuiteTestng.class);   //加载junit类的日志信息
	private LoginTestSuiteJunit loginTestsuite = new LoginTestSuiteJunit();                    //创建登录junit的类并初始化

	@Test(groups = {"login"})
	public void Login_phone_TestCase_01() throws Exception      //手机登录用例
	{	
		loginTestsuite.setUp();                                 //登录用例初始化
		loginTestsuite.Login_TestCase_01();                     //登录用例测试
		loginTestsuite.tearDown();                              //登录用例清理环境
	}
}
