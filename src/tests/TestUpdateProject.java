package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

public class TestUpdateProject {

	@BeforeClass
	public void preConditions() throws IOException {
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		String filePath = System.getProperty("user.dir") + "\\src\\tests\\resources\\Data.xls";
		List<Map<String, String>> listOfMaps = xlsFile.readExcel(filePath,"ProjectData");
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
	@Test(groups = {"Acceptance"})
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
		objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()	
		.confirmDelete();
	}
}
