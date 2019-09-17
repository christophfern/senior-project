import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadIn {
    /*public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Calculate Simple Interest");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Pricipal");
        header.createCell(1).setCellValue("RoI");
        header.createCell(2).setCellValue("Time");
        header.createCell(3).setCellValue("Interest (P r t)");

        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(14500d);
        dataRow.createCell(1).setCellValue(9.25);
        dataRow.createCell(2).setCellValue(3d);
        dataRow.createCell(3).setCellFormula("A2*B2*C2");

        try {
            FileOutputStream out = new FileOutputStream(new File("formulaDemo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

            readSheetWithFormula();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

        public static final String SAMPLE_XLSX_FILE_PATH = "Documents\\testbook.xlsx";

        public static void readIn() throws IOException, InvalidFormatException {

            // Creating a Workbook from an Excel file (.xls or .xlsx)
          //  Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

            // Retrieving the number of sheets in the Workbook
          //  System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");


            // Getting the Sheet at index zero
        //    Sheet sheet = workbook.getSheetAt(0);

            // Create a DataFormatter to format and get each cell's value as String
            DataFormatter dataFormatter = new DataFormatter();

            // 1. You can obtain a rowIterator and columnIterator and iterate over them
            System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
          //  Iterator<Row> rowIterator = sheet.rowIterator();
         /*   while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Now let's iterate over the columns of the current row
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }*/

            // 2. Or you can use a for-each loop to iterate over the rows and columns
         /*   System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
            for (Row row: sheet) {
                for(Cell cell: row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }


            // Closing the workbook
            workbook.close();*/
        }


    private static void printCellValue(Cell cell) {

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;

            default:
                System.out.print("");
        }

        System.out.print("\t");
    }

    public static void readSheet() {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\Chris Fernandez\\Documents\\testbook.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    double x=0;
                    String y=null;
                    Cell cell = cellIterator.next();
                    //If it is formula cell, it will be evaluated otherwise no change will happen
                    switch (evaluator.evaluateInCell(cell).getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:
                      x  = cell.getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_STRING:
                          y  =cell.getStringCellValue();
                            break;

                        default:
                        //do nothing

                            break;
                    }
                    System.out.println(x);
                    System.out.println(y);
                }
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
