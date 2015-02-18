package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.selenium.SeleniumDriverManager;

/**
 *  
 * @author carlos guevara
 *
 */
public class UserStory {

	public WebDriver driver;

	@FindBy(xpath = "//div[2]/div/div/div/div/div[3]")
	WebElement userStoryName;

	@FindBy(id = "newUserStory_link")
	WebElement btnAddStory;

	@FindBy(xpath = "//strong")
	WebElement btnDashboard;

	@FindBy(xpath = "//div[2]/div/section/div[2]")
	WebElement projectName;

	@FindBy(xpath = "//div[4]/div/div/div[2]/div[2]/div/div/div/div/div/span")
	WebElement dropDownUserStory;

	public UserStory() { 
		this.driver = SeleniumDriverManager.getManager().getDriver();	
		PageFactory.initElements(driver, this); 
	}

	public String getProjectName() {
		return projectName.getText();
	}

	/**
	 * Get user story name
	 * @return 
	 */
	public String getUserStoryName() {
		return userStoryName.getText();
	}

	/**
	 * Click on +Add Story button   
	 * @return
	 */
	public AddStory clickNewStoryBtn() {   	 
		btnAddStory.click();
		return new AddStory();
	}

	/**
	 * Click on Dashboard button   
	 */
	public Dashboard clickDashboardBtn() {
		btnDashboard.click();
		return new Dashboard();
	}

	public void clickDropDownIceboxUserStory() {
		dropDownUserStory.click();	
	} 
}