//Package that contains all project main classes
package pages;

//Libraries Used
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	//DataDriven Class initialization as public class
public class DataDriven {

	// Methods
	public ArrayList<String> getData(String testcaseName) throws IOException {
		// identify testcases column by scanning the entire 1st row
		// once column is identified then scan entire testcases column to identify
		// login testcase , after you grab login testcase row = pull all data of that
		// row and feed into test

		// create new arraylist of type string
		ArrayList<String> array = new ArrayList<String>();

		// file input stream
		FileInputStream fis = new FileInputStream("src/test/resources/testDataFiles/TestClassExcel.xlsx");

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				// create a new sheet
				XSSFSheet sheet = workbook.getSheetAt(i);

				// iterates through sheet to get all rows
				Iterator<Row> rows = sheet.iterator();

				// moves to next row
				Row firstRow = rows.next();

				// moves to every cell in first row
				Iterator<Cell> cell = firstRow.cellIterator();

				// moves to next cell
				// cell.next();

				int k = 0;
				int coloumn = 0;

				// check if next cell is present
				while (cell.hasNext()) {
					Cell cellvalue = cell.next();
					if (cellvalue.getStringCellValue().equalsIgnoreCase("Testcases")) {

						coloumn = k;
						// that is your desired column
					}
					k++;
				}
				//System.out.println(coloumn);

				while (rows.hasNext()) {
					Row rowvalue = rows.next();
					if (rowvalue.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {

						Iterator<Cell> cv = rowvalue.cellIterator();

						while (cv.hasNext()) {

						

							array.add(cv.next().getStringCellValue());

						}

					}

				}

			}

		}
		return array;

	}

}
