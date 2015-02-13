package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import framework.pages.Dashboard;
import framework.pages.Project;
import framework.pages.UserStory;
import framework.utils.ExcelSheetReader;

/**
 *  
 * @author carlos guevara
 *
 */
public class TestCreateNewProject {

	/*
	 * This test creates a new project  
	 * Verify the project name using User Story label
	 */
	@Test
	public void verifyNewProjectIsCreatedCorrectly() throws IOException {  
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		String filePath = System.getProperty("user.dir") + "\\src\\tests\\resources\\Data.xls";
		List<Map<String, String>> listOfMaps = xlsFile.readExcel(filePath,"ProjectData");
		Dashboard objDashboard = new Dashboard();
		for(Map<String, String> list : listOfMaps){		
			Project objProject = objDashboard.clickNewProject();
			objProject.createNewProject(list.get("Name"), list.get("IterationNumber"),
					list.get("NumberOfDoneIterationsToShow"));
			UserStory objUserStory = new UserStory();
			Assert.assertEquals(objUserStory.getProjectName(), list.get("Name"));
			objDashboard = objUserStory.clickDashboardBtn();
			objDashboard.deleteProject()
						.confirmDelete();
		}
	}
}