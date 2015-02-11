package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.Project;
import pages.UserStory;
import testNGReport.realTimeReport.RealTimeReport;

/**
 *  
 * @author carlos guevara
 *
 */
@Listeners(RealTimeReport.class)
public class TestUpdateProject {

	@BeforeClass
	public void preConditions() {
		String projectName = "1stNewProject";
		String iterationsNumber = "2";
		String doneIterationsToShow = "2";
		Dashboard objDashboard = new Dashboard();
		Project objProject = objDashboard.clickNewProject();
		UserStory objUserStory = objProject.createNewProject(projectName, iterationsNumber,
				doneIterationsToShow);
		objDashboard = objUserStory.clickDashboardBtn();
	}

	/*
	 * This test creates a new project  and updates it
	 * Verify the project updated the name using User Story label
	 */
	@Test
	public void verifyNewProjectIsUpdatedCorrectly() {    	    	     
		String projectName = "1stNewProjectUpdated";
		String iterationsNumber = "3";
		String doneIterationsToShow = "3";
		Dashboard objDashboard = new Dashboard();
		Project objProject = objDashboard.clickUpdateProject();
		objProject.updateProject(projectName,iterationsNumber,doneIterationsToShow);
		UserStory objUserStory = objDashboard.clickSelectFirstProject();
		//Verify New Project is created
		Assert.assertTrue(objUserStory.getProjectName().contains(projectName));
	}

	@AfterClass
	public void cleanEnvironment() {
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()	
					.confirmDelete();
	}
}
