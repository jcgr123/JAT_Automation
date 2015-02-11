package tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddStory;
import pages.Dashboard;
import pages.Project;
import pages.UserStory;
import excelFiles.ExcelSheetReader;

public class TestCreateOneProjectWithThreeUserStoriesWithJXL {

	WebDriver driver;

	@BeforeTest
	public void preConditions() throws Exception {	

		ExcelSheetReader xlsFile = new ExcelSheetReader(System.getProperty("user.dir") +
				"src\tests\resources\\Data.xls", "ProjectData");
		List<Map<String, String>> listOfMaps = new LinkedList<>();			
		Dashboard objDashboard = new Dashboard();	
		Project objProject = objDashboard.clickNewProject();   
		UserStory objUserStory = objProject.createNewProject(listOfMaps[0].get("Name"),
				listOfMaps[1].get("IterationNumber"), listOfMaps[2].get("NumberOfDoneIterationsToShow"));

	}
	/*
	 * This test creates a new project  
	 * Verify the project name using User Story label
	 */
	@Test
	public void verifyNewProjectIsCreatedCorrectly() {   
		//		
		//		HashMap<String, HashMap> selects = new HashMap<String, HashMap>();
		//		for (String key : selects.keySet())
		//		{
		//		    HashMap<innerKey, String> boxHolder = selects.get(key);
		//		    ComboBox cb = new ComboBox();
		//		}
		ExcelSheetReader xlsFile = new ExcelSheetReader(System.getProperty("user.dir") +
				"src\tests\resources\\Data.xls", "StoryData");
		List<Map<String, String>> selects =  new LinkedList<>();

		for(String key : selects.keySet()) {

			List<Key, String> boxHolder= selects.get("Name");

			UserStory objUserStory = new UserStory();
			AddStory objAddStory = objUserStory.clickNewStoryBtn();
			//			objAddStory.createNewStory(strNewStory,  strNewType,
			//					strNewPoints, strStoryState,
			//					strNewOwner, strNewDescription,
			//					strNewAcceptance);
		}

		//Verify New User Story is created
		//Assert.assertTrue(objUserStory.getUserStoryName().contains(strNewStory));	
	}
	/**
	 * This function will take screenshot
	 * @param webdriver
	 * @param fileWithPath
	 * @throws Exception
	 */

	@AfterClass
	public void cleanEnvironment() {
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()
		.confirmDelete();
	}
}
