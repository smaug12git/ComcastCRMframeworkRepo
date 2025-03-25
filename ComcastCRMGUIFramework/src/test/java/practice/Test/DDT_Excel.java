package practice.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DDT_Excel {

	@Test
	public void FetchDataFomExcel() throws EncryptedDocumentException, IOException {

		Workbook book = null;
		FileInputStream fis=null;
		Row row =null;
		Cell cell= null;

		
			 fis = new FileInputStream("./TestData/test data.xls");
			book = WorkbookFactory.create(fis);
			Sheet sh = book.getSheet("sheet2");

			int row_count = sh.getPhysicalNumberOfRows()-1;
			int cell_count = sh.getRow(0).getPhysicalNumberOfCells();

			for (int i = 1; i < row_count; i++) {
				 row = sh.getRow(i);

				for (int j = 0; j < cell_count; j++) {
					try {
						cell = row.getCell(j);
							String data = cell.getStringCellValue();
							System.out.print(data + " === ");
						}

					 catch (Exception e) {
					   row.createCell(j).setCellValue("naaaa");
					
					}
				}
				
				System.out.println();
			}
			
			
			try {
				FileOutputStream fos = new FileOutputStream("./TestData/test data.xls");
				book.write(fos);
			} catch (Exception e) {
				e.printStackTrace();
			}

		 finally {
            fis.close();
            book.close();
        }
}

	}

