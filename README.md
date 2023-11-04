import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {

    public static void writeObjectsToExcel(List<Person> persons, String filePath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Persons");

            int rowNum = 0;
            for (Person person : persons) {
                Row row = sheet.createRow(rowNum++);
                Cell nameCell = row.createCell(0);
                nameCell.setCellValue(person.getName());

                Cell ageCell = row.createCell(1);
                ageCell.setCellValue(person.getAge());
            }

            // Write the workbook content to the file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
    }

    public static void main(String[] args) {
        // Sample data
        List<Person> persons = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        String filePath = "output.xlsx";

        try {
            writeObjectsToExcel(persons, filePath);
            System.out.println("Data written to Excel successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
