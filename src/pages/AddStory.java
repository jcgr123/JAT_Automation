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
public class AddStory {

	WebDriver driver;

	@FindBy(id = "us-title")
	WebElement newUserStoryName;

	@FindBy(id = "us-type")
	WebElement newUserStoryType;

	@FindBy(id = "us-points-")
	WebElement newUserStoryPoints;

	@FindBy(xpath = "//form[@id='createFormUS']/fieldset/div[4]/div/div[2]/select")
	WebElement newUserStoryState;

	@FindBy(id = "us-owner-")
	WebElement newStoryOwner;

	@FindBy(id = "txt-description")
	WebElement newUserStoryDescription;

	@FindBy(id = "txt-acceptance")
	WebElement newUserStoryAcceptance;

	@FindBy(id = "createUS")
	WebElement saveUserStory;

	public AddStory() {
		this.driver = SeleniumDriverManager.getManager().getDriver();		 
		PageFactory.initElements(driver, this);
	}

	public String getNewStoryName() {   	 
		return newUserStoryName.getText();              
	}

	/**
	 * Set UserStory name in UserStory textbox   
	 * @param userStoryName contains the name of the user story 
	 */
	public void setNewStoryName(String userStoryName) {
		newUserStoryName.click();
		newUserStoryName.sendKeys(userStoryName);        
	}

	/**
	 * Set UserStory type in Checkbox   
	 * @param userStoryType contains the type of the user story
	 */
	public void setNewStoryType(String userStoryType) {
		newUserStoryType.sendKeys(userStoryType);        
	}

	/**
	 * Set UserStory Points in Checkbox 
	 * @param userStoryPoints contains the points given to the user story
	 */
	public void setNewStoryPoints(String userStoryPoints) {
		newUserStoryPoints.sendKeys(userStoryPoints);        
	}

	/**
	 * Set UserStory State in Checkbox 
	 * @param userStoryState displays user story state
	 */
	public UserStory setNewStoryState(String userStoryState) {
		newUserStoryName.click();
		//newUserStoryState.click();
		newUserStoryState.sendKeys(userStoryState);
		return new UserStory();
	}

	/**
	 * Set UserStory Owner in Checkbox 
	 * @param userStoryOwner displays user story owner
	 */
	public void setNewStoryOwner(String userStoryOwner) {
		newStoryOwner.sendKeys(userStoryOwner);        
	}

	/**
	 * Set UserStory Description in textbox
	 * @param userStoryDescription displays user story description
	 */
	public void setNewStoryDescription(String userStoryDescription) {
		newUserStoryDescription.sendKeys(userStoryDescription);        
	}

	/**
	 * Set UserStory Acceptance in textbox
	 * @param userStoryAcceptance
	 */
	public void setNewStoryAcceptance(String userStoryAcceptance) {
		newUserStoryAcceptance.sendKeys(userStoryAcceptance);        
	}

	/**
	 * Click on Save button
	 */
	public UserStory clickSaveUserStory() {
		saveUserStory.click();
		return new UserStory();
	}

	public UserStory createNewStory(String strNewStory, String strNewType,
			String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription,
			String strNewAcceptance) { 	

		this.setNewStoryName(strNewStory); 
		this.setNewStoryType(strNewType);
		this.setNewStoryPoints(strNewPoints);
		this.setNewStoryState(strStoryState);
		this.setNewStoryOwner(strNewOwner);
		this.setNewStoryDescription(strNewDescription); 
		this.setNewStoryAcceptance(strNewAcceptance);
		this.clickSaveUserStory();
		return new UserStory();
	} 
}
