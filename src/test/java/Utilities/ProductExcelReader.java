package Utilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ProductExcelReader {
	 // This method reads data from Excel and returns it as a List of Maps with column headings
    public static List<Map<String, String>> readExcelDataWithHeaders(String filePath) throws IOException, InvalidFormatException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);  // Get the first sheet
        List<Map<String, String>> data = new ArrayList<>();

        // Read the header row
        Row headerRow = sheet.getRow(0);  // First row is the header
        int columnCount = headerRow.getPhysicalNumberOfCells();
        List<String> headers = new ArrayList<>();

        // Extract headers (column names)
        for (int i = 0; i < columnCount; i++) {
            headers.add(headerRow.getCell(i).toString().trim()); // Added trim to remove extra spaces
        }

        // Read the data rows
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {  // Starting from the second row
            Row row = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();
            
            // Process each cell in the row
            for (int j = 0; j < columnCount; j++) {
                String cellValue = getCellValue(row.getCell(j));  // Use helper method to get the cell value
                rowData.put(headers.get(j), cellValue);  // Mapping column name to cell data
            }
            data.add(rowData);
        }

        workbook.close();
        fis.close();  // Ensure to close the input stream
        return data;
    }

    // Utility method to get the value of a cell as a String
    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";  // Return empty string if the cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();  // For text cells, return the trimmed string value
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();  // For date cells, return the string representation of the date
                } else {
                    return String.valueOf(cell.getNumericCellValue());  // For numeric cells, return as string
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());  // For boolean cells, return the string representation
            default:
                return "";  // Return empty string for other types
        }
    }
}
