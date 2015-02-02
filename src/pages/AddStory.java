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

	public WebDriver driver;
	UserStory userStoriesPage = new UserStory();

	@FindBy(id="us-title")
	WebElement newStoryTitle;

	@FindBy(id = "us-type")
	WebElement newStoryType;

	@FindBy(id = "us-points-")
	WebElement newStoryPoints;

	@FindBy(xpath = "//form[@id='createFormUS']/fieldset/div[4]/div/div[2]/select")
	WebElement newStoryState;

	@FindBy(id = "us-owner-")
	WebElement newStoryOwner;

	@FindBy(id = "txt-description")
	WebElement newStoryDescription;

	@FindBy(id = "txt-acceptance")
	WebElement newStoryAcceptance;

	@FindBy(id = "createUS")
	WebElement saveStory;

	public AddStory(){
		this.driver = SeleniumDriverManager.getManager().getDriver();		 
		PageFactory.initElements(driver, this);
	}

	public String getNewStory(){   	 
		return newStoryTitle.getText();              
	}

	/**
	 * Set UserStory name in textbox   
	 * @param strNewStory
	 */
	public void setNewStory(String strNewStory){
		newStoryTitle.click();
		newStoryTitle.sendKeys(strNewStory);        
	}

	/**
	 * Set UserStory name in Checkbox   
	 * @param strNewType
	 */
	public void setNewType(String strNewType){

		newStoryType.sendKeys(strNewType);        
	}

	/**
	 * Set UserStory Points in Checkbox 
	 * @param strNewPoints
	 */
	public void setNewPoints(String strNewPoints){
		newStoryPoints.sendKeys(strNewPoints);        
	}

	/**
	 * Set UserStory State in Checkbox 
	 * @param strStoryState
	 */
	public void setNewState(String strStoryState){
		newStoryTitle.click();
		newStoryState.sendKeys(strStoryState);        
	}

	//Set UserStory Owner in Checkbox 
	public void setNewOwner(String strNewOwner){
		newStoryOwner.sendKeys(strNewOwner);        
	}

	/**
	 * Set UserStory Description in textbox
	 * @param strNewDescription
	 */
	public void setNewDescription(String strNewDescription){
		newStoryDescription.sendKeys(strNewDescription);        
	}

	/**
	 * Set UserStory Acceptance in textbox
	 * @param strNewAcceptance
	 */
	public void setNewAcceptance(String strNewAcceptance){
		newStoryAcceptance.sendKeys(strNewAcceptance);        
	}

	/**
	 * Click on Save button
	 */
	public void clickSaveStory(){
		saveStory.click();
	}


	public UserStory createNewStory(String strNewStory, String strNewType,
			String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription,
			String strNewAcceptance){ 	

		//Fill Story Title  
		this.setNewStory(strNewStory);

		//Fill Story Type  
		this.setNewType(strNewType);

		//Fill Story Points  
		this.setNewPoints(strNewPoints);

		//Fill Story State  
		this.setNewState(strStoryState);

		//Fill Story Owner  
		this.setNewOwner(strNewOwner);

		//Fill Story Description  
		this.setNewDescription(strNewDescription);

		//Fill Story Acceptance  
		this.setNewAcceptance(strNewAcceptance);

		//Click Login button
		this.clickSaveStory();

		return new UserStory();
	} 
}
