package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.selenium.SeleniumDriverManager;
import framework.utils.JSONReader;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class Login {

	WebDriver driver;

	@FindBy(xpath = "//input[@type='text']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement userPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement login;

	public Login() {
		JSONReader objJSONReader = new JSONReader();
		this.driver = SeleniumDriverManager.getManager().getDriver();
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		String url = objJSONReader.readJSON("url");
		driver.get(url);
	}

	/**
	 * Set user email in textbox
	 * @param strUserEmail
	 */
	public void setUserEmail(String strUserEmail) {
		userEmail.clear();
		userEmail.sendKeys(strUserEmail);        
	}

	/**
	 * Set password in password textbox
	 * @param strPassword
	 */
	public void setUserPassword(String strPassword) {
		userPassword.clear();
		userPassword.sendKeys(strPassword);
	}

	/**
	 * Click on login button
	 */
	public void clickLogin() { 
		login.click();
	}

	/**
	 * Quit program
	 */
	public void quit() {
		driver.quit();
	}

	/**
	 * Method that allows the user to log into JAT
	 * @param strUserEmail parameter to describe the users mail
	 * @param strPassword parameter to describe the users password
	 * @return
	 */
	public Dashboard loginToJAT(String strUserEmail,String strPassword) {
		this.setUserEmail(strUserEmail);
		this.setUserPassword(strPassword); 
		this.clickLogin();
		return new Dashboard();
	}
}
