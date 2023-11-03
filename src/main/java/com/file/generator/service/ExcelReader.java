package com.file.generator.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class ExcelReader {

    @Scheduled(cron = "0 0 15 * * ?") // Executes every day at 3:00 PM
    public void executeTask() {
        // Your task logic goes here
        System.out.println("Scheduled task executed every 2 minutes: " + new Date());
        getExcelFile();
    }

    public static void getExcelFile() {
        String filePath = "C:/Users/choud/Downloads/File generate/File-generate/src/example.xlsx";
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Map<String, List<Map<String, String>>> sheetData = new HashMap<>();

            // Iterate through all sheets in the workbook
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                List<Map<String, String>> rows = new ArrayList<>();

                // Iterate through each row in the sheet
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Map<String, String> rowData = new HashMap<>();

                    // Iterate through each cell in the row
                    Iterator<Cell> cellIterator = row.iterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellValue = formatCellValue(cell);
                        // Use cell.getColumnIndex() to get the column index if needed
                        rowData.put("Column " + cell.getColumnIndex(), cellValue);
                    }
                    rows.add(rowData);
                }
                sheetData.put(sheet.getSheetName(), rows);
            }

            // Print the extracted data from all sheets
            for (Map.Entry<String, List<Map<String, String>>> entry : sheetData.entrySet()) {
                System.out.println("Sheet Name: " + entry.getKey());
                List<Map<String, String>> rows = entry.getValue();
                for (Map<String, String> row : rows) {
                    System.out.println(row);
                }
                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to format cell values appropriately
    private static String formatCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
