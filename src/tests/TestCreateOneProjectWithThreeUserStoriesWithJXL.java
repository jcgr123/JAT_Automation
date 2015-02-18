package tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.AddStory;
import framework.pages.Dashboard;
import framework.pages.Project;
import framework.pages.UserStory;
import framework.utils.ExcelSheetReader;

/**
 * 
 * @author Carlos Guevara
 *
 */
public class TestCreateOneProjectWithThreeUserStoriesWithJXL {

	/**
	 * This precondition creates a new project with info from data.xls
	 * @throws Exception
	 */
	@BeforeClass
	public void preConditions() throws Exception {	
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		String filePath = System.getProperty("user.dir") + "\\src\\tests\\resources\\Data.xls";
		List<Map<String, String>> listOfMaps = xlsFile.readExcel(filePath,"ProjectData");
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
	@Test(groups = {"Acceptance"})
	public void verifyOneprojectWithThreeNewUserStoriesAreCreatedCorrectly() throws Exception {   
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		String filePath = System.getProperty("user.dir") + "\\src\\tests\\resources\\Data.xls";
		List<Map<String, String>> listOfMaps = xlsFile.readExcel(filePath,"StoryData");
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
