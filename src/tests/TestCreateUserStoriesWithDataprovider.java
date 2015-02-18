package tests;

import java.io.IOException;
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
import framework.provider.DataproviderClass;
import framework.utils.ExcelSheetReader;

/**
 *  
 * @author carlos guevara
 *
 */
public class TestCreateUserStoriesWithDataprovider {

	@BeforeClass
	public void preConditions() throws IOException {
		ExcelSheetReader xlsFile = new ExcelSheetReader();	
		String filePath = System.getProperty("user.dir") + "\\src\\tests\\resources\\Data.xls";
		List<Map<String, String>> listOfMaps = xlsFile.readExcel(filePath,"ProjectData");
		Dashboard objDashboard = new Dashboard();	
		Project objProject = objDashboard.clickNewProject();   
		objProject.createNewProject(listOfMaps.get(0).get("Name"),
				listOfMaps.get(1).get("IterationNumber"), 
				listOfMaps.get(2).get("NumberOfDoneIterationsToShow"));
	}

	/*
	 * This test creates a new user story with a matrix of data 
	 * Verify the user story is created with the name provided
	 */
	@Test(dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class,
			groups = {"Acceptance"})
	public void testMethod(String strNewStory, String strNewType,
			String strNewPoints, String strStoryState,
			String strNewOwner, String strNewDescription,
			String strNewAcceptance) throws InterruptedException {

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
	public void cleanEnvironment(){
		UserStory objUserStory = new UserStory();
		Dashboard objDashboard = objUserStory.clickDashboardBtn();
		objDashboard.deleteProject()	
		.confirmDelete();
	}
}
