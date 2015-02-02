package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.Project;
import pages.UserStory;

/**
 *  * 
 * @author carlos guevara
 *
 */

public class TestUpdateProject {

	Project objNewProject;
	Dashboard objDashboard;
	UserStory objUserStoriesPage;

	@BeforeTest
	public void setUp(){
		objNewProject = new Project();
		objDashboard = new Dashboard();
		objUserStoriesPage = new UserStory();
	}

	/*
	 * This test creates a new project  and updates it
	 * Verify the user name using Dashboard message
	 */
	@Test

	public void verifyNewProjectIsUpdatedCorrectly(){    	    	     

		String projectName = "1stNewProject";
		String iterationsNumber = "2";
		String numberOfIterationsToShow = "2";
		objDashboard.clickNewProject();
		// create title for the project   
		objNewProject.createNewProject(projectName,iterationsNumber);
		//Click Dashboard button
		objUserStoriesPage.clickDashboardButton();
		//Click +NewProject button in Dashboard class   	
		objDashboard.clickUpdateProject();
		objNewProject.updateProject("3",numberOfIterationsToShow); 
		objDashboard.clickSelectFirstProject();
		//Verify New Project is created
		Assert.assertTrue(objDashboard.getProjectName().contains(projectName));
		objUserStoriesPage.clickDashboardButton();
		objDashboard.deleteProject();
		objDashboard.confirmDelete();
	}
}
