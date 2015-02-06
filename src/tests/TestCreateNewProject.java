package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.Project;
import pages.UserStory;
import parameters.DataproviderClass;

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
	@Test(dataProvider = "createProject", dataProviderClass = DataproviderClass.class)
	public void verifyNewProjectIsCreatedCorrectly(String projectName, String iterationsNumber) {  
		Dashboard objDashboard = new Dashboard();
		Project objProject = objDashboard.clickNewProject();
	    UserStory objUserStory = objProject.createNewProject(projectName, iterationsNumber);
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
