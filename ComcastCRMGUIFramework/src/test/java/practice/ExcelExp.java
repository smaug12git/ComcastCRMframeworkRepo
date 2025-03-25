package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelExp {

	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis= new FileInputStream("./TestData/test data.xls");
		Workbook book = WorkbookFactory.create(fis);
		int rowcount = book.getSheet("Sheet2").getPhysicalNumberOfRows();
		int cellcount = book.getSheet("Sheet2").getRow(1).getLastCellNum();
		
		 Row row = null;
		
		for(int i=0;i<rowcount;i++)
		{
			try {
			row = book.getSheet("Sheet2").getRow(i);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			for(int j=0;j<cellcount;j++)
			{
				String data = row.getCell(j).toString();
				System.out.println(data);
				
			}
		
		}
		
		
		
	}

}
