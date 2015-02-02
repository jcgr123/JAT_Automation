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

public class Dashboard {

	public WebDriver driver;

	@FindBy(xpath = "//div[2]/div/section/div[2]")
	WebElement projectName;

	@FindBy(xpath = "//ul/span[@title='email']")
	WebElement userName;

	@FindBy(xpath = "//div[2]/button")
	WebElement buttonNewProject;

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

	public Dashboard(){ 
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this); 
	}

	/**
	 * Get  NewProject Name 
	 * @return
	 */
	public String getProjectName(){
		return projectName.getText();
	}

	/**
	 * Get the User name from Home Page 
	 * @return
	 */
	public String getUserName(){
		return getUserName.getText();
	}

	/**
	 * Click on NewProject button   
	 */
	public  void clickNewProject(){   	 
		buttonNewProject.click();
	}

	/**
	 * Click on NewProject button   
	 */
	public  void deleteProject(){   	 
		deleteProject.click();
	}

	/**
	 * Click on confirmation request  
	 */
	public  void confirmDelete(){   	 
		confirmDelete.click();
	}

	/**
	 * Click on update link   
	 */
	public  void clickUpdateProject(){   	 
		updateProject.click();
	}

	/**
	 * Click on update link   
	 */
	public  void clickSelectFirstProject(){   	 
		selectFirstProject.click();
	}
}
