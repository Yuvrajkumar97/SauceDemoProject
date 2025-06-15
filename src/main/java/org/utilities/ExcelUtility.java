package org.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static String excelPath = "./TestCases.xlsx";
    static Workbook workbook;
    static Sheet sheet;

    public static void loadSheet(String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(excelPath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public static boolean shouldRun(String testCaseID) {
        for (Row row : sheet) {
            Cell tcCell = row.getCell(0);
            if (tcCell != null && tcCell.getStringCellValue().equalsIgnoreCase(testCaseID)) {
                String runMode = row.getCell(2).getStringCellValue();
                return runMode.equalsIgnoreCase("Yes");
            }
        }
        return false;
    }

    public static void writeResult(String testCaseID, String result) throws IOException {
        for (Row row : sheet) {
            Cell tcCell = row.getCell(0);
            if (tcCell != null && tcCell.getStringCellValue().equalsIgnoreCase(testCaseID)) {
                Cell resultCell = row.createCell(3);
                resultCell.setCellValue(result);
                break;
            }
        }
        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

}
