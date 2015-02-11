package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddStory;
import pages.Dashboard;
import pages.Project;
import pages.UserStory;
import parameters.DataproviderClass;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class TestCreateNewUserStoriesWithExcel {

	@BeforeClass
	public void preConditions() {			
		String projectName = "1stNewProject";
		String iterationsNumber = "2";
		String doneIterationsToShow = "2";
		Dashboard objDashboard = new Dashboard();
		Project objProject = objDashboard.clickNewProject();
		objProject.createNewProject(projectName, iterationsNumber, doneIterationsToShow);

	}

	/*
	 * This test creates a new user Story with an .xlsx file data 
	 * Verify the user story is created with the name provided
	 */
	@Test(dataProvider = "UserStoryData", dataProviderClass = DataproviderClass.class)
	public void verifyNewUserStoryIsCreatedWithTasksCorrectly(String strNewStory, 
			String strNewType,String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription, String strNewAcceptance) {		

		UserStory objUserStory = new UserStory();
		AddStory objAddStory = objUserStory.clickNewStoryBtn();
		objAddStory.createNewStory(strNewStory,  strNewType,
				strNewPoints, strStoryState,
				strNewOwner, strNewDescription,
				strNewAcceptance);
		//Verify New User Story is created
		Assert.assertTrue(objUserStory.getUserStoryName().contains(strNewStory));	
	}
	@AfterClass
	public void cleanEnvironment() {
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()	
		.confirmDelete();
	}
}
