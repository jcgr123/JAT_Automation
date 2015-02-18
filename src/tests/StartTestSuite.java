package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.pages.Login;
import framework.pages.Logout;
import framework.utils.JSONReader;

/**
 *  * 
 * @author Carlos Guevara
 *
 */
public class StartTestSuite {
	Login objlogin = new Login();
	Logout objLogout = new Logout();

	@BeforeSuite
	public void init() {
		JSONReader objJSONReader = new JSONReader();
		String userEmail = objJSONReader.readJSON("user");
		String userPassword = objJSONReader.readJSON("password");
		objlogin.loginToJAT(userEmail, userPassword);
	}
	@AfterSuite
	public void quit() {
		objLogout.logoutOfJAT();
		objlogin.quit();
	}
}
