package com.makemytrip.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public String getCellData(String sheetName, int row, int col) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row sheetRow = sheet.getRow(row);
            Cell cell = sheetRow.getCell(col);
            return cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
