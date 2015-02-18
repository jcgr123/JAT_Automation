package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.selenium.SeleniumDriverManager;

/**
 *   
 * @author Carlos Guevara
 *
 */
public class Project {

	UserStory userStoriesPage = new UserStory();

	public WebDriver driver;	

	@FindBy(css = "div.project-name.ng-binding")
	WebElement projectName;

	@FindBy(xpath = "//input[@type='text']")
	WebElement newProjectName;

	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[3]/div/select")
	WebElement iterationLength;

	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[6]/div/select")
	WebElement numberOfDoneIterationsToShow;

	@FindBy(css = "div.ng-scope > button.btn.btn-primary")
	WebElement saveProject;

	public Project() {
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Get  NewProject Name 
	 * @return the name of the project
	 */
	public String getProjectDashboardName() {
		return projectName.getText();
	}

	/**
	 * Set project name in textbox   
	 * @param strProjectName parameter to describe the name of the project
	 */
	public void setNewProject(String strProjectName) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("newProjectForm")));
		driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div/div/input")).clear();
		//		newProjectName.click();
		//		newProjectName.clear();
		newProjectName.sendKeys(strProjectName);        
	}

	/**
	 * Set IterationLength in IterationLength textbox 
	 * @param strIterationLength parameter to describe the lenght of the iteration
	 */
	public void setIterationLength(String strIterationLength) {
		iterationLength.sendKeys(strIterationLength); 
	}

	/**
	 * Set number of done iterations textbox 
	 * @param strIterationsToShow parameter to describe the number of iterations to display
	 */
	public void setNumberOfDoneIterationsToShow(String strIterationsToShow) {
		numberOfDoneIterationsToShow.sendKeys(strIterationsToShow); 
	}

	/**
	 * Click on Save button
	 */
	public void clickSave() {
		saveProject.click();	
	}      

	/*   
	 * This method will allow to create a new project 
	 * @param strnewProject
	 * @param strIterationLength
	 * @return
	 */
	public UserStory createNewProject(String strNewProject,String strIterationLength, 
			String strIterationsToShow) {
		this.setNewProject(strNewProject);
		this.setIterationLength(strIterationLength); 
		this.setNumberOfDoneIterationsToShow(strIterationsToShow);
		this.clickSave();   
		return new UserStory();
	}

	/**
	 * This method will allow to update a new project
	 * @param strIterationLength 
	 * @param strNumberOfDoneIterations
	 * @return
	 */
	public Dashboard updateProject(String strNewProject, String strIterationLength,
			String strNumberOfDoneIterations) {
		this.setNewProject(strNewProject);
		this.setIterationLength(strIterationLength); 
		this.setNumberOfDoneIterationsToShow(strNumberOfDoneIterations);
		this.clickSave();  
		return new Dashboard();
	}
}
