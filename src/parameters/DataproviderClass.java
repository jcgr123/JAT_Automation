package parameters;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import excelFiles.ReadExcelFile;

/**
 *  * 
 * @author carlos guevara
 *
 */

public class DataproviderClass {


	/**
	 *  Function is  reading data from this matrix
	 * @return 
	 */
	 
	@DataProvider(name = "SearchProvider")
	public static Object[][] getDataFromDataprovider() {
		return new Object[][] {

				{"Story1","Bug","1","Unstarted","Juan Carlos Guevara Ramirez",
					"Description 1","Optimized poorly"},
					{"Story2","Spike","2","Unstarted","Juan Carlos Guevara Ramirez",
						"Description 2","Optimized medium"},
						{"Story3","Bug","3","Unstarted","Juan Carlos Guevara Ramirez",
							"Description 3","Optimized high"}};   
	}

	/**
	 * Function is calling readExcel function to read data from excel file
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "UserStoryData")
	public static Object[][] getDataFromXlsx() throws IOException {
		//Create a object of ReadExcelFile class
		ReadExcelFile objExcelFile = new ReadExcelFile();
		//Prepare the path of excel file
		String filePath = System.getProperty("user.dir")+"\\src\\tests\\resources";
		//Call read file method of the class to read data
		Object[][] data = objExcelFile.readExcel(filePath,"UserStoryData.xlsx","Data");
		return data;
	}
}
