package framework.provider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import framework.utils.ReadExcelFile;

/**
 *  * 
 * @author carlos guevara
 *
 */
public class DataproviderClass {

	/**
	 *  Function that provides data from this matrix
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
		ReadExcelFile objExcelFile = new ReadExcelFile();
		String filePath = System.getProperty("user.dir") + "\\src\\tests\\resources";
		Object[][] data = objExcelFile.readExcel(filePath,"UserStoryData.xlsx","Data");
		return data;
	}
}
