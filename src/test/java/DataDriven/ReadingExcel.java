package DataDriven;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadingExcel {

	public static void main(String[] args) throws IOException {
	    FileInputStream File=new FileInputStream("C:\\Users\\ganes\\eclipse-workspace\\Ganeshvarma\\TestData\\Data.xlsx");
	    @SuppressWarnings("resource")
        XSSFWorkbook workbook=new XSSFWorkbook(File);
        XSSFSheet sheet= workbook.getSheet("Sheet1"); //workbook.getsheet(0);
		
		int totalrows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(1).getLastCellNum();
		
		System.out.println(totalrows);
		System.out.println(totalcells);
		
		for(int r=0;r<totalrows;r++)
		{
			XSSFRow currentrow=sheet.getRow(r);
			for(int c=0; c<totalcells;c++)
			{
				String value =currentrow.getCell(c).toString();
				System.out.print(value+"         ");
			}
			System.out.println();
		}
	}

}
