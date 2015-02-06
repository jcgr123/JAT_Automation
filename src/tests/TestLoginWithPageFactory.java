package tests;

import org.testng.Assert; 
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test; 

import pages.Dashboard;
import pages.Login;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class TestLoginWithPageFactory {

	@BeforeTest
	public void preConditions(){
	}

	/* This test go to http://172.20.8.22:3001/#/signin 
	 * Login to application 
	 * Verify the project name using User Story label
	 */
	@Test
	public void verifyHomePageAppearCorrect() {
		String userEmail = "Carlos.Guevara@fundacion-jala.org";
		String userPassword = "Carlos.Guevara@fundacion-jala.org";
		//Create Login Page object
		Login objLogin = new Login();
		//login to application
		Dashboard objHomePage = objLogin.loginToJAT(userEmail, userPassword);
		//Verify home page
		Assert.assertTrue(objHomePage.getUserName().contains(userEmail));     
	}
}
