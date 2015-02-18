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
 * @author carlos guevara
 *
 */
public class UserStory {

	WebDriver driver;

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

	/**
	 * Function that returns the name of the project
	 * @return
	 */
	public String getProjectName() {
		return projectName.getText();
	}

	/**
	 * function that returns user story name
	 * @return 
	 */
	public String getUserStoryName() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.
				xpath("//div[2]/div/div/div/div/div[3]")));
		//driver.findElement(By.xpath("//nav[2]/div/a")).click();
		return userStoryName.getText();
	}

	/**
	 * Click on +Add Story button   
	 * @return
	 */
	public AddStory clickNewStoryBtn() {   
		WebDriverWait wait = new WebDriverWait(driver, 10);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.
				id("newUserStory_link")));
		driver.findElement(By.xpath("//nav[2]/div/a")).click();
		//btnAddStory.click();
		return new AddStory();
	}

	/**
	 * Click on Dashboard button   
	 */
	public Dashboard clickDashboardBtn() {
		btnDashboard.click();
		return new Dashboard();
	}

	/**
	 * Function that clicks on the dropdown button for display user story information 
	 */
	public void clickDropDownIceboxUserStory() {
		dropDownUserStory.click();	
	} 
}
