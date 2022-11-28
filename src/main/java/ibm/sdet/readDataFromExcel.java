package ibm.sdet;

import java.io.*;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFCell;

public class readDataFromExcel {

	public static void main(String[] args)throws IOException{
	
	String pathsheet ="C:\\Users\\PARU\\Downloads\\first.xlsx";
	File file =new File(pathsheet);
	FileInputStream fis=new FileInputStream(file);
	
	@SuppressWarnings("resource")
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet1= wb.getSheet("Sheet1");
	XSSFRow row1 =sheet1.getRow(1);
   System.out.println(row1.getCell(1).getStringCellValue());
	}
}