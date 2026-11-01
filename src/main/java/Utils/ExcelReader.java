package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelReader {

    public static Map<String, Map<String, String>> getExcelData() {

        Map<String, Map<String, String>> testData = new LinkedHashMap<>();

        try{
            FileInputStream fis = new FileInputStream("src/test/resources/testData/testData.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("userData");
            DataFormatter formatter = new DataFormatter();
            Row header = sheet.getRow(0);
            for(int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String key = formatter.formatCellValue(row.getCell(0));
                Map<String, String> rowData = new LinkedHashMap<>();
                for(int j = 1; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);

                    String columnHeader = formatter.formatCellValue(header.getCell(j));
                    String rowValue = formatter.formatCellValue(row.getCell(j));

                    rowData.put(columnHeader, rowValue);
                }

                testData.put(key, rowData);
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print(testData.size());
        return testData;
    }

    public static Map<String, String> getRowValues(String key) {
        Map<String, Map<String, String>> ExcelData = getExcelData();
        Map<String, String> rowValues = ExcelData.get(key);
        return rowValues;
    }
}


