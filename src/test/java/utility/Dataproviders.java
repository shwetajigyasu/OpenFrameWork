package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
           		String path=".\\TestData\\opencartData.xlsx";
		ExcelUtility util=new ExcelUtility(path);
		int totalRow=util.getRowCount(path ,"Sheet1");
		int totalColum=util.getColumnCount(path ,"Sheet1",1);
		
		String logindata[][]=new String[totalRow][totalColum];
		
		for(int i=1;i<=totalRow;i++) {
			
			for(int j=0;j<totalColum;j++) {
				logindata[i-1][j]=util.getCellData(path, "Sheet1", i, j);
			}
				
		}
		
		return logindata;
		
	}

}
