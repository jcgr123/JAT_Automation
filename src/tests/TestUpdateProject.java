package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import excelFiles.ExcelSheetReader;
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
	public void preConditions() throws IOException {
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		List<Map<String, String>> listOfMaps = xlsFile.readExcel
				("C:\\Users\\Carlos Guevara\\workspace\\JAT\\src\\tests\\resources\\Data.xls",
						"ProjectData");
		Dashboard objDashboard = new Dashboard();	
		Project objProject = objDashboard.clickNewProject();   
		UserStory objUserStory = objProject.createNewProject(listOfMaps.get(0).get("Name"),
				listOfMaps.get(1).get("IterationNumber"), 
				listOfMaps.get(2).get("NumberOfDoneIterationsToShow"));
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
