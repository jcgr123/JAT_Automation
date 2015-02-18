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
 *  * 
 * @author carlos guevara
 *
 */
public class Dashboard {

	WebDriver driver;

	@FindBy(xpath = "//ul/span[@title='email']")
	WebElement userName;

	@FindBy(xpath = "html/body/div[1]/section/div/div/div/div/div[1]/div[2]/button")
	WebElement btnNewProject;

	@FindBy(xpath = "//td[7]/div/a")
	WebElement deleteProject;

	@FindBy(xpath = "li/div/div[2]/button")
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
		WebDriverWait wait = new WebDriverWait(driver, 10);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-0")));
		driver.findElement(By.id("button-0")).click();
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
	 * Click on first project link but waiting for it appears  
	 */
	public  UserStory clickSelectFirstProject() {   	 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.
				xpath("(//a[contains(@href, '')])[3]")));
		driver.findElement(By.xpath("//td/div/a")).click();		
		return new UserStory();
	}
}
