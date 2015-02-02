package tests;

import org.openqa.selenium.WebDriver;
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
public class TestCreateUserStoriesWithDataprovider {

	public WebDriver driver;

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
	 * This test creates a new user story  
	 * Verify the user name using user story name
	 */
	@Test(dataProvider="SearchProvider",dataProviderClass=DataproviderClass.class)
	public void testMethod(String strNewStory, String strNewType,
			String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription,
			String strNewAcceptance) throws InterruptedException{

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

		//Click select first project to insert user stories
		objUserStoriesPage.clickDashboardButton();
		objDashboard.deleteProject();
		objDashboard.confirmDelete();
	}
}
