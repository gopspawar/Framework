package learnautomation.utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtil() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\Desktop\\TestFile.xlsx");
            workbook = WorkbookFactory.create(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.toString();
    }
}
