package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import excelFiles.ExcelSheetReader;
import pages.Dashboard;
import pages.Project;
import pages.UserStory;
import testNGReport.realTimeReport.RealTimeReport;

/**
 *  * 
 * @author carlos guevara
 *
 */
@Listeners(RealTimeReport.class)
public class TestCreateNewProject {

	/*
	 * This test creates a new project  
	 * Verify the project name using User Story label
	 */
	@Test
	public void verifyNewProjectIsCreatedCorrectly() throws IOException {  
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		List<Map<String, String>> listOfMaps = xlsFile.readExcel
				("C:\\Users\\Carlos Guevara\\workspace\\JAT\\src\\tests\\resources\\Data.xls",
						"ProjectData");
		Dashboard objDashboard = new Dashboard();
		for(Map<String, String> list : listOfMaps){		
			Project objProject = objDashboard.clickNewProject();
			objProject.createNewProject(list.get("Name"), list.get("IterationNumber"),
					list.get("NumberOfDoneIterationsToShow"));
			UserStory objUserStory = new UserStory();
			Assert.assertEquals(objUserStory.getProjectName(), list.get("Name"));
			objDashboard =objUserStory.clickDashboardBtn();
			objDashboard.deleteProject()
						.confirmDelete();
		}
	}
}