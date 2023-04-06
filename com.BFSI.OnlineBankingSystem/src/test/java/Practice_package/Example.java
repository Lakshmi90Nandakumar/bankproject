package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Example {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\multipedata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Details");
		
		Object empData[][]= { 	{"EmpId","EName","Job"},
								{101,"Siri","Sr Tester"},
								{105,"rupendra","Team Lead"},
								{106,"ram","TL"},
								};
		int row = empData.length;
		int col = empData[0].length;
		
		for (int i = 0; i < row; i++) 
		{
			Row r = sh.createRow(i);
			for (int j = 0; j < col; j++) 
			{
				Cell c = r.createCell(j);
				Object data = empData[i][j];
				
				if(data instanceof String)
					 c.setCellValue((String)data);
				if(data instanceof Integer)
					 c.setCellValue((Integer)data);						
			}
		}
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\multipedata.xlsx");
		wb.write(fos);
		System.out.println("Excel Updated");
		wb.close();
	}

}
