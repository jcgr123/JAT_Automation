package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.Dashboard;
import framework.pages.Login;
import framework.utils.JSONReader;


/**
 *  * 
 * @author Carlos Guevara
 *
 */
public class TestLoginWithPageFactory {

	/* This test go to http://172.20.8.22:3001/#/signin 
	 * Login to application 
	 * Verify the project name using User Story label
	 */
	@Test
	public void verifyHomePageAppearCorrect() {
		JSONReader objJSONReader = new JSONReader();
		String userEmail = objJSONReader.readJSON("user");
		String userPassword = objJSONReader.readJSON("password");
		//Create Login Page object
		Login objLogin = new Login();
		//login to application
		Dashboard objHomePage = objLogin.loginToJAT(userEmail, userPassword);
		//Verify home page
		Assert.assertTrue(objHomePage.getUserName().contains(userEmail));     
	}
}
