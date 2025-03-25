package practice.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DDT_excel_2DArray {
	
	@Test
	public void getdataFromExcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis;
		Workbook book;
		FileOutputStream fos;
		
		fis = new FileInputStream("./TestData/test data.xls");
		book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("sheet2");
		
		int row_count = sh.getPhysicalNumberOfRows()-1;
		int cell_count = sh.getRow(0).getPhysicalNumberOfCells();
		
		String [][] st= new String[row_count][cell_count];
		
		for(int i=0;i<row_count;i++) {
					
			for(int j=0;j<cell_count;j++) {
				try {
					st[i][j]=sh.getRow(i+1).getCell(j).toString();
				} catch(Exception e) {	
						st[i][j]="NA";
					}
					
				System.out.print(st[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
		System.out.println("========================================");
				
		for(int i=0;i<row_count;i++) {
			for(int j=0;j<cell_count;j++) {
				try {
					st[i][j]=sh.getRow(i+1).getCell(j).toString();
				} catch(Exception e) {	
						sh.getRow((i+1)).createCell(j).setCellValue(st[i][j]);
				}
			}
		}
		
		fos= new FileOutputStream("./TestData/test data.xls");
		book.write(fos);
		fos.flush();
		
//		for(int i=0;i<row_count;i++) {
//			for(int j=0;j<cell_count;j++) {
//				System.out.print(sh.getRow((i+1)).getCell(j).toString()+" ");
//				System.out.print("\t");
//			}
//			System.out.println();
//		}
		
		book.close();
}
			
			
}	
	

		
	


