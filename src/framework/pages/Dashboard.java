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
public class Dashboard {

	public WebDriver driver;
	
	@FindBy(xpath = "//ul/span[@title='email']")
	WebElement userName;

	@FindBy(xpath = "//div[2]/button")
	WebElement btnNewProject;

	@FindBy(xpath = "//td[7]/div/a")
	WebElement deleteProject;

	@FindBy(id = "button-0")
	WebElement confirmDelete;

	@FindBy(xpath = "//td[6]/div/a")
	WebElement updateProject;

	@FindBy(xpath = "//td/div/a")
	WebElement selectFirstProject;

	@FindBy(xpath = "//ul/span[@title='email']")
	WebElement getUserName;

	public Dashboard() { 
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this); 
	}

	/**
	 * Get the User name from Home Page 
	 * @return
	 */
	public String getUserName() {
		return getUserName.getText();
	}

	/**
	 * Click on NewProject button   
	 */
	public  Project clickNewProject() {   	 
		btnNewProject.click();		
		return new Project();
	}

	/**
	 * Click on NewProject button   
	 */
	public  Dashboard deleteProject() {   	 
		deleteProject.click();
		return this;
	}

	/**
	 * Click on confirmation request  
	 */
	public  Dashboard confirmDelete() {   	 
		confirmDelete.click();
		return this;
	}

	/**
	 * Click on update link   
	 */
	public  Project clickUpdateProject() {   	 
		updateProject.click();
		return new Project();
	}

	/**
	 * Click on first project link   
	 */
	public  UserStory clickSelectFirstProject() {   	 
		selectFirstProject.click();
		return new UserStory();
	}
}
