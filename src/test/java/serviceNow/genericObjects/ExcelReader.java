package serviceNow.genericObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static String MDF = System.getProperty("user.dir") + "\\resources\\MasterData.xlsx";
	private static Map<String, String> map = new HashMap<>();
	XSSFWorkbook wb;
	
	public String GetEnvironment(String WorkSheet, String testcasename,String columnname) throws IOException {
		FileInputStream fis;
		int k =0;
		int l =0;
		try 
		{
			fis = new FileInputStream(MDF);
			wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(WorkSheet);
			int rows = ws.getPhysicalNumberOfRows();
			int cols = ws.getRow(0).getPhysicalNumberOfCells();
			for (int j = 0; j < cols; j++) {
				if(ws.getRow(0).getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase(columnname))
				{ 
					k=j;
					break;
				}
			}
			for(int i=1;i<rows;i++){
				if(ws.getRow(i).getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase(testcasename)) 
				{
					l = i;
					break;
				}
			}
			map.put(columnname, ws.getRow(l).getCell(k,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
		}
		catch (Exception e){e.printStackTrace(); } 
		return map.get(columnname);
	}
	
	public String GetData(String WorkSheet, String testcasename,String columnname) throws IOException {
		FileInputStream fis;
		int k =0;
		int l =0;
		try 
		{
			fis = new FileInputStream(MDF);
			wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(WorkSheet);
			int rows = ws.getPhysicalNumberOfRows();
			int cols = ws.getRow(0).getPhysicalNumberOfCells();
			for (int j = 0; j < cols; j++) { 
				if(ws.getRow(0).getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase(columnname))
				{ 
					k=j;
					break;
				}
			}
			for(int i=1;i<rows;i++){
				if(ws.getRow(i).getCell(1,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase(testcasename)) 
				{
					l = i;
					break;
				}
			}
			map.put(columnname, ws.getRow(l).getCell(k,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
		}
		catch (Exception e){e.printStackTrace(); } 
		return map.get(columnname);
		}
	}
