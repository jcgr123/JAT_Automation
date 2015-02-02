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

public class Project {

	Dashboard dashboard = new Dashboard();
	UserStory userStoriesPage = new UserStory();

	public WebDriver driver;	

	@FindBy(css="div.project-name.ng-binding")
	WebElement projectName;

	@FindBy(xpath = "//input[@type='text']")
	WebElement newProjectName;

	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[3]/div/select")
	WebElement iterationLength;

	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[6]/div/select")
	WebElement numberOfDoneIterationsToShow;

	@FindBy(css = "div.ng-scope > button.btn.btn-primary")
	WebElement saveProject;

	public Project(){

		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Get  NewProject Name 
	 * @return
	 */
	public String getProjectDashboardName(){
		return projectName.getText();
	}

	/**
	 * Set project name in textbox   
	 * @param strNewProject
	 */
	public void setNewProject(String strNewProject){
		newProjectName.click();
		newProjectName.sendKeys(strNewProject);        
	}

	/**
	 * Set IterationLength in IterationLength textbox 
	 * @param strIterationLength
	 */
	public void setIterationLength(String strIterationLength){
		iterationLength.sendKeys(strIterationLength); 
	}

	/**
	 * Set number of done iterations textbox 
	 * @param strNumberOfDoneIterations
	 */
	public void setNumberOfDoneIterationsToShow(String strNumberOfDoneIterations){
		numberOfDoneIterationsToShow.sendKeys(strNumberOfDoneIterations); 
	}

	/**
	 * Click on Save button
	 */
	public void clickSave(){
		saveProject.click();
	}      

	/*   
	 * This method will allow to create a new project 
	 * @param strnewProject
	 * @param strIterationLength
	 * @return
	 */

	public UserStory createNewProject(String strNewProject,String strIterationLength){

		//Fill user name 
		this.setNewProject(strNewProject);

		//Fill password 
		this.setIterationLength(strIterationLength); 

		//Click Login button
		this.clickSave();   

		return new UserStory();
	}

	/**
	 * This method will allow to update a new project
	 * @param strIterationLength
	 * @param strNumberOfDoneIterations
	 * @return
	 */
	public UserStory updateProject(String strIterationLength,
			String strNumberOfDoneIterations){

		//Fill password 
		this.setIterationLength(strIterationLength); 

		//Fill password 
		this.setNumberOfDoneIterationsToShow(strNumberOfDoneIterations);

		//Click Login button
		this.clickSave();  

		return new UserStory();
	}
}
