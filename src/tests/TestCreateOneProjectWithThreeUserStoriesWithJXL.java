package tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AddStory;
import pages.Dashboard;
import pages.Project;
import pages.UserStory;
import testNGReport.realTimeReport.RealTimeReport;
import excelFiles.ExcelSheetReader;

@Listeners(RealTimeReport.class)
public class TestCreateOneProjectWithThreeUserStoriesWithJXL {

	/**
	 * This precondition creates a new project
	 * @throws Exception
	 */
	@BeforeClass
	public void preConditions() throws Exception {	
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		List<Map<String, String>> listOfMaps = xlsFile.readExcel
				("C:\\Users\\Carlos Guevara\\workspace\\JAT\\src\\tests\\resources\\Data.xls",
						"ProjectData");
		Dashboard objDashboard = new Dashboard();	
		Project objProject = objDashboard.clickNewProject();   
		objProject.createNewProject(listOfMaps.get(0).get("Name"),
				listOfMaps.get(1).get("IterationNumber"), 
				listOfMaps.get(2).get("NumberOfDoneIterationsToShow"));
	}

	/**
	 * This test creates a new group of user stories  
	 * Verify the User Story name using User Story label
	 * @throws Exception
	 */
	@Test
	public void verifyNewUserStoriesAreCreatedCorrectly() throws Exception {   
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		List<Map<String, String>> listOfMaps = xlsFile.readExcel
				("C:\\Users\\Carlos Guevara\\workspace\\JAT\\src\\tests\\resources\\Data.xls",
						"StoryData");
		UserStory objUserStory = new UserStory();

		for(Map<String, String> list : listOfMaps){
			AddStory objAddStory = objUserStory.clickNewStoryBtn();
			objAddStory.createNewStory(list.get("Title"), list.get("Type"),	list.get("Points"), 
					list.get("State"), list.get("Owner"), list.get("Description"),
					list.get("Acceptance Criteria"));
			//Verify New User Story is created
			Assert.assertTrue(objUserStory.getUserStoryName().contains(list.get("Title")));
		}	
	}

	/**
	 * This function will clean the environment
	 */
	@AfterClass
	public void cleanEnvironment() {
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()
		.confirmDelete();
	}
}
