package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AddStory;
import pages.Dashboard;
import pages.Project;
import pages.UserStory;
import parameters.DataproviderClass;
import testNGReport.realTimeReport.RealTimeReport;

/**
 *  * 
 * @author carlos guevara
 *
 */
@Listeners(RealTimeReport.class)
public class TestCreateUserStoriesWithDataprovider {


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
	 * This test creates a new user story with a matrix of data 
	 * Verify the user story is created with the name provided
	 */
	@Test(dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	public void testMethod(String strNewStory, String strNewType,
			String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription,
			String strNewAcceptance) throws InterruptedException {

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
	public void cleanEnvironment(){
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()	
					.confirmDelete();
	}
}
