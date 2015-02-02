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

	AddStory objAddStory = new AddStory();		
	UserStory objUserStoriesPage = new UserStory();
	Project objNewProject = new Project();
	Dashboard objDashboard = new Dashboard();

	@BeforeClass

	public void setup(){
		String projectName = "1stNewProject";
		String iterationsNumber = "2";
		objDashboard.clickNewProject();
		objNewProject.createNewProject(projectName,iterationsNumber);	
	}

	/*
	 * This test creates a new user Story  
	 * Verify the user name using user story name
	 */
	@Test(dataProvider="UserStoryData", dataProviderClass=DataproviderClass.class)
	public void verifyNewUserStoryIsCreatedWithTasksCorrectly(String strNewStory, String strNewType,
			String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription,
			String strNewAcceptance){		

		objUserStoriesPage.clickNewStory();
		objAddStory.createNewStory(strNewStory,  strNewType,
				strNewPoints, strStoryState,
				strNewOwner, strNewDescription,
				strNewAcceptance);
		//Verify New User Story is created
		Assert.assertTrue(objUserStoriesPage.getUserStoryName().contains(strNewStory));
	}

	@AfterClass
	public void cleanEnvironment(){

		objUserStoriesPage.clickDashboardButton();
		objDashboard.deleteProject();
		objDashboard.confirmDelete();
	}
}
