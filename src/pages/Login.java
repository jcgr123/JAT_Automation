package pages;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory;

import common.SeleniumDriverManager;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class Login {

	public WebDriver driver;

	@FindBy(xpath ="//input[@type='text']")
	WebElement userName;

	@FindBy(xpath ="//input[@type='password']")
	WebElement password;

	@FindBy(xpath ="//input[@value='Sign in']")
	WebElement login;

	public Login(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		driver.get("http://172.20.8.22:3001/#/signin");
	}

	/**
	 * Set user name in textbox
	 * @param strUserName
	 */
	public void setUserName(String strUserName){
		userName.clear();
		userName.sendKeys(strUserName);        
	}

	/**
	 * Set password in password textbox
	 * @param strPassword
	 */
	public void setPassword(String strPassword){
		password.clear();
		password.sendKeys(strPassword);
	}

	/**
	 * Click on login button
	 */
	public void clickLogin(){ 
		login.click();
	}

	/**
	 * Quit program
	 */
	public void quit(){
		driver.quit();
	}

	/**
	 * method that allows the user to log into JAT
	 * @param strUserName
	 * @param strPassword
	 * @return
	 */
	public Dashboard loginToJAT(String strUserName,String strPassword){

		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPassword); 
		//Click Login button
		this.clickLogin();

		return new Dashboard();
	}
}
