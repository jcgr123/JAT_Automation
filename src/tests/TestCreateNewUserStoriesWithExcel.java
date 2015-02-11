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
public class TestCreateNewUserStoriesWithExcel {

	@BeforeClass
	public void preConditions() throws IOException {			
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

	/*
	 * This test creates a new user Story with an .xlsx file data 
	 * Verify the user story is created with the name provided
	 */
	@Test(dataProvider = "UserStoryData", dataProviderClass = DataproviderClass.class)
	public void verifyNewUserStoryIsCreatedWithTasksCorrectly(String strNewStory, 
			String strNewType,String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription, String strNewAcceptance) {		

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
	public void cleanEnvironment() {
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()	
		.confirmDelete();
	}
}
