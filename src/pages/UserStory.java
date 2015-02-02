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
public class UserStory {

	public WebDriver driver;

	@FindBy(xpath = "//div[2]/div/div/div/div/div[3]")
	WebElement userStoryName;

	@FindBy(id = "newUserStory_link")
	WebElement buttonAddStory;

	@FindBy(xpath = "//strong")
	WebElement buttonDashboard;

	public UserStory(){ 
		this.driver = SeleniumDriverManager.getManager().getDriver();	
		PageFactory.initElements(driver, this); 
	}

	/**
	 * Get user story name
	 * @return
	 */
	public String getUserStoryName(){
		return userStoryName.getText();
	}

	/**
	 * Click on +Add Story button   
	 * @return
	 */
	public AddStory clickNewStory(){   	 
		buttonAddStory.click();
		return new AddStory();
	}

	/**
	 * Click on Dashboard button   
	 */
	public void clickDashboardButton(){   	 
		buttonDashboard.click();
	}
}
