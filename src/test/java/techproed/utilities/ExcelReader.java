package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    Workbook workbook;
    Sheet sheet;

    public ExcelReader(String filePath, String sheetName) {

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getCellData(int rowNumber, int cellNumber) {
        Cell cell = sheet.getRow(rowNumber).getCell(cellNumber);
        return cell.toString();
    }

    public int rowCount() {
        return sheet.getLastRowNum();

    }


}
