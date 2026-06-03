package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	@DataProvider  (name= "LoginData")
	public String[][] getData() throws IOException 
	{
		String path = ".\\TestData\\OpenCard_LoginData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
	int totalRows = xlutil.getRowCount("Sheet1");
	int totalCol = xlutil.getCellCount("Sheet1",1);
	
	String loginData[][]= new String[totalRows][totalCol];
	
	for(int r=1;r<=totalRows;r++)
	{
		for(int c=0;c<totalCol;c++)
		{
			loginData [r-1][c]= xlutil.getCellData("Sheet1",r,c);
	
		}
		
	}
	return loginData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
