package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.Project;
import pages.UserStory;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class TestCreateNewProject {
	
	/*
	 * This test creates a new project  
	 * Verify the project name using User Story label
	 */
	@Test
	public void verifyNewProjectIsCreatedCorrectly() {  
		String projectName = "1stNewProject";
		String iterationsNumber = "2";
		String doneIterationsToShow = "2";
		Dashboard objDashboard = new Dashboard();
		Project objProject = objDashboard.clickNewProject();
	    UserStory objUserStory = objProject.createNewProject(projectName, iterationsNumber,
	    		doneIterationsToShow);
		Assert.assertEquals(objUserStory.getProjectName(), projectName);		
	}
	
	@AfterClass
	public void cleanEnvironment() {
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()
					.confirmDelete();
	}
}