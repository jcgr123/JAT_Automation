//package tests;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import pages.AddStory;
//import pages.Dashboard;
//import pages.Project;
//import pages.UserStory;
//
//public class TestHappyPath {
//	
//	WebDriver driver;
//	
//	@BeforeClass
//	public void setup() {
//		String projectName = "1stNewProject";
//		String iterationsNumber = "2";
//		String newStory = "1sthappyPath";
//		String newType = "Bug";
//		String newPoints = "2";
//		String storyState = "Unstarted";
//		String newOwner = "Juan Carlos Guevara Ramirez";
//		String newDescription = "Description";
//		String newAcceptance = "Priority 1";
//		Dashboard objDashboard = new Dashboard();
//		Project objProject = objDashboard.clickNewProject();
//		UserStory objUserStory = objProject.createNewProject(projectName,iterationsNumber);	
//		AddStory objAddStory = objUserStory.clickNewStoryBtn();
//		objUserStory = objAddStory.createNewStory(newStory,  newType,
//				newPoints, storyState,
//				newOwner, newDescription,
//				newAcceptance);
//	}
//	
//	@Test
//	public void verifyUserStoryCompletesHappyPathCorrectly() {	
//		UserStory objUserStory = new UserStory();
//		AddStory objAddStory = new AddStory();	
//		String storyState = "Started";
//		driver.navigate().refresh();
//		objUserStory.clickDropDownIceboxUserStory();
//		objUserStory = objAddStory.setNewStoryState(storyState);
//		objUserStory = objAddStory.clickSaveUserStory();
//		
//		
//	}
//	
//	@AfterClass
//	public void cleanEnvironment() {
//		UserStory objUserStory = new UserStory();
//		Dashboard objDashboard = objUserStory.clickDashboardBtn();
//		objDashboard.deleteProject()
//					.confirmDelete();
//	}
//}
