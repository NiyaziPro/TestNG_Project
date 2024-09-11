package techproed.tests.day19_pageobjectmodel_excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C04_ExcelReaderTest {


    @Test
    public void testExcelReader() {
        String filePath = "src/test/java/techproed/resources/adminTestData.xlsx";
        String sheetName = "customer_info";

        ExcelReader excelReader = new ExcelReader(filePath, sheetName);

        String email = excelReader.getCellData(1,0);
        String password = excelReader.getCellData(1,1);

        System.out.println("E-Mail : "+email+"\nPassword : "+password);

        System.out.println("===============================================");

        String email1 = excelReader.getCellData(3,0);
        String password1 = excelReader.getCellData(3,1);

        System.out.println("E-Mail : "+email1+"\nPassword : "+password1);
        System.out.println("===============================================");

        String email2 = excelReader.getCellData(5,0);
        String password2 = excelReader.getCellData(5,1);

        System.out.println("E-Mail : "+email2+"\nPassword : "+password2);
        System.out.println("===============================================");

        System.out.println("Rows count : " + excelReader.rowCount());


    }
}
