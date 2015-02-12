package framework.pages;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory;

import framework.selenium.SeleniumDriverManager;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class Login {

	public WebDriver driver;

	@FindBy(xpath = "//input[@type='text']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement userPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement login;

	public Login() {
		this.driver = SeleniumDriverManager.getManager().getDriver();
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		driver.get("http://172.20.8.22:3001/#/signin");
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
	 * @param strUserEmail
	 * @param strPassword
	 * @return
	 */
	public Dashboard loginToJAT(String strUserEmail,String strPassword) {
		this.setUserEmail(strUserEmail);
		this.setUserPassword(strPassword); 
		this.clickLogin();
		return new Dashboard();
	}
}
