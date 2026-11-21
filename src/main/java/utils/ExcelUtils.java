package utils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ExcelUtils

{


        public static String[][] readExcelData() throws IOException, InvalidFormatException {

            File file = new File("C://Users//KRISHNA//Test Data//Test Data.xlsx");

            try (XSSFWorkbook wb = new XSSFWorkbook(file)) {

                XSSFSheet sheet = wb.getSheet("Sheet1");

                if (sheet == null) {
                    throw new IllegalArgumentException("Sheet1 not found");
                }

                int rowCount = sheet.getLastRowNum();
                int cellCount = sheet.getRow(0).getLastCellNum();

                String[][] data = new String[rowCount][cellCount];

                DataFormatter formatter = new DataFormatter();

                // Skip header row
                for (int i = 1; i <= rowCount; i++) {

                    for (int j = 0; j < cellCount; j++) {

                        data[i - 1][j] = formatter.formatCellValue(
                                sheet.getRow(i).getCell(j)
                        );
                    }
                }

                return data;
            }
        }
    }



















