package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.Dashboard;
import framework.pages.Project;
import framework.pages.UserStory;
import framework.utils.ExcelSheetReader;

/**
 *  
 * @author Carlos Guevara
 *
 */
public class TestUpdateProject {

	/*
	 * This test creates a new project  and updates it
	 * Verify the project updated the name using User Story label
	 */
	@Test(groups = {"Acceptance"})
	public void verifyANewProjectIsUpdatedCorrectly() throws IOException {    	    	     
		String projectName = "1stNewProjectUpdated";
		String iterationsNumber = "3";
		String doneIterationsToShow = "3";
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		String filePath = System.getProperty("user.dir") + "\\src\\tests\\resources\\Data.xls";
		List<Map<String, String>> listOfMaps = xlsFile.readExcel(filePath,"ProjectData");
		Dashboard objDashboard = new Dashboard();	
		Project objProject = objDashboard.clickNewProject();   
		UserStory objUserStory = objProject.createNewProject(listOfMaps.get(0).get("Name"),
				listOfMaps.get(0).get("IterationNumber"), 
				listOfMaps.get(0).get("NumberOfDoneIterationsToShow"));
		objDashboard = objUserStory.clickDashboardBtn();
		objProject = objDashboard.clickUpdateProject();
		objProject.updateProject(projectName,iterationsNumber,doneIterationsToShow);
		objUserStory = objDashboard.clickSelectFirstProject();
		//Verify New Project is created
		Assert.assertTrue(objUserStory.getProjectName().contains(projectName));
		objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()	
		.confirmDelete();
	}
}
