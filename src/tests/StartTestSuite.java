package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.pages.Login;
import framework.pages.Logout;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class StartTestSuite {
	Login objlogin = new Login();
	Logout objLogout = new Logout();

	@BeforeSuite
	public void init() {
		String userEmail = "Carlos.Guevara@fundacion-jala.org";
		String userPassword = "Carlos.Guevara@fundacion-jala.org";
		objlogin.loginToJAT(userEmail, userPassword);
	}
	@AfterSuite
	public void quit() {
		objLogout.logoutOfJAT();
		objlogin.quit();
	}
}
