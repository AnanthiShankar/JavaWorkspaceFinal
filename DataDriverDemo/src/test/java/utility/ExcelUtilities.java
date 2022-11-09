package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	private static XSSFSheet ExcelWorksheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell cell;
	private static XSSFRow Row;
	
	
	public static void setExcelFile(String path,String sheetName) throws Exception{
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook=new XSSFWorkbook(ExcelFile);
			ExcelWorksheet=ExcelWBook.getSheet(sheetName);
		}catch(Exception e){
			  throw(e);
		}
	}
	
	public static Object[][] getTableArray(String FilePath,String SheetName) throws Exception{
		String [][] tableArray=null;
		try {
			FileInputStream ExcelFile = new FileInputStream("C:\\Users\\Administrator\\JavaWorkspace\\DataDriverDemo\\src\\test\\java\\testdata\\TestData.xlsx");
			ExcelWBook=new XSSFWorkbook(ExcelFile);
			ExcelWorksheet=ExcelWBook.getSheet(SheetName);
			int startRow =1;
			int startCol =1;
			int ci,cj;
			int totalRows=ExcelWorksheet.getLastRowNum();
			int totalCols=2;
			tableArray= new String[totalRows][totalCols];
			ci=0;
			for (int i=startRow;i<=totalRows;i++,ci++) {
				cj=0;
				for (int j=startCol;j<=totalCols;j++,cj++) {
					tableArray[ci][cj]=getCelldata(i,j);
					System.out.println(tableArray[ci][cj]);
			}
			
					
		}
	}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return(tableArray);
  
  }
  public static String getCelldata(int rowNo,int colNo) throws Exception {
	  try {
		  cell=ExcelWorksheet.getRow(rowNo).getCell(colNo);
		   String cellData=cell.getStringCellValue();
		  return cellData;	  
	  }catch(Exception e){
		  throw(e);
	  }
	  
  }
  public static String getTestcaseName(String testCase) throws Exception{
	  
	  String value=testCase;
	  try {
		  int position = value.indexOf("@");
		  value=value.substring(0, position);
		  position=value.lastIndexOf(".");
		  value=value.substring(position+1);
		  return value;
		  }catch (Exception e){
			  throw(e);
		  }
  		
	  }
  
  public static int getRowUsed() throws Exception{
	  try {
		  int rowCount=ExcelWorksheet.getLastRowNum();
		  return rowCount;
	  }catch (Exception e){
		  throw(e);
	  }
  }
  
  public static int getRowContent(String TestCaseName,int colNo) throws Exception{
	  int i;
	  try {
		  int rowCount=ExcelUtilities.getRowUsed();
		  for (i=0;i<rowCount;i++) {
			  if (ExcelUtilities.getCelldata(i, colNo).equalsIgnoreCase(TestCaseName)) {
				  break;
			  }
		  }
		  return i;
	  }catch (Exception e){
		  throw(e);
	  }
  }
}

 