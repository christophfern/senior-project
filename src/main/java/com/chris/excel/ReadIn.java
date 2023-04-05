package com.chris.excel;

import com.chris.entities.Population;
import com.chris.entities.Room;
import com.chris.entities.Student;
import javafx.util.Pair;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

    // public static final String SAMPLE_XLSX_FILE_PATH = "Documents\\testbook.xlsx";
    public static final String SAMPLE_XLSX_FILE_PATH = "Users/chrisfernandez/Documents/testbook.xls";

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


    public static Pair<ArrayList<Student>, ArrayList<Room>> readSheet(Population population, String path) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Room> classesList = new ArrayList<Room>();
        try {


            FileInputStream file = new FileInputStream(new File(path));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);


            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int rowNum = 0;
            Student student = null;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();


                int colNum = 0;
                student = new Student();
                while (cellIterator.hasNext()) {


                    double x = 0;
                    String y = null;
                    Cell cell = cellIterator.next();

                    if (rowNum < 1) {
                        Room room = new Room();
                        room.setName(cell.getStringCellValue());
                        classesList.add(room);
                    } else if (rowNum == 1) {

                    } else {

                        for (int i = 0; i < 11; i++) {
                            cell = row.getCell(i);
                            //    System.out.println(i);
                            if (cell != null) {
                                switch (i) {
                                    case 0:
                                        student.setName(cell.getStringCellValue());
                                        //      System.out.println(cell.getStringCellValue());
                                        break;

                                    case 1:
                                        student.setChoice1(cell.getStringCellValue());
                                        break;
                                    case 2:
                                        student.setChoice2(cell.getStringCellValue());
                                    case 3:
                                        student.setChoice3(cell.getStringCellValue());
                                        break;
                                    case 4:
                                        student.setChoice4(cell.getStringCellValue());
                                        break;
                                    case 5:
                                        student.setChoice5(cell.getStringCellValue());
                                        break;
                                    case 6:
                                        student.setConditionalAdmit(cell.getStringCellValue().equalsIgnoreCase("conditional"));
                                        break;
                                    case 7:
                                        if (cell == null) {
                                            student.setGender("other");
                                            System.out.println("empty");
                                        } else {
                                            student.setGender(cell.getStringCellValue());

                                        }

                                        break;
                                    case 8:
                                        if (cell == null) {
                                            student.setSportPlayed("none");
                                        } else {
                                            if (cell.getStringCellValue().toLowerCase().contains("soccer")) {
                                                student.setSportPlayed("soccer");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("football")) {
                                                student.setSportPlayed("football");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("basketball")) {
                                                student.setSportPlayed("basketball");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("softball")) {
                                                student.setSportPlayed("softball");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("baseball")) {
                                                student.setSportPlayed("baseball");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("cross country")) {
                                                student.setSportPlayed("cross country");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("cheerleading")) {
                                                student.setSportPlayed("cheerleading");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("golf")) {
                                                student.setSportPlayed("golf");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("tennis")) {
                                                student.setSportPlayed("tennis");
                                            } else if (cell.getStringCellValue().toLowerCase().contains("trainer")) {
                                                student.setSportPlayed("trainer");
                                            } else {
                                                student.setSportPlayed("none");
                                            }
                                        }

                                        break;
                                    case 9:

                                        if (cell == null) {

                                        } else {
                                            System.out.println();
                                            student.setRace(cell.getStringCellValue());
                                        }
                                        break;
                                    case 10:
                                        if (cell == null) {
                                            student.setIsInternational(false);
                                        } else {
                                            student.setIsInternational(cell.getStringCellValue().length() != 2);
                                        }
                                        break;
                                    default:

                                }

                            }
                        }
                    }


                    population.addClass(classesList);
                    colNum++;

                }
                rowNum++;


                studentList.add(student);


            }

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pair<ArrayList<Student>, ArrayList<Room>> roomStudent = new Pair<ArrayList<Student>, ArrayList<Room>>(studentList, classesList);

        return roomStudent;


    }
}
