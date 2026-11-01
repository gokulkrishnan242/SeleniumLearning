package Utils;

import org.testng.annotations.DataProvider;

import java.util.Map;

public class ExcelDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        Map<String, Map<String, String>> excelData = ExcelReader.getExcelData();
        Object[][] data = new Object[excelData.size()][1];
        int i = 0;
        for(String key : excelData.keySet()) {
            data[i][0] = key;
            i++;
        }
        return data;
    }
}
