package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.Dashboard;
import pages.Project;
import pages.UserStory;

/**
 *  * 
 * @author carlos guevara
 *
 */

public class TestCreateNewProject {

	public WebDriver driver;

	Dashboard objDashboard;
	Project objNewProject;
	UserStory objUserStoriesPage;

	@BeforeTest

	public void setup(){
		// create objects
		objNewProject = new Project();
		objDashboard = new Dashboard();
		objUserStoriesPage = new UserStory();	
	}

	/*
	 * This test creates a new project  
	 * Verify the user name using Dashboard message
	 */
	@Test

	public void verifyNewProjectIsCreatedCorrectly(){  

		String projectName = "1stNewProject";
		String iterationsNumber = "2";
		objDashboard.clickNewProject();  
		objNewProject.createNewProject(projectName,iterationsNumber);
		//Verify New Project is created
		Assert.assertTrue(objDashboard.getProjectName().contains(projectName));
		objUserStoriesPage.clickDashboardButton();
		objDashboard.deleteProject();
		objDashboard.confirmDelete();
	}
}
